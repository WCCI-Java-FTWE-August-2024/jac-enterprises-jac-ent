import React, { useState, useEffect } from "react";
import { BrowserRouter as Routes, Route, Link } from "react-router-dom";

function EasyAnimals() {
  const [questions, setQuestions] = useState(null); // Initialize as null
  const [error, setError] = useState(null);
  const [feedback, setFeedback] = useState(""); // Feedback for the user

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
        setFeedback(""); // Clear feedback on new question
      })
      .catch((error) => {
        setError(error.message);
      });
  };

  const checkAnswer = (choice, answerIndex) => {
    if (choice === questions.answerChoices[answerIndex]) {
      setFeedback("Correct!");
      // Move to the next question after a short delay
    } else {
      setFeedback("Wrong. Try again.");
    }
  };

  return (
    <div>
      <div className="page-top">
        <Link to="/animal/Animal">
          <img
            src="https://cdn.pixabay.com/photo/2012/04/02/16/03/back-24838_1280.png"
            alt="Back button"
          />
        </Link>
        <h2>Preschool Animals</h2>
      </div>

      {error && <div className="error-message">{error}</div>} {/* Display error message */}
      
      {questions ? ( // Check if questions is not null
        <div className="question-container">
          <h3>{questions.questionText}</h3>
          <ul>
            {questions.answerChoices && questions.answerChoices.map((choice, index) => (
              
                <button key={index}  onClick={() => checkAnswer(choice, questions.answer)}> {/* Pass choice to checkAnswer */}
                  {choice}
                </button>
            ))}
          </ul>
          {feedback && <div className="feedback">{feedback}</div>} {/* Display feedback */}
        </div>
      ) : (
        <div>Loading...</div> // Loading state
      )}
    </div>
  );
}

export default EasyAnimals;
