// src/components/Quiz.js
import React, { useState, useEffect } from 'react';
import axios from 'axios';

const Quiz = () => {
    const [questions, setQuestions] = useState([]); // State to hold questions
    const [currentQuestion, setCurrentQuestion] = useState(0); // Index of the current question
    const [score, setScore] = useState(0); // User's score
    const [difficulty, setDifficulty] = useState('Beginner'); // Selected difficulty level

    // Fetch questions based on difficulty level
    const fetchQuestions = async () => {
        try {
            const response = await axios.get(`http://localhost:8080/api/v1/animals/questions?difficulty=${difficulty}`);
            setQuestions(response.data); // Set questions from the response
        } catch (error) {
            console.error("Error fetching questions:", error);
        }
    };

    useEffect(() => {
        fetchQuestions(); // Fetch questions when the component mounts or difficulty changes
    }, [difficulty]);

    // Handle answer selection
    const handleAnswer = (index) => {
        if (index === questions[currentQuestion].correctAnswer) {
            setScore(score + 1); // Increment score if the answer is correct
        }
        setCurrentQuestion(currentQuestion + 1); // Move to the next question
    };

    // Render the quiz
    return (
        <div>
            <h1>Animal Quiz</h1>
            <h2>Difficulty: {difficulty}</h2>
            {currentQuestion < questions.length ? (
                <div>
                    <h3>{questions[currentQuestion].question}</h3>
                    <ul>
                        {questions[currentQuestion].options.map((option, index) => (
                            <li key={index} onClick={() => handleAnswer(index)}>
                                {option}
                            </li>
                        ))}
                    </ul>
                </div>
            ) : (
                <div>
                    <h2>Your Score: {score}/{questions.length}</h2>
                </div>
            )}
            <button onClick={() => setDifficulty('Beginner')}>Beginner</button>
            <button onClick={() => setDifficulty('Intermediate')}>Intermediate</button>
            <button onClick={() => setDifficulty('Advanced')}>Advanced</button>
        </div>
    );
};

export default Quiz;
