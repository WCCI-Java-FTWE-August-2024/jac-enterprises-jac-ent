import React, { useState, useEffect } from "react";
import { BrowserRouter as Routes, Route, Link } from "react-router-dom";

// Helper function to retrieve a cookie by name
const getCookie = (name) => {
    const match = document.cookie.match(new RegExp('(^| )' + name + '=([^;]+)'));
    return match ? match[2] : null;
};

function MediumColors() {
    // State variables to store question data and any errors
    const [questionData, setQuestionData] = useState(null); // Initially null to check for null
    const [error, setError] = useState(null); // Initially null to check for null
    const [feedback, setFeedback] = useState(""); // To display feedback on answer
    const [answeredCorrectly, setAnsweredCorrectly] = useState(false); // Track if the answer is correct
    const [showNext, setShowNext] = useState(false); // Control visibility of "Next Question" button
    const [incorrectAttempts, setIncorrectAttempts] = useState(0); // Track incorrect attempts
    const [showGiveUp, setShowGiveUp] = useState(false); // Control visibility of "Give Up" button
    const [revealAnswer, setRevealAnswer] = useState(false); // Track if the answer should be revealed

    // Retrieve token from cookies
    const token = getCookie("authToken");

    // Fetch intermediate-level question data when the component loads
    useEffect(() => {
        fetchNewQuestion();
    }, []);

    const fetchNewQuestion = () => {
        // Reset states for the new question
        setIncorrectAttempts(0);
        setShowGiveUp(false);
        setRevealAnswer(false);
        setFeedback("");
        setAnsweredCorrectly(false);
        setShowNext(false);

        // Use fetch and .then() to retrieve the data
        fetch("http://localhost:8080/api/v1/color/Intermediate", {
            headers: {
                Authorization: `Bearer ${token}`, // Use the retrieved token
            },
        })
            .then((response) => {
                if (!response.ok) {
                    throw new Error(`Failed to fetch question`);
                }
                return response.json(); // Converts the response to JSON
            })
            .then((data) => {
                setQuestionData(data); // Store the fetched data in state
            })
            .catch((error) => {
                setError(error.message); // Set error message if something goes wrong
            });
    };

    // Handle the answer button click
    const checkAnswer = (choice, answerIndex) => {
        if (choice === questionData.answerChoices[answerIndex]) {
            setAnsweredCorrectly(true); // Set as correct answer
            setFeedback("Correct!"); // Provide feedback
            setShowNext(true); // Show "Next Question" button
            setShowGiveUp(false); // Hide "Give Up" button
        } else {
            setAnsweredCorrectly(false); // Set as incorrect answer
            setFeedback("Wrong. Try again"); // Provide feedback
            setIncorrectAttempts((prev) => {
                const newCount = prev + 1;
                if (newCount >= 2) setShowGiveUp(true); // Show "Give Up" button after 2 wrong attempts
                return newCount;
            });
        }
    };

    // Handle the "Give Up" button click
    const handleGiveUp = () => {
        setRevealAnswer(true); // Reveal the correct answer
        setShowNext(true); // Allow the user to proceed to the next question
    };

    return (
        <div>
            <div className="page-top">
                <Link to="/color/Color">
                    <img
                        src="https://cdn.pixabay.com/photo/2012/04/02/16/03/back-24838_1280.png"
                        alt="Back button"
                    />
                </Link>
                <h2>Elementary School Colors</h2>
            </div>
            <div className="problem-content">
            {/* Show loading state if questionData is still null and there’s no error */}
            {!questionData && !error && <p>Loading question...</p>}

            {/* Display error message if there's an error */}
            {error && <p>Error: {error}</p>}

            {/* Display the question content once data is available */}
            {questionData && (
                <div>
                    {/* Display the question text */}
                    <h3>{questionData.questionText}</h3>
                    {/* Display the image url */}
                    <img
                        src={questionData.imageUrl}
                        alt="Question visual"
                        style={{ width: "300px", height: "auto" }}
                    />
                    {/* Display the question choices */}
                    <div>
                        <h4>Choose an answer:</h4>
                        {questionData.answerChoices.map((choice, index) => (
                            <button
                                key={index}
                                onClick={() => checkAnswer(choice, questionData.answer)}
                                disabled={revealAnswer} // Disable buttons if the answer is revealed
                            >
                                {choice}
                            </button>
                        ))}
                    </div>

                    {/* Display feedback message based on the user's answer */}
                    <p>{feedback}</p>

                    {/* Show "Give Up" button after 3 wrong attempts */}
                    {showGiveUp && !answeredCorrectly && !revealAnswer && (
                        <button onClick={handleGiveUp}>Give Up</button>
                    )}

                    {/* Reveal the correct answer if the user gives up */}
                    {revealAnswer && (
                        <p>
                            The correct answer is:{" "}
                            {questionData.answerChoices[questionData.answer]}
                        </p>
                    )}

                    {/* Show "Next Question" button only if the answer is correct or user gives up */}
                    {showNext && (
                        <button onClick={fetchNewQuestion}>Next Question</button>
                    )}
                </div>
<<<<<<< HEAD
            )}
            </div>
=======
            )}</div>
>>>>>>> origin/main
        </div>
        
    );
}

export default MediumColors;
