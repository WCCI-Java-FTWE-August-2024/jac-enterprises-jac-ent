import React, {useState, useEffect} from "react";
import { BrowserRouter as Routes, Route, Link } from "react-router-dom";


function HardColors() {
    // State variables to store question data and any errors
    const [questionData, setQuestionData] = useState(null); // Initially null to check for null
    const [error, setError] = useState(null); // Initially null to check for null

    // Fetch beginner-level question data when the component loads
    useEffect(() => {
        // Use fetch and .then() to retrieve the data
        fetch("http://localhost:8080/api/v1/color/Advanced").then((response) => {
            if(!response.ok) {
                throw new Error(`Failed to fetch question`);
            }
            return response.json(); // Converts the response to JSON
        }).then((data) => {
            setQuestionData(data); // Store the fetched data in state
        }).catch((error) => {
            setError(error.message); // Set error message if something goes wrong
        });
    }, []);
    return (
        <div>
                <div className="page-top">
                <Link to="/color/Color"><img src="https://cdn.pixabay.com/photo/2012/04/02/16/03/back-24838_1280.png" alt="Back button"/></Link>
                <h2>Middle School Colors</h2>
            </div>

            {/* Show loading state if questionData is still null and there’s no error */}
            {/* If there is no question data, it moves to next condition. Same with if there is no error. Only displays the <p> tag if both questionData and error are false*/}
            {!questionData && !error && <p>Loading question...</p>}
            
            {/* Display error message if there's an error */}
            {error && <p>Error: {error}</p>}


            {/* Display the question content once data is available */}
            {questionData && (
                <div>
                    {/* Display the question text */}
                    <h3>{questionData.questionText}</h3>
                    {/* Display the image url */}
                    <img src={questionData.imageUrl} alt="Question visual" style={{ width: '300px', height: 'auto' }} />
                    {/* Display the question choices*/}
                    <div>
                        <h4>Choose an answer:</h4>
                        {/* Map over the answer choices and display each as a button */}
                        {/* Adds the index as the key of the button, and the choice string as the text of the button */}
                        {questionData.answerChoices.map((choice, index) => (
                            <button key={index}>{choice}</button>
                        ))}
                    </div>
                </div>
            )}
        </div>
    );
}

export default HardColors;