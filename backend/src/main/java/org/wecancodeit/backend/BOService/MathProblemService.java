package org.wecancodeit.backend.BOService;

// Importing required classes and enums
import org.wecancodeit.backend.DTOs.MathProblemDTO; // Data Transfer Object for math problems
import org.wecancodeit.backend.Enums.*; // Importing all enums in the package
import java.util.Random; // Random class for generating random numbers
import org.springframework.stereotype.Service; // Spring annotation to define a service class

// Service class responsible for generating math problems
@Service
public class MathProblemService {
    // Random instance for generating random numbers
    private Random random = new Random();

    // Array of supported operators
    private final String[] operators = {
            "+", "-", "*", "/"
    };

    // Method to generate a math problem based on the specified difficulty level
    public MathProblemDTO generateMathProblem(DifficultyLevel difficulty) {
        // Create a new MathProblemDTO instance to store the math problem details
        MathProblemDTO mathProblemDTO = new MathProblemDTO();

        // Set the difficulty level for the math problem
        mathProblemDTO.setDifficulty(difficulty);

        // Set a random operation for the math problem based on difficulty
        mathProblemDTO.setOperation(getRandomOperation(difficulty));

        // Generate a random numerator and denominator
        mathProblemDTO.setNumerator(getRandomNumber(difficulty, mathProblemDTO.getOperation()));
        mathProblemDTO.setDenominator(getRandomNumber(difficulty, mathProblemDTO.getOperation()));

        // Ensure the numerator is greater than the denominator for beginner-level
        // subtraction problems
        if (difficulty == DifficultyLevel.Beginner && mathProblemDTO.getOperation().equals("-")
                && mathProblemDTO.getDenominator() > mathProblemDTO.getNumerator()) {
            // Swap numerator and denominator to avoid negative results
            float newNumerator = mathProblemDTO.getNumerator();
            float newDenominator = mathProblemDTO.getDenominator();
            mathProblemDTO.setNumerator(newDenominator);
            mathProblemDTO.setDenominator(newNumerator);
        }

        // Calculate and set the correct answer for the math problem
        mathProblemDTO.setAnswer(getAnswer(mathProblemDTO));

        // Return the fully constructed math problem DTO
        return mathProblemDTO;
    }

    // Method to calculate the answer for a math problem based on its operation type
    public float getAnswer(MathProblemDTO problem) {
        // Use a switch statement to determine the operation and calculate the answer
        switch (problem.getOperation()) {
            case "+": {
                // Addition: Return the sum of the numerator and denominator
                return (problem.getNumerator() + problem.getDenominator());
            }
            case "-": {
                // Subtraction: Return the difference between numerator and denominator
                return (problem.getNumerator() - problem.getDenominator());
            }
            case "*": {
                // Multiplication: Return the product of numerator and denominator
                return (problem.getNumerator() * problem.getDenominator());
            }
            case "/": {
                // Division: Avoid division by zero
                if (problem.getDenominator() != 0) {
                    // Round the result to two decimal places
                    return Math.round((problem.getNumerator() / problem.getDenominator()) * 100.0f) / 100.0f;
                } else {
                    return 0f; // Return 0 if the denominator is zero
                }
            }
            default: {
                // If the operation is not recognized, return 0 as a fallback value
                return 0f;
            }
        }
    }

    // Private method to get a random mathematical operation based on difficulty
    // level
    public String getRandomOperation(DifficultyLevel difficulty) {
        String result = ""; // Default operation
        switch (difficulty) {
            case Beginner: {
                // Beginner level allows only addition and subtraction
                int i = random.nextInt(2); // Choose an index: 0 (addition) or 1 (subtraction)
                result = operators[i];
                break;
            }
            case Advanced:
            case Intermediate: {
                // Intermediate and Advanced levels allow all operations
                int i = random.nextInt(4); // Choose an index between 0-3
                result = operators[i];
                break;
            }
        }
        return result; // Return the selected operation
    }

    // Private method to generate a random number based on difficulty level and
    // operation type
    private float getRandomNumber(DifficultyLevel difficulty, String operation) {
        float result = 0; // Initialize result
        switch (difficulty) {
            case Beginner: {
                // Beginner level: Generate numbers between 1 and 10
                result = random.nextInt(1, 10);
                break;
            }
            case Intermediate: {
                // Intermediate level: Numbers depend on the operation
                if (operation.equals("+") || operation.equals("-")) {
                    // Larger range for addition/subtraction
                    result = random.nextInt(1, 50);
                } else {
                    // Smaller range for multiplication/division
                    result = random.nextInt(1, 10);
                }
                break;
            }
            case Advanced: {
                // Advanced level: Numbers depend on the operation
                if (operation.equals("+") || operation.equals("-")) {
                    // Larger range for addition/subtraction
                    result = random.nextInt(1, 100);
                } else {
                    // Smaller range for multiplication/division
                    result = random.nextInt(1, 25);
                }
                break;
            }
        }
        return result; // Return the generated random number
    }
}
