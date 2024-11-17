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
    // State to hold the user's answer input
    const [userAnswer, setUserAnswer] = useState("");
    // State to hold feedback on whether the user's answer is correct or not
    const [feedback, setFeedback] = useState("");
    // State to store the selected icon for the math problem
    const [selectedIcon, setSelectedIcon] = useState(null);
    // State to track if the answer is correct or not
    const [answeredCorrectly, setAnsweredCorrectly] = useState(false);
    // State to control the visibility of the "Next Question" button
    const [showNext, setShowNext] = useState(false);

    // List of icons that will be used in the math problem
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
        const randomIcon = iconList[Math.floor(Math.random() * iconList.length)];
        return randomIcon; // Returns a random icon
    };

    useEffect(() => {
        fetchNewQuestion(); // Initial fetch when the component loads
    // eslint-disable-next-line react-hooks/exhaustive-deps
    }, []);

    // Function to fetch a new question from the API
    const fetchNewQuestion = () => {
        fetch("http://localhost:8080/api/v1/math/Beginner", {
            headers: {
                Authorization: `Bearer ${token}`, // Use the retrieved token
            },
        })
            .then(response => response.json()) // Parse the JSON response
            .then(data => {
                setMathProblem(data); // Set the new problem
                setSelectedIcon(getRandomIcon());
                setUserAnswer(""); // Reset user answer field
                setFeedback(""); // Reset feedback
                setAnsweredCorrectly(false); // Reset the answer check
                setShowNext(false); // Hide "Next Question" button initially
            })
            .catch(error => console.error('Error fetching math problem:', error)); // Log any errors
    };

    // Function to check if the user's answer is correct
    const checkAnswer = () => {
        if (mathProblem) { // Ensure that a math problem has been fetched
            const isCorrect = parseFloat(userAnswer) === mathProblem.answer;
            setAnsweredCorrectly(isCorrect); // Update the answer correctness state
            setFeedback(isCorrect ? "Correct! Good job!" : "Almost there, don't give up!");
            
            // Only show "Next Question" if the answer is correct
            if (isCorrect) {
                setShowNext(true); // Show the "Next Question" button
            } else {
                setShowNext(false); // Hide it if the answer is incorrect
            }
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
            {mathProblem && ( // Ensure that mathProblem is loaded before rendering
                <div>
                    {/* Display the operation type (e.g., addition, subtraction) */}
                    

                    {/* Render the same random icon for the numerator */}
                    <div>
                    <p>{mathProblem.numerator}</p><br/>
                    {[...Array(mathProblem.numerator)].map((_, i) => (
                        <span key={i} role="img" aria-label="icon" style={{ fontSize: "24px" }}>
                            <i className={`fa-solid ${selectedIcon}`}></i> {/* Render icon */}
                        </span>
                    ))}
                    </div>
                    <div>
                    <p>{mathProblem.operation}</p>
                    </div>
                    <div>
                    {/* Render the same random icon for the denominator */}
                    <p>{mathProblem.denominator}</p><br/>
                    {[...Array(mathProblem.denominator)].map((_, i) => (
                        <span key={i} role="img" aria-label="icon" style={{ fontSize: "24px" }}>
                            <i className={`fa-solid ${selectedIcon}`}></i> {/* Render icon */}
                        </span>
                    ))}
                    </div><br/>

                    {/* **Answer Input & Submit Button** below denominator */}
                    <div className='submit-stuff'>
                        {/* Input field for the user to type their answer */}
                        <input
                            type="number"
                            value={userAnswer}
                            onChange={(e) => setUserAnswer(e.target.value)} // Update the user's input
                            placeholder="Enter your answer" // Placeholder text for the input field
                        />
                        {/* Button to submit the user's answer */}
                        <button onClick={checkAnswer}>Submit Answer</button>
                    </div>

                    {/* Display feedback message based on the user's answer */}
                    <p>{feedback}</p>

                    {/* Conditionally render the "Next Question" button only if the answer is correct */}
                    {showNext && (
                        <button onClick={fetchNewQuestion}>Next Question</button>
                    )}
                </div>
            )}
            </div>
        </div>
    );
};

export default Easy;
