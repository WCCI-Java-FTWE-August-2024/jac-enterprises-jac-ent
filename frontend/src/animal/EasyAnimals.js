import React, { useState, useEffect } from "react";
import { BrowserRouter as Routes, Route, Link } from "react-router-dom";

function EasyAnimals() {
    const [questions, setQuestions] = useState({}); // Initialize as an object
    const [error, setError] = useState(null);
    // const [feedback, setFeedback] = useState(""); // Feedback for the user

    // Function to fetch beginner questions from the backend
    useEffect(() => {
        fetchNewQuestion();
    }, []);
        
    const fetchNewQuestion = () => {
        fetch("http://localhost:8080/api/v1/animals/Beginner")
            .then((response) => {
                if (!response.ok) {
                    throw new Error("Network response was not ok");
                }
                return response.json();
            })
            .then((data) => {
                setQuestions(data); // Set the fetched questions to state
            })
            .catch((error) => {
                setError(error.message);
            });
    };

    // const checkAnswer = (choice, answer) =>{
    //     if (choice === questions.answerChoices(answer)) {
    //         setFeedback ("correct!")
    //     } else {
    //         setFeedback("wrong. Try again")
    //     }
    //     };

    return (
        <div>
            <div className="page-top">
                <Link to="/animal/Animal"><img src="https://cdn.pixabay.com/photo/2012/04/02/16/03/back-24838_1280.png" alt="Back button"/></Link>
                <h2>Preschool Animals</h2>
            </div>

            {questions.questionText && ( // Check if questionText exists
                <div className="question-container">
                    <h3>{questions.questionText}</h3>
                    <ul>
                        {questions.answerChoices && questions.answerChoices.map((choice, index) => ( // Ensure answerChoices exists
                            <button key={index} onClick={checkAnswer}>{choice}</button>
                        ))}
                    </ul>
                </div>
            )}
        </div>
    );
}

export default EasyAnimals;
