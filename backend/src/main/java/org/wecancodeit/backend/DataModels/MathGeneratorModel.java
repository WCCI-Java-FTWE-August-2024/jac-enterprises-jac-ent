package org.wecancodeit.backend.DataModels;

// Importing custom enums for defining difficulty levels and mathematical operations
import org.wecancodeit.backend.Enums.*;

public class MathGeneratorModel {
    // Fields representing a mathematical problem's difficulty level, operation,
    // operands, and the answer
    private DifficultyLevel difficulty; // Enum representing the difficulty level (e.g., BEGINNER, INTERMEDIATE)
    private Operation operation; // Enum representing the math operation (e.g., ADDITION, SUBTRACTION)
    private float numerator; // The numerator or first operand for the problem
    private float denominator; // The denominator or second operand for the problem
    private float answer; // The answer to the mathematical problem

    // #######################################################\\
    // ################### Constructors ######################\\
    // #######################################################\\

    // Default constructor for creating an empty MathGeneratorModel instance
    public MathGeneratorModel() {
    }

    // Constructor that initializes all fields
    public MathGeneratorModel(DifficultyLevel difficulty, Operation operation, float numerator,
            float denominator) {
        this.difficulty = difficulty; // Set the difficulty level
        this.operation = operation; // Set the mathematical operation
        this.numerator = numerator; // Set the numerator
        this.denominator = denominator; // Set the denominator
    }

    // #######################################################\\
    // ############### Getters And Setters ###################\\
    // #######################################################\\

    // Getter for the 'difficulty' field
    public DifficultyLevel getDifficulty() {
        return difficulty;
    }

    // Setter for the 'difficulty' field
    public void setDifficulty(DifficultyLevel difficulty) {
        this.difficulty = difficulty; // Update the difficulty level
    }

    // Getter for the 'operation' field
    public Operation getOperation() {
        return operation;
    }

    // Setter for the 'operation' field
    public void setOperation(Operation operation) {
        this.operation = operation; // Update the mathematical operation
    }

    // Getter for the 'numerator' field
    public float getNumerator() {
        return numerator;
    }

    // Setter for the 'numerator' field
    public void setNumerator(float numerator) {
        this.numerator = numerator; // Update the numerator value
    }

    // Getter for the 'denominator' field
    public float getDenominator() {
        return denominator;
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
