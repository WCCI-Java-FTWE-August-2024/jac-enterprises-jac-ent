import React, { useState, useEffect } from "react";
import { BrowserRouter as Routes, Route, Link } from "react-router-dom";

function HardAnimals() {
  const [questions, setQuestions] = useState(null); // Initialize as null
  const [error, setError] = useState(null);
  const [feedback, setFeedback] = useState(""); // Feedback for the user
  const [showImage, setShowImage] = useState(false); // State to control the correct answer image

  // Function to fetch Advanced questions from the backend
  useEffect(() => {
    fetchNewQuestion();
  }, []);

  const fetchNewQuestion = () => {
    fetch("http://localhost:8080/api/v1/animals/Advanced")
      .then((response) => {
        if (!response.ok) {
          throw new Error("Network response was not ok");
        }
        return response.json();
      })
      .then((data) => {
        setQuestions(data); // Set the fetched questions to state
        setFeedback(""); // Clear feedback on new question
        setShowImage(false); // Hide the image when a new question loads
      })
      .catch((error) => {
        setError(error.message);
      });
  };

  const checkAnswer = (choice, answerIndex) => {
    if (choice === questions.answerChoices[answerIndex]) {
      setFeedback("Correct!");
      setShowImage(true); // Show the image when the answer is correct
      // Move to the next question after a short delay
      setTimeout(fetchNewQuestion, 5000); // 5-second delay before fetching new question
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
        <h2>Middle School Animals</h2>
      </div>

      {error && <div className="error-message">{error}</div>} {/* Display error message */}
      
      {questions ? ( // Check if questions is not null
        <div className="question-container">
          <h3>{questions.questionText}</h3>
          <ul>
            {questions.answerChoices && questions.answerChoices.map((choice, index) => (
              <button key={index}
              style={{ margin: "10px" }} // Add margin here
             onClick={() => checkAnswer(choice, questions.answer)}>
                {choice}
              </button>
            ))}
          </ul>
          {feedback && <div className="feedback">{feedback}</div>} {/* Display feedback */}
          
          {/* Display the image when the answer is correct */}
          {showImage && (
            <img
              src={questions.imageUrl}
              alt="Correct answer celebration"
              className="correct-answer-image"
              style={{ width: '300px', height: 'auto' }}
            />
          )}
        </div>
      ) : (
        <div>Loading...</div> // Loading state
      )}
    </div>
  );
}

export default HardAnimals;
