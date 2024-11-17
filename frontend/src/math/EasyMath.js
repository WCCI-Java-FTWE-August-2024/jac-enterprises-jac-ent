import React, { useState, useEffect } from 'react';
import { Link } from 'react-router-dom';

// Helper function to retrieve a cookie by name
const getCookie = (name) => {
    const match = document.cookie.match(new RegExp('(^| )' + name + '=([^;]+)'));
    return match ? match[2] : null;
};

// Easy component for displaying a beginner-level math problem
const Easy = () => {
    // State to hold the math problem data fetched from the API
    const [mathProblem, setMathProblem] = useState(null);
    const [userAnswer, setUserAnswer] = useState(""); // User's answer input
    const [feedback, setFeedback] = useState(""); // Feedback for correctness
    const [selectedIcon, setSelectedIcon] = useState(null); // Random icon for the problem
    const [answeredCorrectly, setAnsweredCorrectly] = useState(false); // Track if the answer is correct
    const [showNext, setShowNext] = useState(false); // Show "Next Question" button
    const [incorrectAttempts, setIncorrectAttempts] = useState(0); // Count incorrect attempts
    const [showGiveUp, setShowGiveUp] = useState(false); // Show "Give Up" button
    const [revealAnswer, setRevealAnswer] = useState(false); // Reveal the correct answer

    // List of icons for math problems
    const iconList = [
        "fa-apple-whole", // Apple icon
        "fa-candy-cane",  // Candy Cane icon
        "fa-lemon",       // Lemon icon
        "fa-heart",       // Heart icon
        "fa-carrot",      // Carrot icon
    ];

    // Retrieve token from cookies
    const token = getCookie("authToken");

    // Function to get a random icon from the icon list
    const getRandomIcon = () => {
        return iconList[Math.floor(Math.random() * iconList.length)];
    };

    useEffect(() => {
        fetchNewQuestion(); // Initial fetch when the component loads
    }, []);

    // Function to fetch a new question from the API
    const fetchNewQuestion = () => {
        fetch("http://localhost:8080/api/v1/math/Beginner", {
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
                setMathProblem(data);
                setSelectedIcon(getRandomIcon());
                setUserAnswer("");
                setFeedback("");
                setAnsweredCorrectly(false);
                setShowNext(false);
                setIncorrectAttempts(0);
                setShowGiveUp(false);
                setRevealAnswer(false);
            })
            .catch(error => console.error('Error fetching math problem:', error));
    };

    // Function to check the user's answer
    const checkAnswer = () => {
        if (mathProblem) {
            const isCorrect = parseFloat(userAnswer) === mathProblem.answer;
            setAnsweredCorrectly(isCorrect);
            setFeedback(isCorrect ? "Correct! Good job!" : "Almost there, don't give up!");

            if (isCorrect) {
                setShowNext(true); // Show "Next Question" button
                setShowGiveUp(false); // Hide "Give Up" button
            } else {
                setIncorrectAttempts(prev => {
                    const newAttempts = prev + 1;
                    if (newAttempts >= 3) {
                        setShowGiveUp(true); // Show "Give Up" button after 3 wrong attempts
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
                        alt="Back button" // Image for the back button
                    />
                </Link>
                <h2>Preschool Math</h2>
            </div>
            <div className="problem-content">
            {/* Display the math problem and answer form */}
            <h1>Easy Math Problem</h1>
            {mathProblem && (
                <div>
                    {/* Display the operation type */}
                    <p>Operation: {mathProblem.operation}</p>

                    {/* Render the numerator icons */}
                    <p>Numerator: {mathProblem.numerator}</p>
                    {[...Array(mathProblem.numerator)].map((_, i) => (
                        <span key={i} role="img" aria-label="icon" style={{ fontSize: "24px" }}>
                            <i className={`fa-solid ${selectedIcon}`}></i>
                        </span>
                    ))}

                    {/* Render the denominator icons */}
                    <p>Denominator: {mathProblem.denominator}</p>
                    {[...Array(mathProblem.denominator)].map((_, i) => (
                        <span key={i} role="img" aria-label="icon" style={{ fontSize: "24px" }}>
                            <i className={`fa-solid ${selectedIcon}`}></i>
                        </span>
                    ))}

                    {/* Input field for the user to type their answer */}
                    <div>
                        <input
                            type="number"
                            value={userAnswer}
                            onChange={(e) => setUserAnswer(e.target.value)}
                            placeholder="Enter your answer"
                        />
                        {/* Submit button for checking the answer */}
                        <button onClick={checkAnswer} disabled={revealAnswer}>Submit Answer</button>
                    </div>

                    {/* Display feedback message */}
                    <p>{feedback}</p>

                    {/* Display the correct answer if "Give Up" is clicked */}
                    {revealAnswer && (
                        <p>The correct answer is: {mathProblem.answer}</p>
                    )}

                    {/* Show "Give Up" button after 3 incorrect attempts */}
                    {showGiveUp && !revealAnswer && (
                        <button onClick={handleGiveUp}>Give Up</button>
                    )}

                    {/* Show "Next Question" button after correct answer or "Give Up" */}
                    {showNext && (
                        <button onClick={fetchNewQuestion}>Next Question</button>
                    )}
                </div>
            )}</div>
        </div>
        
    );
};

export default Easy;
