import React, { useState, useEffect } from 'react';
import { Link } from 'react-router-dom';

// Easy component for displaying a beginner-level math problem
const Easy = () => {
    // State to hold the math problem data fetched from the API
    const [mathProblem, setMathProblem] = useState(null);
    // State to hold the user's answer input
    const [userAnswer, setUserAnswer] = useState("");
    // State to hold feedback on whether the user's answer is correct or not
    const [feedback, setFeedback] = useState("");
    // State to track whether the answer is correct or not
    const [, setAnsweredCorrectly] = useState(false);
    // State to control the visibility of the "Next Question" button
    const [showNext, setShowNext] = useState(false);

    // Fetch a beginner-level math problem from the API when the component loads
    useEffect(() => {
        fetch(`http://localhost:8080/api/v1/math/Beginner`)
            .then(response => response.json()) // Parse the JSON response
            .then(data => setMathProblem(data)) // Set the fetched math problem in state
            .catch(error => console.error('Error fetching math problem:', error)); // Log any errors
    }, []);

    // Function to check if the user's answer is correct
    const checkAnswer = () => {
        if (mathProblem) { // Ensure a math problem is loaded before checking the answer
            const isCorrect = parseFloat(userAnswer) === mathProblem.answer; // Compare user answer to the API-provided answer
            setFeedback(isCorrect ? "Correct! Good job!" : "Almost there, don't give up!"); // Update feedback message based on correctness
        }
    };

    return (
        <div>
            {/* Navigation back button */}
            <div className="page-top">
                <Link to="/math/Math">
                    <img
                        src="https://cdn.pixabay.com/photo/2012/04/02/16/03/back-24838_1280.png"
                        alt="Back button" // Image for the back button
                    />
                </Link>
                <h2>Preschool Math</h2>
            </div>
            <div className="problem-content">
            {/* Display the math problem and answer form */}
            <h1>Easy Math Problem</h1>
            {mathProblem && ( // Ensure that mathProblem is loaded before rendering
                <div>
                    {/* Display the operation type (e.g., addition, subtraction) */}
                    <p>Operation: {mathProblem.operation}</p>
                    <p>Numerator: {mathProblem.numerator}</p>
                    <p>Denominator: {mathProblem.denominator}</p>
                    <p>Answer: {mathProblem.answer}</p>

                    {/* Input for the user to enter their answer */}
                    <input
                        type="number"
                        value={userAnswer}
                        onChange={(e) => setUserAnswer(e.target.value)} // Update the user's input
                        placeholder="Enter your answer" // Placeholder text for the input field
                    />
                    <button onClick={checkAnswer}>Submit Answer</button> {/* Button to check answer */}
                    <p>{feedback}</p> {/* Display feedback message */}
                </div>
            )}
            </div>
        </div>
    );
};

export default Easy;
