package org.wecancodeit.backend.Controllers;

// import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.wecancodeit.backend.BOService.ColorService;
import org.wecancodeit.backend.DataModels.ColorModel;
import org.wecancodeit.backend.Enums.DifficultyLevel;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * REST controller for handling color-related requests.
 * Provides endpoints for retrieving color questions based on difficulty level.
 * 
 * Base URL: /api/v1/color
 */
@RestController
@RequestMapping("/api/v1/color")
public class ColorController {

    private final ColorService colorService;

    /**
     * Constructs the ColorController and injects the ColorService dependency.
     * 
     * @param colorService the service layer responsible for handling business logic
     *                     related to color questions.
     */
    public ColorController(ColorService colorService) {
        this.colorService = colorService;
    }

    /**
     * Retrieves a random color question based on the specified difficulty level.
     * 
     * Endpoint: GET /api/v1/color/
     * 
     * @param difficulty the difficulty level of the question (e.g., BEGINNER,
     *                   INTERMEDIATE, ADVANCED)
     *                   provided as a query parameter.
     * @return a ResponseEntity containing the ColorModel question.
     *         Returns 200 OK with the question if found, or 404 NOT FOUND if no
     *         question matches the difficulty.
     */
    @GetMapping("/")
    public ResponseEntity<ColorModel> getRandomQuestionByDifficulty(@RequestParam DifficultyLevel difficulty) {

        // Call the service method to get a random question of the specified difficulty
        ColorModel question = colorService.getRandomQuestionByDifficulty(difficulty);

        // Check if a question was found for the specified difficulty level
        if (question == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND); // Return 404 if no question is found
        } else {
            return new ResponseEntity<>(question, HttpStatus.OK); // Return the question with 200 OK status
        }
    }
}
