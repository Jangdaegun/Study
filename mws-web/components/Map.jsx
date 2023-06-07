// useState와 같은 React Hook을 쓰려면 Client Side Rendering(CSR)이 필요.
// 어떤 component에서 User interaction이 필요하면(=javascript가 client side에서 실행) CSR이 필요.
// Next.js 13에서는 간단하게 'use client';만 추가하면 됨.
'use client';

import React, { useEffect, useRef, useState } from 'react';
import Link from 'next/link';
import * as d3 from 'd3';
import { useRouter } from 'next/navigation';


// Nodes와 Nodes를 연결하는 Links
const nodes = [
    { id: "profile" },
    { id: "test" },
    { id: "cafe" },
    { id: "D" },
    { id: "E" },
    { id: "F" },
    { id: "G" },
    { id: "H" },
    { id: "I" },
];

const links = [
    { source: "profile", target: "test" },
    { source: "test", target: "cafe" },
    { source: "cafe", target: "D" },
    { source: "D", target: "E" },
    { source: "E", target: "profile" },
    { source: "F", target: "test" },
    { source: "F", target: "G" },
    { source: "G", target: "cafe" },
    { source: "G", target: "H" },
    { source: "G", target: "I" },
    { source: "H", target: "D" },
    { source: "I", target: "profile" },
];


// 그래프 구조를 간단하게 저장하여 이후 길찾기에 쓰기위해 클래스를 만듬.
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

// 최단 경로 탐색 algorithm 중 하나인 다익스트라 Dijkstra
// 우선 노드 간 거리는 모두 1로 동일하게 세팅된 상황.
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

/*
interpolatePositions(graph, path, time)
그래프 상에서 두 점 사이의 위치값을 찾는 function.

1.  A에서 C로 간다고 가정. 다익스트라가 최단경로를 찾아서 path(= [A, B, C])를 내뱉음.
2.  시간(time)는 0~1사이의 값임. Start node에서 End node 까지의 걸리는 시간이 1.
    만약 time이 0.5라면 전체 여정에서 절반을 온 것. (정확히 B에 있음)
    만약 time이 1이라면 End node에 도착한 것 (C에 도착).
3.  path.length, 즉 node 수는 3개. 따라서 time * (path.length - 1)의 값은 0~2 사이. Math.floor로 time에 따른 현재 index를 구할 수 있음.
4.  만약 time 상에서 0.6만큼 왔다고 가정하면 2*0.6 = 1.2이고 index는 1임 (따라서 position1 = B, position2 = C).
5.  Packet의 위치는 B와 C 사이에서 20% 지점에 있어야 함. 즉, tInSegment = 0.2
6.  "B의 x좌표값 + (C의 x좌표값 - B의 x좌표값) * 0.2"가 현 packet의 x좌표가 됨. y도 마찬가지로 계산.
7.  x, y값을 return.
*/
function interpolatePositions(graph, path, time) {
    const index = Math.floor(time * (path.length - 1));
    const position1 = graph.get(path[index]);
    const position2 = graph.get(path[index + 1]);
    const tInSegment = time * (path.length - 1) - index;

    const x = position1.x + (position2.x - position1.x) * tInSegment;
    const y = position1.y + (position2.y - position1.y) * tInSegment;

    return { x, y };
}

const Map = () => {
    const ref = useRef();
    const [startNode, setStartNode] = useState('');
    const [endNode, setEndNode] = useState('');
    const [selectedNodes, setSelectedNodes] = useState('');
    const [findPathCallback, setFindPathCallback] = useState(null);
    const router = useRouter();

    const handleChangeStart = (event) => {
        setStartNode(event.target.value);
        setSelectedNodes((prevSelectedNodes) => ({
            ...prevSelectedNodes,
            start: event.target.value,
        }));
    };

    const handleChangeEnd = (event) => {
        setEndNode(event.target.value);
        setSelectedNodes((prevSelectedNodes) => ({
            ...prevSelectedNodes,
            end: event.target.value,
        }));
    };

    const handleFindPathClick = () => {
        if (findPathCallback) {
            findPathCallback();
        }
    };

    useEffect(() => {
        const width = 400;
        const height = 400;

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

            const node = svg.append("g")
              .selectAll("circle")
              .data(nodes)
              .join("a")
              
              .attr("style", "cursor: pointer;")
              .on("click", (event, d) => {
                event.preventDefault();
                router.push(`/${d.id}`)
              })
              .append("circle")
              .attr("r", 20)
              .attr("fill", (d) => {
                if (d.id === selectedNodes.start) {
                  return "blue";
                } else if (d.id === selectedNodes.end) {
                  return "red";
                } else {
                  return "#69b3a2";
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
            .attr("dy", "2.2em")
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

        function dragstarted(event, d) {
            event.sourceEvent.preventDefault();
            if (!event.active) simulation.alphaTarget(0.3).restart();
            d.fx = d.x;
            d.fy = d.y;
        }

        function dragged(event, d) {
            event.sourceEvent.preventDefault();
            d.fx = event.x;
            d.fy = event.y;
        }

        function dragended(event, d) {
            event.sourceEvent.preventDefault();
            if (!event.active) simulation.alphaTarget(0);
            d.fx = null;
            d.fy = null;
        }

        const findPath = () => {
            if (startNode !== '' && endNode !== '' && startNode !== endNode) {
                const graph = new SimpleMap();
                nodes.forEach(node => {
                    graph.set(node.id, node);
                });

                const path = dijkstra(nodes, links, startNode, endNode);

                // packet의 시작 위치 설정
                const startPos = graph.get(path[0]);
                packet.attr("cx", startPos.x).attr("cy", startPos.y);

                // 연결된 link를 하이라이트
                link
                    .attr("stroke", (d) => {
                        return path.includes(d.source.id) && path.includes(d.target.id) ? "#ffab00" : "#999";
                    })
                    .attr("stroke-width", (d) => {
                        return path.includes(d.source.id) && path.includes(d.target.id) ? 4 : 2;
                    });

                // Animate the packet along the path
                const duration = 500 * (path.length - 1);   // animation의 총 소요시간. 500ms * 링크
                packet.style("visibility", "visible");
                let elapsed = 0;
                const intervalID = setInterval(() => {
                    elapsed += 1000 / 60;
                    const time = elapsed / duration;
                    if (time >= 1) {
                        packet.style("visibility", "hidden");
                        clearInterval(intervalID);
                    } else {
                        const position = interpolatePositions(graph, path, time);
                        packet.attr("cx", position.x).attr("cy", position.y);
                    }
                }, 1000 / 60); // 60 FPS

                // duration만큼 시간이 지나면 link highlight를 원상태로 되돌림.
                setTimeout(() => {
                    link.attr("stroke", "#999").attr("stroke-width", 2);
                }, duration);
            }
        };

        setFindPathCallback(() => findPath);

        return () => {
            svg.remove();
        };
    }, [startNode, endNode]);

    return (
        <div>
            <div ref={ref}></div>
            <div>
                <select value={startNode} onChange={handleChangeStart}>
                    <option value="">Select start node</option>
                    {nodes.map(node => (
                        <option key={node.id} value={node.id}>
                            {node.id}
                        </option>
                    ))}
                </select>
                <select value={endNode} onChange={handleChangeEnd}>
                    <option value="">Select end node</option>
                    {nodes.map(node => (
                        <option key={node.id} value={node.id}>
                            {node.id}
                        </option>
                    ))}
                </select>
                <button onClick={handleFindPathClick}>&nbsp;&nbsp;Find Path</button>

            </div>
        </div>
    );
};

export default Map;





