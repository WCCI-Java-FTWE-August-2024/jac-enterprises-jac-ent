package org.wecancodeit.backend.Controllers;

// Importing necessary Spring framework annotations and classes
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.wecancodeit.backend.BOService.MathProblemService; // Business logic service for math problems
import org.wecancodeit.backend.BOService.UserService; // Service for handling user-related operations
import org.wecancodeit.backend.Enums.DifficultyLevel; // Enum representing difficulty levels

/**
 * MathProblemController.java
 * 
 * This class handles RESTful endpoints for generating math problems
 * based on specified difficulty levels. It includes token-based
 * authorization to validate requests.
 * 
 * Author: [Nevin Ronske]
 * Date: [11/16/2024]
 * Version: 1.0
 */
@RestController
// Base URL for all endpoints in this controller
@RequestMapping("/api/v1/math")
public class MathProblemController extends BaseController {

    // Constructor injection for the UserService, passed to the BaseController
    public MathProblemController(UserService userService) {
        super(userService);
    }

    // Dependency injection for the MathProblemService to handle math-related logic
    @Autowired
    private MathProblemService mathProblemService;

    /**
     * Endpoint to generate a math problem based on the specified difficulty level.
     *
     * @param difficulty The difficulty level as a string (e.g., BEGINNER,
     *                   INTERMEDIATE, ADVANCED).
     *                   This is passed as a path variable.
     * @param authHeader The Authorization header passed with the request, required
     *                   for token validation.
     * @return If authorized, returns a ResponseEntity with the generated
     *         MathProblemDTO as JSON.
     *         If unauthorized, returns a 401 UNAUTHORIZED response with an error
     *         message.
     */
    @GetMapping("/{difficulty}") // Maps HTTP GET requests to this method, with "difficulty" as a path variable
    public ResponseEntity<?> generateMathProblem(
            @PathVariable String difficulty, // Extracts the difficulty level from the URL
            @RequestHeader(name = "Authorization", required = true) String authHeader // Reads the Authorization header
    ) {
        // Check if the provided token in the Authorization header is valid
        if (checkToken(authHeader)) {
            // Convert the difficulty string to the corresponding DifficultyLevel enum
            DifficultyLevel difficultyLevel = DifficultyLevel.valueOf(difficulty);

            // Generate a math problem using the MathProblemService and return it with an
            // HTTP 200 status
            return ResponseEntity.ok(mathProblemService.generateMathProblem(difficultyLevel));
        }

        // If token validation fails, return a 401 UNAUTHORIZED status with an error
        // message
        return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Missing or invalid authorization header");
    }

}
