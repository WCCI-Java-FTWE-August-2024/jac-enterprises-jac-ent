import React, { useState, useEffect } from "react";
import { BrowserRouter as Routes, Route, Link } from "react-router-dom";

function EasyAnimals() {
    const [questions, setQuestions] = useState([]); // State to hold the fetched questions
    const [error, setError] = useState(null); // 

    // Function to fetch beginner questions from the backend
    useEffect(() => {
        fetchNewQuestion();
    }, []);
        
        // Fetching questions from the backend
       const fetchNewQuestion = () =>{

        fetch("http://localhost:8080/api/v1/animals/Beginner")
            .then((response) => {
                if (!response.ok) {
                    throw new Error("Network response was not ok");
                }
                return response.json(); // Parse the JSON from the response
            })
            .then((data) => {
                setQuestions(data); // Set the fetched questions to state
                // setCurrentQuestion(data[0]); // Set the first question as the current question
            })
            .catch((error) => {
                setError(error.message);
            });
    };

    // // useEffect to fetch questions when the component mounts
    // useEffect(() => {
    //     fetchBeginnerQuestions(); // Call the function to fetch questions
    // }, []); // Empty dependency array means this runs once on mount

    return (
        <div>
            <div className="page-top">
                <Link to="/animal/Animal"><img src="https://cdn.pixabay.com/photo/2012/04/02/16/03/back-24838_1280.png" alt="Back button"/></Link>
                <h2>Preschool Animals</h2>
            </div>

            
            {questions && ( // Check if there is a current question
                <div className="question-container">
                    <h3>{questions.questionText}</h3> {/* Display the question text */}
                    <div>
                        {questions.answerChoices.map((option, index) => ( // Map through options
                            <button key={index}>{option}</button> // Display each option
                        ))}
                    </div>
                </div>
            )}
        </div>
    );
}

export default EasyAnimals;
