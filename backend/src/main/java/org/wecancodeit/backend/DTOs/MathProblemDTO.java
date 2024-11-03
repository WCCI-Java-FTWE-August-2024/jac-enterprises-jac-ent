package org.wecancodeit.backend.DTOs;

// Importing custom enums for defining difficulty levels and mathematical operations
import org.wecancodeit.backend.Enums.*;

public class MathProblemDTO {
    // Fields representing a mathematical problem and its components
    private String problem; // The math problem as a string
    private DifficultyLevel difficulty; // Enum representing the difficulty level of the problem (e.g., EASY, MEDIUM)
    private Operation operation; // Enum representing the type of mathematical operation (e.g., ADDITION,
                                 // SUBTRACTION)
    private float numerator; // The numerator for fraction problems
    private float denominator; // The denominator for fraction problems
    private float answer; // The answer to the math problem

    // #######################################################\\
    // ################### Constructors ######################\\
    // #######################################################\\

    // Default constructor for creating an empty MathProblemDTO instance
    public MathProblemDTO() {
    }

    // Constructor that initializes all fields with provided values
    public MathProblemDTO(String problem, DifficultyLevel difficulty, Operation operation, float numerator,
            float denominator) {
        this.problem = problem; // Set the problem string
        this.difficulty = difficulty; // Set the difficulty level
        this.operation = operation; // Set the mathematical operation
        this.numerator = numerator; // Set the numerator
        this.denominator = denominator; // Set the denominator
    }

    // #######################################################\\
    // ############### Getters And Setters ###################\\
    // #######################################################\\

    // Getter for the 'problem' field
    public String getProblem() {
        return problem; // Return the problem string
    }

    // Setter for the 'problem' field
    public void setProblem(String problem) {
        this.problem = problem; // Update the problem string
    }

    // Getter for the 'difficulty' field
    public DifficultyLevel getDifficulty() {
        return difficulty; // Return the difficulty level
    }

    // Setter for the 'difficulty' field
    public void setDifficulty(DifficultyLevel difficulty) {
        this.difficulty = difficulty; // Update the difficulty level
    }

    // Getter for the 'operation' field
    public Operation getOperation() {
        return operation; // Return the mathematical operation
    }

    // Setter for the 'operation' field
    public void setOperation(Operation operation) {
        this.operation = operation; // Update the mathematical operation
    }

    // Getter for the 'numerator' field
    public float getNumerator() {
        return numerator; // Return the numerator
    }

    // Setter for the 'numerator' field
    public void setNumerator(float numerator) {
        this.numerator = numerator; // Update the numerator value
    }

    // Getter for the 'denominator' field
    public float getDenominator() {
        return denominator; // Return the denominator
    }

    // Setter for the 'denominator' field
    public void setDenominator(float denominator) {
        this.denominator = denominator; // Update the denominator value
    }

    // Getter for the 'answer' field
    public float getAnswer() {
        return answer; // Return the calculated answer
    }

    // Setter for the 'answer' field
    public void setAnswer(float answer) {
        this.answer = answer; // Update the answer value
    }
}
