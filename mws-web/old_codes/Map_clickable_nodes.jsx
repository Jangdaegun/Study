'use client';

import React, { useEffect, useRef } from 'react';
import * as d3 from 'd3';

const Map = () => {
    const ref = useRef();

    useEffect(() => {
        const width = 800;
        const height = 600;

        const nodes = [
            { id: "A" },
            { id: "B" },
            { id: "C" },
            { id: "D" },
            { id: "E" },
            { id: "F" },
            { id: "G" },
            { id: "H" },
            { id: "I" },
        ];

        const links = [
            { source: "A", target: "B" },
            { source: "B", target: "C" },
            { source: "C", target: "D" },
            { source: "D", target: "E" },
            { source: "E", target: "A" },
            { source: "F", target: "B" },
            { source: "F", target: "G" },
            { source: "G", target: "C" },
            { source: "G", target: "H" },
            { source: "G", target: "I" },
            { source: "H", target: "D" },
            { source: "I", target: "A" },
        ];


        const svg = d3.select(ref.current)
            .append("svg")
            .attr("width", width)
            .attr("height", height);

        const simulation = d3.forceSimulation(nodes)
            .force("link", d3.forceLink(links).id(d => d.id).distance(100))
            .force("charge", d3.forceManyBody().strength(-400))
            .force("center", d3.forceCenter(width / 2, height / 2));

        const link = svg.append("g")
            .selectAll("line")
            .data(links)
            .join("line")
            .attr("stroke", "#999")
            .attr("stroke-width", 2);

        let selectedNodes = [];

        const node = svg.append("g")
            .selectAll("circle")
            .data(nodes)
            .join("circle")
            .attr("r", 20)
            .attr("fill", "#69b3a2")
            .on("click", (event, d) => {
                let elapsed = 0;

                if (selectedNodes.length < 2 && !selectedNodes.includes(d.id)) {
                    selectedNodes.push(d.id);
                    d3.select(event.currentTarget).attr("fill", "#ffab00");
                }

                if (selectedNodes.length === 2) {
                    const path = dijkstra(nodes, links, selectedNodes[0], selectedNodes[1]);

                    // Set the initial position of the packet
                    const startPos = nodes.find(node => node.id === path[0]);
                    packet.attr("cx", startPos.x).attr("cy", startPos.y);


                    link
                        .attr("stroke", (d) => {
                            return path.includes(d.source.id) && path.includes(d.target.id) ? "#ffab00" : "#999";
                        })
                        .attr("stroke-width", (d) => {
                            return path.includes(d.source.id) && path.includes(d.target.id) ? 4 : 2;
                        });

                    // Animate the packet along the path
                    const duration = 500 * (path.length - 1);
                    packet.style("visibility", "visible");
                    const intervalID = setInterval(() => {
                        elapsed += 1000 / 60;
                        const t = elapsed / duration;
                        if (t >= 1) {
                            packet.style("visibility", "hidden");
                            clearInterval(intervalID); // clear the interval
                        } else {
                            const pos = interpolatePositions(path, t);
                            packet.attr("cx", pos.x).attr("cy", pos.y);
                        }
                    }, 1000 / 60); // 60 FPS


                    selectedNodes = [];
                    setTimeout(() => {
                        node.attr("fill", "#69b3a2");
                        link.attr("stroke", "#999").attr("stroke-width", 2);
                        selectedNodes = []; // Reset the selectedNodes array

                    }, duration);
                }
            })

            .call(d3.drag()
                .on("start", dragstarted)
                .on("drag", dragged)
                .on("end", dragended));


        const label = svg.append("g")
            .selectAll("text")
            .data(nodes)
            .join("text")
            .attr("text-anchor", "middle")
            .attr("dy", "2.2em") // Offset the text position below the node
            .text(d => d.id);

        const packet = svg.append("circle")
            .attr("r", 5)
            .attr("fill", "red")
            .style("visibility", "hidden");



        simulation.on("tick", () => {
            link
                .attr("x1", d => d.source.x)
                .attr("y1", d => d.source.y)
                .attr("x2", d => d.target.x)
                .attr("y2", d => d.target.y);

            node
                .attr("cx", d => d.x)
                .attr("cy", d => d.y);

            label
                .attr("x", d => d.x)
                .attr("y", d => d.y);
        });

        function interpolatePositions(path, t) {
            const idx = Math.floor(t * (path.length - 1));
            const pos1 = nodes.find(node => node.id === path[idx]);
            const pos2 = nodes.find(node => node.id === path[idx + 1]);
            const tInSegment = t * (path.length - 1) - idx;

            const x = pos1.x + (pos2.x - pos1.x) * tInSegment;
            const y = pos1.y + (pos2.y - pos1.y) * tInSegment;

            return { x, y };
        }



        function dragstarted(event, d) {
            if (!event.active) simulation.alphaTarget(0.3).restart();
            d.fx = d.x;
            d.fy = d.y;
        }

        function dragged(event, d) {
            d.fx = event.x;
            d.fy = event.y;
        }

        function dragended(event, d) {
            if (!event.active) simulation.alphaTarget(0);
            d.fx = null;
            d.fy = null;
        }

        class SimpleMap {
            constructor() {
                this.map = new Object();
            }

            set(key, value) {
                this.map[key] = value;
            }

            get(key) {
                return this.map[key];
            }

            has(key) {
                return this.map.hasOwnProperty(key);
            }

            delete(key) {
                delete this.map[key];
            }

            values() {
                return Object.values(this.map);
            }
        }


        function dijkstra(nodes, links, start, end) {
            const graph = new SimpleMap();

            nodes.forEach(node => {
                graph.set(node.id, { edges: [], dist: Infinity, prev: null });
            });

            links.forEach(link => {
                graph.get(link.source.id).edges.push({ node: link.target.id, dist: 1 });
                graph.get(link.target.id).edges.push({ node: link.source.id, dist: 1 });
            });

            const unvisited = new Set(nodes.map(node => node.id));
            graph.get(start).dist = 0;

            while (unvisited.size > 0) {
                const currentId = Array.from(unvisited).reduce((minId, id) => {
                    return graph.get(id).dist < graph.get(minId).dist ? id : minId;
                }, unvisited.values().next().value);

                if (currentId === end) break;

                unvisited.delete(currentId);
                const currentNode = graph.get(currentId);

                currentNode.edges.forEach(edge => {
                    const neighbor = graph.get(edge.node);
                    const newDist = currentNode.dist + edge.dist;

                    if (newDist < neighbor.dist) {
                        neighbor.dist = newDist;
                        neighbor.prev = currentId;
                    }
                });
            }

            const path = [];
            let currentId = end;

            while (currentId !== null) {
                path.unshift(currentId);
                currentId = graph.get(currentId).prev;
            }

            return path;
        }



        return () => {
            svg.remove();
        };
    }, []);

    return (
        <div ref={ref}></div>
    );
};

export default Map;
