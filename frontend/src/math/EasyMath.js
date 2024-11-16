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
    // State to store the selected icon for the math problem
    const [selectedIcon, setSelectedIcon] = useState(null);

    // List of icons that will be used in the math problem
    const iconList = [
        "fa-apple-whole", // Apple icon
        "fa-candy-cane",  // Candy Cane icon
        "fa-lemon",       // Lemon icon
        "fa-heart",       // Heart icon
        "fa-carrot",      // Carrot icon
    ];

    // Function to get a random icon from the icon list
    const getRandomIcon = () => {
        const randomIcon = iconList[Math.floor(Math.random() * iconList.length)];
        return randomIcon; // Returns a random icon
    }

    // Fetch a beginner-level math problem from the API when the component loads
    useEffect(() => {
        // Fetch the math problem data
        fetch(`http://localhost:8080/api/v1/math/Beginner`)
            .then(response => response.json()) // Parse the JSON response from the API
            .then(data => {
                setMathProblem(data); // Set the math problem in the state
                setSelectedIcon(getRandomIcon()); // Set a random icon for the problem
            })
            .catch(error => console.error('Error fetching math problem:', error)); // Log any errors
    }, []); // Empty dependency array means this effect runs once after the initial render

    // Function to check if the user's answer is correct
    const checkAnswer = () => {
        if (mathProblem) { // Ensure that a math problem has been fetched
            // Compare the user's answer with the correct answer from the API
            const isCorrect = parseFloat(userAnswer) === mathProblem.answer;
            // Update feedback message based on whether the answer is correct or not
            setFeedback(isCorrect ? "Correct! Good job!" : "Almost there, don't give up!");
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
                    {/* Render the same random icon for the numerator */}
                    <p>
                        Numerator:{mathProblem.numerator}</p> {" "}
                    {[...Array(mathProblem.numerator)].map((_, i) => (
                        <span key={i} role="img" aria-label="icon" style={{ fontSize: "24px" }}>
                            <i className={`fa-solid ${selectedIcon}`}></i> {/* Render icon */}
                        </span>
                    ))}

                    {/* Render the same random icon for the denominator */}
                    <p>
                        <p>Denominator: {mathProblem.denominator}</p>{" "}
                        {[...Array(mathProblem.denominator)].map((_, i) => (
                            <span key={i} role="img" aria-label="icon" style={{ fontSize: "24px" }}>
                                <i className={`fa-solid ${selectedIcon}`}></i> {/* Render icon */}
                            </span>
                        ))}
                    </p>
                    {/* Input field for the user to type their answer */}
                    <input
                        type="number"
                        value={userAnswer}
                        onChange={(e) => setUserAnswer(e.target.value)} // Update the user's input
                        placeholder="Enter your answer" // Placeholder text for the input field
                    />
                    {/* Button to submit the user's answer */}
                    <button onClick={checkAnswer}>Submit Answer</button>
                    {/* Display feedback message based on the user's answer */}
                    <p>{feedback}</p>
                </div>
            )}
            </div>
        </div>
    );
};

export default Easy;
