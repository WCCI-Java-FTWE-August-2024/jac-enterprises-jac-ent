import React, { useState, useEffect } from "react";
import { BrowserRouter as Routes, Route, Link } from "react-router-dom";

function EasyAnimals() {
  const [questions, setQuestions] = useState(null); // Initialize as null
  const [error, setError] = useState(null);
  const [feedback, setFeedback] = useState(""); // Feedback for the user
  const [showImage, setShowImage] = useState(false); // State to control the correct answer image
  const [showNextButton, setShowNextButton] = useState(false); // Control when to show the "Next Question" button

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
        setShowImage(false); // Hide the image when a new question loads
        setShowNextButton(false); // Hide the "Next Question" button until answered correctly
      })
      .catch((error) => {
        setError(error.message);
      });
  };

  const checkAnswer = (choice, answerIndex) => {
    if (choice === questions.answerChoices[answerIndex]) {
      setFeedback("Correct!");
      setShowImage(true); // Show the image when the answer is correct
      setShowNextButton(true); // Show the "Next Question" button after correct answer
    } else {
      setFeedback("Wrong. Try again.");
    }
  };

  const handleNextQuestion = () => {
    fetchNewQuestion(); // Fetch the next question when the button is clicked
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
      <div className="problem-content">
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
            <div>
              <img
                src={questions.imageUrl}
                alt="Correct answer celebration"
                className="correct-answer-image"
                style={{ width: '300px', height: 'auto' }}
              />
              
              {/* Show the "Next Question" button below the image */}
              {showNextButton && (
                <button onClick={handleNextQuestion} style={{ marginTop: "20px" }}>
                  Next Question
                </button>
              )}
            </div>
          )}
        </div>
      ) : (
        <div>Loading...</div> // Loading state
      )}
      </div>
    </div>
  );
}

export default EasyAnimals;
