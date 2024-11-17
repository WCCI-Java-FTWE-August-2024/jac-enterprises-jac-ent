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
    const [userAnswer, setUserAnswer] = useState(""); // User's answer input
    const [feedback, setFeedback] = useState(""); // Feedback for correctness
    const [showNext, setShowNext] = useState(false); // Show "Next Question" button
    const [incorrectAttempts, setIncorrectAttempts] = useState(0); // Count incorrect attempts
    const [showGiveUp, setShowGiveUp] = useState(false); // Show "Give Up" button
    const [revealAnswer, setRevealAnswer] = useState(false); // Reveal the correct answer

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
            .then(response => {
                if (!response.ok) {
                    throw new Error("Failed to fetch question.");
                }
                return response.json();
            })
            .then(data => {
                setMathProblem(data); // Set the new problem
                setUserAnswer(""); // Reset user answer field
                setFeedback(""); // Reset feedback
                setShowNext(false); // Hide "Next Question" button
                setIncorrectAttempts(0); // Reset incorrect attempts
                setShowGiveUp(false); // Hide "Give Up" button
                setRevealAnswer(false); // Reset answer reveal
            })
            .catch(error => console.error('Error fetching math problem:', error)); // Log any errors
    };

    // Function to check if the user's answer is correct
    const checkAnswer = () => {
        if (mathProblem) {
            // Check if the user's answer is correct
            const isCorrect = parseFloat(userAnswer) === mathProblem.answer;
            setFeedback(isCorrect ? "Correct! Good job!!" : "Almost there, don't give up");

            if (isCorrect) {
                setShowNext(true); // Show "Next Question" button
                setShowGiveUp(false); // Hide "Give Up" button
            } else {
                setIncorrectAttempts((prevAttempts) => {
                    const newAttempts = prevAttempts + 1;
                    if (newAttempts >= 3) {
                        setShowGiveUp(true); // Show "Give Up" button after 3 incorrect attempts
                    }
                    return newAttempts;
                });
            }
        }
    };

    // Function to handle "Give Up" action
    const handleGiveUp = () => {
        setRevealAnswer(true); // Reveal the correct answer
        setShowNext(true); // Allow moving to the next question
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
                    
                    <p>{mathProblem.numerator}</p>
                    <p>{mathProblem.operation}</p>
                    <p>{mathProblem.denominator}</p><br/>

                    {/* Input for the user to enter their answer */}
                    <input
                        type='number'
                        value={userAnswer}
                        onChange={(e) => setUserAnswer(e.target.value)} // Update userAnswer state on input change
                        placeholder="Enter your answer"
                    />
                    <button onClick={checkAnswer} disabled={revealAnswer}>Submit Answer</button> {/* Button to check answer */}
                    <p>{feedback}</p> {/* Display feedback message */}

                    {/* Display the correct answer if "Give Up" is clicked */}
                    {revealAnswer && (
                        <p>The correct answer is: {mathProblem.answer}</p>
                    )}

                    {/* Show "Give Up" button after 3 incorrect attempts */}
                    {showGiveUp && !revealAnswer && (
                        <button onClick={handleGiveUp}>Give Up</button>
                    )}

                    {/* Conditionally render the "Next Question" button */}
                    {showNext && (
                        <button onClick={fetchNewQuestion}>Next Question</button>
                    )}
                </div>
            )}</div>
        </div>
        
    );
};

export default Advanced;
