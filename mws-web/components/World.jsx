'use client';

import React, { useEffect, useRef, useState, useLayoutEffect } from 'react';
import * as d3 from 'd3';
import { useRouter } from 'next/navigation';




const World = () => {
    const ref = useRef();
    const router = useRouter();
    const [dimensions, setDimensions] = useState({ width: 480, height: 480 });

    const nodes = [
        { id: 'you', name: 'You', type: 'user', color: '#FF5C5C', size: 25 },
        { id: 'mws', name: 'MWS', color: '#E2E2E2', size: 25 },
        { id: 'cafe', name: 'Cafe', type: 'cafe', color: '#73C8FF', size: 20 },
    
        { id: 'baemin', name: 'Baemin', type: 'food-delievery', color: '#FF9F5C', size: 20 },
        { id: 'chinese', name: 'Chinese Food', type: 'food-business', color: '#FFD580', size: 15 },
        { id: 'pizza', name: 'Pizza', type: 'food-business', color: '#FFD580', size: 15 },
        { id: 'sushi', name: 'Sushi', type: 'food-business', color: '#FFD580', size: 15 },
    
        { id: 'coupang', name: 'Coupang', type: 'e-commerce', color: '#6CD9D6', size: 20 },
        { id: 'clothes', name: 'Clothes', type: 'business', color: '#A4E4D4', size: 15 },
        { id: 'electronics', name: 'Electronics', type: 'business', color: '#A4E4D4', size: 15 },
        { id: 'cosmetics', name: 'Cosmetics', type: 'business', color: '#A4E4D4', size: 15 },
      ];

    const links = [
        { source: "you", target: "mws" },

        { source: "mws", target: "baemin" },
        { source: "mws", target: "coupang" },
        { source: "mws", target: "cafe" },

        { source: "baemin", target: "chinese" },
        { source: "baemin", target: "pizza" },
        { source: "baemin", target: "sushi" },

        { source: "coupang", target: "clothes" },
        { source: "coupang", target: "electronics" },
        { source: "coupang", target: "cosmetics" },
    ];

    const updateDimensions = () => {
        // const width = ref.current.clientWidth; 
        const width = window.innerWidth;
        const height = window.innerHeight;

        setDimensions({ width, height });
    };

    useLayoutEffect(() => {
        updateDimensions();
        window.addEventListener('resize', updateDimensions);

        return () => {
            window.removeEventListener('resize', updateDimensions);
        };
    }, []);


    useEffect(() => {

        d3.select(ref.current).select("svg").remove();

        const svg = d3.select(ref.current)
            .append("svg")
            .attr("width", dimensions.width)
            .attr("height", dimensions.height);

        const simulation = d3.forceSimulation(nodes)
            .force("charge", d3.forceManyBody().strength(-200))
            .force("link", d3.forceLink(links)
                .id((d) => d.id)
                .distance(() => Math.random() * 125 + 25)
                .strength(0.03))
            .force("center", d3.forceCenter(dimensions.width / 2, dimensions.height / 2));

        const link = svg.append("g")
            .selectAll("line")
            .data(links)
            .join("line")
            .attr("stroke", "#999")
            .attr("opacity", 0.3)
            .attr("stroke-width", 1.6);

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
            .attr("r", (d) => d.size)
            .attr("fill", (d) => d.color)
            .attr("stroke", "black")
            .attr("stroke-width", 2)
            .call(d3.drag()
                .on("start", dragstarted)
                .on("drag", dragged)
                .on("end", dragended));
        


        const label = svg.append("g")
            .selectAll("text")
            .data(nodes)
            .join("text")
            .attr("text-anchor", "middle")
            .attr("dy", (d) => d.size + 20)
            .text(d => d.name);


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

        const zoomHandler = d3.zoom()
            .scaleExtent([0.1, 5]) // Set the minimum and maximum zoom scale
            .on("zoom", (event) => {
                const { transform } = event;
                svg.selectAll("g").attr("transform", transform);
            });

        svg.call(zoomHandler);



        const zoomPercentageText = svg.append("text")
            .attr("x", dimensions.width - 45)
            .attr("y", dimensions.height - 15)
            .text("100%")
            .attr("font-size", "14px");


        // Update the zoom percentage text whenever the zoom event is triggered
        zoomHandler.on("zoom", (event) => {
            const { transform } = event;
            svg.selectAll("g").attr("transform", transform);

            const zoomPercentage = Math.round(transform.k * 100);
            zoomPercentageText.text(`${zoomPercentage}%`);
        });

        const resetZoom = () => {
            svg.transition().duration(750).call(zoomHandler.transform, d3.zoomIdentity);
        };

        svg.on("dblclick.zoom", resetZoom);

        return () => {
            svg.remove();
        };
    }, [dimensions]);

    return (
        <div className={`w-full h-full`} ref={ref}></div>
    );
};

export default World;
