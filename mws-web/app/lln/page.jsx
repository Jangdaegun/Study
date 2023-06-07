'use client';

import { useState } from 'react';

const LLN = () => {
    const [numberOfIteration, setNumberOfIteration] = useState(0);
    const [result, setResult] = useState({ 1: 0, 2: 0, 3: 0, 4: 0, 5: 0, 6: 0 });
    const [showPercentage, setShowPercentage] = useState(false);
    const [mostRolled, setMostRolled] = useState(1);

    const handleNumberOfIterationChange = (event) => {
        setNumberOfIteration(event.target.value);
        setResult({ 1: 0, 2: 0, 3: 0, 4: 0, 5: 0, 6: 0 });
        setShowPercentage(false);
    };

    const handleRollDice = () => {
        const newResult = { 1: 0, 2: 0, 3: 0, 4: 0, 5: 0, 6: 0 }

        for (let i = 0; i < numberOfIteration; i++) {
            const rollResult = Math.floor(Math.random() * 6) + 1;
            newResult[rollResult]++;
        }

        setResult(newResult);
        setShowPercentage(true);

        let maxCount = 0;
        let mostRolledNumber = 1;
        Object.entries(newResult).forEach(([number, count]) => {
            if (count > maxCount) {
                maxCount = count;
                mostRolledNumber = number;
            }
        });
        setMostRolled(mostRolledNumber);
    };

    return (
        <div>
            <h1>Law of Large Numbers</h1>
            <br></br>
            <label>
                Number of iterations:
                <input type="number" value={numberOfIteration} onChange={handleNumberOfIterationChange} />
            </label>
            <button onClick={handleRollDice}>Roll dice</button>
            <ul>
                {Object.entries(result).map(([number, count]) => (
                    <li key={number} style={{ color: number === mostRolled ? 'green' : 'black' }}>
                        {number}: {count} &nbsp;{showPercentage && (count / numberOfIteration * 100).toFixed(2)}%
                    </li>
                ))}
            </ul>
        </div>
    );
}

export default LLN;