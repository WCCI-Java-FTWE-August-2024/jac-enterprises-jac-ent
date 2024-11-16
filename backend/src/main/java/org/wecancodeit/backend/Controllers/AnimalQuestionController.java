/**
 * File: AnimalQuestionController.java
 * 
 * Description:
 * This file contains the implementation of the `AnimalQuestionController` class, 
 * which is a REST controller responsible for handling HTTP requests related to 
 * animal questions. The controller provides endpoints for retrieving all questions 
 * and fetching a random question based on a specified difficulty level. It includes 
 * authentication checks using an Authorization header.
 * 
 * Author: [Matt S]
 * Organization: We Can Code IT
 * Created: [16-November-2024]
 * Last Modified: [16-November-2024]
 * 
 * Dependencies:
 * - Spring Framework (for REST controller annotations and HTTP utilities)
 * - AnimalQuestionService (service for animal question business logic)
 * - UserService (service for user-related operations)
 * - BaseController (base class for common controller functionality)
 * - DifficultyLevel (enum defining difficulty levels for questions)
 * - AnimalQuestionModel (data model representing an animal question)
 * 
 * Usage:
 * 1. Base endpoint: `/api/v1/animals`
 * 2. Get all questions: `GET /api/v1/animals` (Authorization required)
 * 3. Get a random question by difficulty: `GET /api/v1/animals/{difficulty}` 
 *    (Authorization required)
 * 
 * Notes:
 * - Ensure that the Authorization header is passed with every request.
 * - This controller extends `BaseController` to reuse common functionality.
 * 
 */

package org.wecancodeit.backend.Controllers;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.wecancodeit.backend.BOService.AnimalQuestionService;
import org.wecancodeit.backend.BOService.UserService;
import org.wecancodeit.backend.DataModels.AnimalQuestionModel;
import org.wecancodeit.backend.Enums.DifficultyLevel;

import jakarta.annotation.Resource;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestHeader;

@RestController
@RequestMapping("api/v1/animals") // Define the base URL for all endpoints in this controller
public class AnimalQuestionController extends BaseController {

    @Resource // Injecting the AnimalQuestionService dependency
    private AnimalQuestionService animalQuestionService;

    /**
     * Constructor for AnimalQuestionController that accepts instances of required
     * services.
     * This constructor enables dependency injection, allowing services to be used
     * within the controller.
     *
     * @param animalQuestionService The service for handling animal question-related
     *                              logic.
     * @param userService           The service for handling user-related logic.
     */
    public AnimalQuestionController(AnimalQuestionService animalQuestionService, UserService userService) {
        super(userService); // Call the superclass constructor to set up userService
        this.animalQuestionService = animalQuestionService;
    }

    /**
     * Endpoint to retrieve all animal questions.
     * The path is defined by the @RequestMapping at the class level.
     * 
     * @param authHeader The Authorization header containing the token.
     * @return A ResponseEntity containing the list of animal questions if the token
     *         is valid,
     *         or a UNAUTHORIZED status if the token is missing or invalid.
     */
    @GetMapping // Handle GET requests to "api/v1/animals"
    public ResponseEntity<?> getAllQuestions(
            @RequestHeader(name = "Authorization", required = true) String authHeader) {
        // Check if the provided Authorization token is valid
        if (checkToken(authHeader)) {
            // Retrieve all animal questions using the service and return a 200 OK response
            return ResponseEntity.ok(animalQuestionService.getAllAnimalQuestions());
        }
        // Return a 401 Unauthorized status if the token is invalid
        return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Missing or invalid Authorization header");
    }

    /**
     * Endpoint to retrieve a random animal question filtered by difficulty level.
     *
     * @param difficulty The specified difficulty level (e.g., Beginner, Intermediate, Advanced).
     * @param authHeader The Authorization header containing the token.
     * @return A ResponseEntity containing the animal question if found,
     *         or a NOT_FOUND or UNAUTHORIZED status depending on the scenario.
     */
    @GetMapping("/{difficulty}") // Handle GET requests to "api/v1/animals/{difficulty}"
    public ResponseEntity<?> getRandomAnimalQuestion(
            @PathVariable String difficulty,
            @RequestHeader(name = "Authorization", required = true) String authHeader) {
        // Check if the provided Authorization token is valid
        if (checkToken(authHeader)) {
            // Convert the difficulty string to the DifficultyLevel enum
            DifficultyLevel d = DifficultyLevel.valueOf(difficulty);

            // Retrieve a random animal question based on the specified difficulty level
            AnimalQuestionModel animalQuestion = animalQuestionService.getRandomAnimalQuestion(d);

            // If a question is found, return it with a 200 OK response
            if (animalQuestion != null) {
                return ResponseEntity.ok(animalQuestion);
            }
        }
        // Return a 401 Unauthorized status if the token is invalid
        return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Missing or invalid Authorization header");
    }
}
