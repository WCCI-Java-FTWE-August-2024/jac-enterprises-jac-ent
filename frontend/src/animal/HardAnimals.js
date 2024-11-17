import React, { useState, useEffect } from "react";
import { Link } from "react-router-dom";

// Helper function to retrieve a cookie by name
const getCookie = (name) => {
  const match = document.cookie.match(new RegExp("(^| )" + name + "=([^;]+)"));
  return match ? match[2] : null;
};

function HardAnimals() {
  const [questions, setQuestions] = useState(null); // Initialize as null
  const [error, setError] = useState(null);
  const [feedback, setFeedback] = useState(""); // Feedback for the user
  const [showImage, setShowImage] = useState(false); // State to control the correct answer image
  const [showNextButton, setShowNextButton] = useState(false); // State for showing the "Next Question" button
  const [incorrectAttempts, setIncorrectAttempts] = useState(0); // Track incorrect attempts
  const [showGiveUp, setShowGiveUp] = useState(false); // Show "Give Up" button after 3 wrong attempts
  const [revealAnswer, setRevealAnswer] = useState(false); // Control answer reveal

  // Retrieve token from cookies
  const token = getCookie("authToken");

  // Function to fetch Advanced questions from the backend
  useEffect(() => {
    fetchNewQuestion();
  }, []);

  const fetchNewQuestion = () => {
    // Reset states for the new question
    setIncorrectAttempts(0);
    setShowGiveUp(false);
    setRevealAnswer(false);
    setFeedback("");
    setShowImage(false);
    setShowNextButton(false);

    fetch("http://localhost:8080/api/v1/animals/Advanced", {
      headers: {
        Authorization: `Bearer ${token}`, // Use the retrieved token
      },
    })
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

  const checkAnswer = (choice, answerIndex) => {
    if (choice === questions.answerChoices[answerIndex]) {
      setFeedback("Correct!");
      setShowImage(true); // Show the image when the answer is correct
      setShowNextButton(true); // Show the "Next Question" button after correct answer
      setShowGiveUp(false); // Hide "Give Up" button if correct
    } else {
      setFeedback("Wrong. Try again.");
      setIncorrectAttempts((prev) => {
        const newAttempts = prev + 1;
        if (newAttempts >= 2) {
          setShowGiveUp(true); // Show "Give Up" button after 2 wrong attempts
        }
        return newAttempts;
      });
    }
  };

  const handleGiveUp = () => {
    setRevealAnswer(true); // Reveal the correct answer
    setShowNextButton(true); // Allow the user to proceed to the next question
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
        <h2>Middle School Animals</h2>
      </div>
      <div className="problem-content">
      {error && <div className="error-message">{error}</div>} {/* Display error message */}
      {questions ? ( // Check if questions is not null
        <div className="question-container">
          <h3>{questions.questionText}</h3>
          <ul>
            {questions.answerChoices &&
              questions.answerChoices.map((choice, index) => (
                <button
                  key={index}
                  style={{ margin: "10px" }}
                  onClick={() => checkAnswer(choice, questions.answer)}
                  disabled={revealAnswer} // Disable buttons if the answer is revealed
                >
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
                style={{ width: "300px", height: "auto" }}
              />
            </div>
          )}

          {/* Show "Give Up" button after 2 wrong attempts */}
          {showGiveUp && !showNextButton && !revealAnswer && (
            <button onClick={handleGiveUp}>Give Up</button>
          )}

          {/* Reveal the correct answer if the user gives up */}
          {revealAnswer && (
            <p>
              The correct answer is:{" "}
              {questions.answerChoices[questions.answer]}
            </p>
          )}

          {/* Show the "Next Question" button */}
          {showNextButton && (
            <button onClick={handleNextQuestion} style={{ marginTop: "20px" }}>
              Next Question
            </button>
          )}
        </div>
      ) : (
        <div>Loading...</div> // Loading state
      )}
      </div>
    </div>
  );
}

export default HardAnimals;
