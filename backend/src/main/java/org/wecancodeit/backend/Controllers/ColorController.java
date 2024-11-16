/**
 * File: ColorController.java
 * Project: Jac Enterprises Backend
 * Author: [John M.]
 * Created Date: [16-11-24]
 * Last Edited: [16-11-24]
 * Description:
 *      This class serves as the REST controller for handling API endpoints related to color questions.
 *      It provides functionality to retrieve questions based on difficulty level while implementing
 *      user authentication via Bearer tokens.
 *
 */

package org.wecancodeit.backend.Controllers;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.wecancodeit.backend.BOService.ColorService;
import org.wecancodeit.backend.BOService.UserService;
import org.wecancodeit.backend.DataModels.ColorModel;
import org.wecancodeit.backend.Enums.DifficultyLevel;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestHeader;

/**
 * REST controller for handling color-related requests.
 * Provides endpoints for retrieving color questions based on difficulty level.
 * 
 * Base URL: /api/v1/color
 */
@RestController
@RequestMapping("/api/v1/color")
public class ColorController extends BaseController {

    private final ColorService colorService;

    /**
     * Constructs the ColorController and injects the required dependencies.
     * 
     * @param userService  The service layer for user-related logic, inherited
     *                     from BaseController.
     * @param colorService The service layer for handling business logic related
     *                     to color questions.
     */
    public ColorController(UserService userService, ColorService colorService) {
        super(userService); // Passes userService to the BaseController
        this.colorService = colorService;
    }

    /**
     * Retrieves a random color question based on the specified difficulty level.
     * Requires a valid Bearer token in the Authorization header for access.
     * 
     * Endpoint: GET /api/v1/color/{difficulty}
     * 
     * @param difficulty The difficulty level of the question (e.g., BEGINNER,
     *                   INTERMEDIATE, ADVANCED), provided as a path variable.
     * @param authHeader The Authorization header containing the Bearer token.
     * @return A ResponseEntity containing:
     *         - The ColorModel question with a 200 OK status if the token is valid
     *         and a question is found.
     *         - A 404 NOT FOUND status if no question matches the difficulty level.
     *         - A 401 UNAUTHORIZED status if the token is missing or invalid.
     */
    @GetMapping("/{difficulty}")
    public ResponseEntity<?> getRandomQuestionByDifficulty(
            @PathVariable String difficulty, // Path variable to specify difficulty level
            @RequestHeader(name = "Authorization", required = true) String authHeader // Bearer token in the
                                                                                      // Authorization header
    ) {
        try {
            // Validate the Bearer token
            if (!checkToken(authHeader)) {
                return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Missing or invalid authorization header");
            }

            // Convert the difficulty string to the DifficultyLevel enum
            DifficultyLevel difficultyLevel = DifficultyLevel.valueOf(difficulty);

            // Retrieve a random question of the specified difficulty
            ColorModel question = colorService.getRandomQuestionByDifficulty(difficultyLevel);

            // If a question is found, return it with a 200 OK status
            if (question != null) {
                return ResponseEntity.ok(question);
            }

            // If no question matches the difficulty, return 404 NOT FOUND
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("No question found for the specified difficulty");

        } catch (IllegalArgumentException e) {
            // Handle invalid difficulty values gracefully
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Invalid difficulty level provided");
        } catch (Exception e) {
            // Handle any unexpected errors
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("An unexpected error occurred");
        }
    }
}
