package org.wecancodeit.backend.BOService;

// Importing required classes and enums
import org.wecancodeit.backend.DTOs.MathProblemDTO; // Data Transfer Object for math problems
import org.wecancodeit.backend.Enums.*; // Importing all enums in the package
import java.util.Random; // Random class for generating random numbers
import org.springframework.stereotype.Service; // Spring annotation to define a service class

@Service
public class MathProblemService {
    // Random instance for generating random numbers
    private Random random = new Random();

    // Method to generate a math problem based on the specified difficulty level
    public MathProblemDTO generateMathProblem(DifficultyLevel difficulty) {
        MathProblemDTO mathProblemDTO = new MathProblemDTO(); // Create a new MathProblemDTO instance
        mathProblemDTO.setDifficulty(difficulty); // Set the difficulty level of the problem
        mathProblemDTO.setOperation(getRandomOperation(difficulty)); // Set a random operation based on difficulty
        mathProblemDTO.setNumerator(getRandomNumber(difficulty, mathProblemDTO.getOperation())); // Set a random
                                                                                                 // numerator
        mathProblemDTO.setDenominator(getRandomNumber(difficulty, mathProblemDTO.getOperation())); // Set a random
        mathProblemDTO.setAnswer(getAnswer(mathProblemDTO)); // denominator
        return mathProblemDTO; // Return the generated math problem
    }

    // Method to calculate the answer for a math problem based on its operation type
    public float getAnswer(MathProblemDTO problem) {
        // Switch statement to handle different mathematical operations
        switch (problem.getOperation()) {
            case Addition: {
                // If the operation is Addition, return the sum of the numerator and denominator
                return (problem.getNumerator() + problem.getDenominator());
            }
            case Subtraction: {
                // If the operation is Subtraction, return the difference between numerator and
                // denominator
                return (problem.getNumerator() - problem.getDenominator());
            }
            case Multiplication: {
                // If the operation is Multiplication, return the product of numerator and
                // denominator
                return (problem.getNumerator() * problem.getDenominator());
            }
            case Division: {
                // Check if the denominator is not zero to avoid division by zero error
                if (problem.getDenominator() != 0) {
                    // Round the result of the division to two decimal places
                    return Math.round((problem.getNumerator() / problem.getDenominator()) * 100.0f) / 100.0f;
                } else {
                    return 0f; // Return 0 if the denominator is zero
                }
            }
            default: {
                // If the operation is not recognized, return 0 as a default value
                return 0f;
            }
        }
    }

    // Private method to get a random mathematical operation based on difficulty
    // level
    public Operation getRandomOperation(DifficultyLevel difficulty) {
        Operation result = Operation.Addition; // Default operation
        switch (difficulty) {
            case Beginner: { // For beginner level, allow only addition
                int i = random.nextInt(2); // Randomly choose an operation index (0 for addition 1 for subtraction)
                result = Operation.values()[i]; // Set the operation
                break;
            }
            case Advanced:
            case Intermediate: { // For intermediate and advanced levels, allow multiple operations
                int i = random.nextInt(4); // Randomly choose an operation index (0-3 for addition,
                                           // subtraction,multiplication and division)

                result = Operation.values()[i]; // Set the operation
                break;
            }
        }
        return result; // Return the randomly selected operation
    }

    // Private method to generate a random number based on difficulty level and
    // operation type
    private float getRandomNumber(DifficultyLevel difficulty, Operation operation) {
        float result = 0; // Initialize result
        switch (difficulty) {
            case Beginner: { // For beginner level, generate a number between 1 and 10
                result = random.nextInt(1, 10); // Generate a random integer
                break;
            }
            case Intermediate: { // For intermediate level, generate numbers based on operation
                if (operation == Operation.Addition || operation == Operation.Subtraction) {
                    result = random.nextInt(1, 50); // Generate random numbers for addition/subtraction
                } else {
                    result = random.nextInt(1, 10); // Generate smaller numbers for multiplication/division
                }
                break;
            }
            case Advanced: { // For advanced level, generate numbers based on operation
                if (operation == Operation.Addition || operation == Operation.Subtraction) {
                    result = random.nextInt(1, 100); // Generate larger numbers for addition/subtraction
                } else {
                    result = random.nextInt(1, 25); // Generate smaller numbers for multiplication/division
                }
                break;
            }
        }
        return result; // Return the generated random number
    }
}
