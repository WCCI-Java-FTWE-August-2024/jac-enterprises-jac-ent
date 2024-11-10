import React, { useState, useEffect } from "react";
import { BrowserRouter as Routes, Route, Link } from "react-router-dom";

function EasyColors() {
    // State variables to store question data and any errors
    const [questionData, setQuestionData] = useState(null); // Initially null to check for null
    const [error, setError] = useState(null); // Initially null to check for null
    const [feedback, setFeedback] = useState(""); // Handle the answer button click
    const [answeredCorrectly, setAnsweredCorrectly] = useState(false); // Track if the answer is correct
    const [showNext, setShowNext] = useState(false); // Control visibility of "Next Question" button

    // Fetch beginner-level question data when the component loads
    useEffect(() => {
        fetchNewQuestion();
    }, []);

    const fetchNewQuestion = () => {
        // Use fetch and .then() to retrieve the data
        fetch("http://localhost:8080/api/v1/color/Beginner")
            .then((response) => {
                if (!response.ok) {
                    throw new Error(`Failed to fetch question`);
                }
                return response.json(); // Converts the response to JSON
            })
            .then((data) => {
                setQuestionData(data); // Store the fetched data in state
                setAnsweredCorrectly(false); // Reset answer correctness for the new question
                setShowNext(false); // Hide "Next Question" button initially
                setFeedback(""); // Reset feedback message
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
        } else {
            setAnsweredCorrectly(false); // Set as incorrect answer
            setFeedback("Wrong. Try again"); // Provide feedback
            setShowNext(false); // Hide "Next Question" button
        }
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
                <h2>Preschool Colors</h2>
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
                            >
                                {choice}
                            </button>
                        ))}
                    </div>

                    {/* Display feedback message based on the user's answer */}
                    <p>{feedback}</p>

                    {/* Show "Next Question" button only if the answer is correct */}
                    {showNext && (
                        <button onClick={fetchNewQuestion}>Next Question</button>
                    )}
                </div>
            )}
            </div>
        </div>
    );
}

export default EasyColors;
