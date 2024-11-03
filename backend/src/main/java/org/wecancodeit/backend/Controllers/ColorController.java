package org.wecancodeit.backend.Controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.wecancodeit.backend.BOService.ColorService;
import org.wecancodeit.backend.DataModels.ColorModel;
import org.wecancodeit.backend.Enums.DifficultyLevel;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@RestController
@RequestMapping("/api/color")
public class ColorController {

    private ColorService colorService;

    @Autowired
    public ColorController(ColorService colorService) {
        this.colorService = colorService;
    }

    @GetMapping("/questions/random")
    public ResponseEntity<ColorModel> getRandomQuestionByDifficulty(@RequestParam DifficultyLevel difficulty) {
        ColorModel question = colorService.getRandomQuestionByDifficulty(difficulty);

        if (question == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND); // Return 404 if no question is found
        } else {
            return new ResponseEntity<>(question, HttpStatus.OK); // Return the question with 200 OK status
        }
    }
}
