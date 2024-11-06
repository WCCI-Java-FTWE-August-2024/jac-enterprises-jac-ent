package org.wecancodeit.backend.Controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.wecancodeit.backend.BOService.MathProblemService;
import org.wecancodeit.backend.DTOs.MathProblemDTO;
import org.wecancodeit.backend.Enums.DifficultyLevel;

@RestController // Marks this class as a RESTful controller
@RequestMapping("/api/v1/math") // Sets the base URL for all endpoints in this controller
public class MathProblemController {

    @Autowired
    private MathProblemService mathProblemService;

    /**
     * Endpoint to generate a math problem based on the difficulty level
     *
     * @param difficulty The difficulty level for the problem (e.g., BEGINNER,
     *                   INTERMEDIATE, ADVANCED)
     * @return The generated MathProblemDTO as JSON
     */
    @GetMapping("/")
    public MathProblemDTO generateMathProblem(@RequestParam DifficultyLevel difficulty) {
        // Call the service to generate a math problem
        return mathProblemService.generateMathProblem(difficulty);
    }
}
