import React, { useState, useEffect } from 'react';
import { Link } from 'react-router-dom';

// Helper function to retrieve a cookie by name
const getCookie = (name) => {
    const match = document.cookie.match(new RegExp('(^| )' + name + '=([^;]+)'));
    return match ? match[2] : null;
};

// Advanced component for displaying an advanced-level math problem
const Advanced = () => {
    // State to hold the math problem data fetched from the API
    const [mathProblem, setMathProblem] = useState(null);
    // State to hold the user's answer input
    const [userAnswer, setUserAnswer] = useState("");
    // State to hold feedback on whether the user's answer is correct or not
    const [feedback, setFeedback] = useState("");
    // State to track if the answer is correct or not
    const [, setAnsweredCorrectly] = useState(false);
    // State to control the visibility of the "Next Question" button
    const [showNext, setShowNext] = useState(false);

    // Retrieve token from cookies
    const token = getCookie("authToken");

    // Fetch an advanced-level math problem from the API when the component loads
    useEffect(() => {
        fetchNewQuestion(); // Initial fetch when the component loads
    }, []);

    // Function to fetch a new question from the API
    const fetchNewQuestion = () => {
        fetch("http://localhost:8080/api/v1/math/Advanced", {
            headers: {
                Authorization: `Bearer ${token}`, // Use the retrieved token
            },
        })
            .then(response => response.json()) // Parse the JSON response
            .then(data => {
                setMathProblem(data); // Set the new problem
                setUserAnswer(""); // Reset user answer field
                setFeedback(""); // Reset feedback
                setAnsweredCorrectly(false); // Reset the answer check
                setShowNext(false); // Hide "Next Question" button
            })
            .catch(error => console.error('Error fetching math problem:', error)); // Log any errors
    };

    // Function to check if the user's answer is correct
    const checkAnswer = () => {
        if (mathProblem) {
            // Check if the user's answer is correct
            const isCorrect = parseFloat(userAnswer) === mathProblem.answer;
            setAnsweredCorrectly(isCorrect); // Update correctness state
            setFeedback(isCorrect ? "Correct! Good job!!" : "Almost there, don't give up");
            setShowNext(isCorrect); // Show "Next Question" button only if the answer is correct
        }
    };

    return (
        <div>
            {/* Navigation back button */}
            <div className="page-top">
                <Link to="/math/Math">
                    <img
                        src="https://cdn.pixabay.com/photo/2012/04/02/16/03/back-24838_1280.png"
                        alt="Back button"
                    />
                </Link>
                <h2>Middle School Math</h2>
            </div>
            <div className="problem-content">
            {/* Display the math problem and answer form */}
            <h1>Advanced Math Problem</h1>
            {mathProblem && (
                <div>
                    <p>Operation: {mathProblem.operation}</p>
                    <p>Numerator: {mathProblem.numerator}</p>
                    <p>Denominator: {mathProblem.denominator}</p>

                    {/* Input for the user to enter their answer */}
                    <input
                        type='number'
                        value={userAnswer}
                        onChange={(e) => setUserAnswer(e.target.value)} // Update userAnswer state on input change
                        placeholder="Enter your answer"
                    />
                    <button onClick={checkAnswer}>Submit Answer</button> {/* Button to check answer */}
                    <p>{feedback}</p> {/* Display feedback message */}

                    {/* Conditionally render the "Next Question" button */}
                    {showNext && (
                        <button onClick={fetchNewQuestion}>Next Question</button>
                    )}
                </div>
            )}
            </div>
        </div>
    );
};

export default Advanced;
