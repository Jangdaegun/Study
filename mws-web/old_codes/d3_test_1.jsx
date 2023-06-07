'use client';

import React, { useEffect, useRef, useState } from 'react';
import * as d3 from 'd3';

const TestMap = () => {
    const ref = useRef();
    const [selectedCircle, setSelectedCircle] = useState('');

    useEffect(() => {
        const svg = d3.select(ref.current)
            .append('svg')
            .attr('width', 300)
            .attr('height', 200);

        const circles = [
            { id: 'A', cx: 50, cy: 100 },
            { id: 'B', cx: 150, cy: 100 },
            { id: 'C', cx: 250, cy: 100 },
        ];

        const circleSelection = svg.selectAll('circle')
            .data(circles)
            .join('circle')
            .attr('cx', d => d.cx)
            .attr('cy', d => d.cy)
            .attr('r', 20)
            .attr('fill', d => d.id === selectedCircle ? '#ffab00' : '#69b3a2');

        return () => {
            svg.remove();
        };
    }, [selectedCircle]);

    const handleOptionChange = (event) => {
        setSelectedCircle(event.target.value);
    };

    return (
        <div>
            <div ref={ref}></div>
            <div>
                <input
                    type="radio"
                    id="circleA"
                    name="circle"
                    value="A"
                    checked={selectedCircle === 'A'}
                    onChange={handleOptionChange}
                />
                <label htmlFor="circleA">A</label>
                <input
                    type="radio"
                    id="circleB"
                    name="circle"
                    value="B"
                    checked={selectedCircle === 'B'}
                    onChange={handleOptionChange}
                />
                <label htmlFor="circleB">B</label>
                <input
                    type="radio"
                    id="circleC"
                    name="circle"
                    value="C"
                    checked={selectedCircle === 'C'}
                    onChange={handleOptionChange}
                />
                <label htmlFor="circleC">C</label>
            </div>
        </div>
    );
};

export default TestMap;
