package org.wecancodeit.backend.BOService;

import java.util.*;

import org.springframework.stereotype.Service;
import org.wecancodeit.backend.DataModels.ColorModel;
import org.wecancodeit.backend.Enums.DifficultyLevel;

@Service
public class ColorService {

    private List<ColorModel> questions;

    public ColorService() {
        questions = new ArrayList<>();

        // The Hardcoded in questions with IDs to identify them by

        // ----------------------------Beginner--------------------------
        questions.add(new ColorModel(
                1L, // Unique ID for this question. "L" marks it as a long
                "What color do you get when you mix red and yellow?",
                Arrays.asList("Orange", "Green", "Purple", "Brown"),
                "Orange",
                "/images/colors/orange.jpg",
                DifficultyLevel.Beginner));

        questions.add(new ColorModel(
                2L,
                "What color do you get when you mix blue and yellow?",
                Arrays.asList("Green", "Purple", "Orange", "Gray"),
                "Green",
                "/images/colors/green.jpg",
                DifficultyLevel.Beginner));
        // ----------------------------Intermediate--------------------------
        questions.add(new ColorModel(
                3L,
                "Which color is associated with calm and peace?",
                Arrays.asList("Red", "Blue", "Green", "Yellow"),
                "Blue",
                "/images/colors/blue.jpg",
                DifficultyLevel.Intermediate));
        // -----------------------------Advanced-----------------------------
        questions.add(new ColorModel(
                4L,
                "What is the complementary color of green?",
                Arrays.asList("Red", "Orange", "Purple", "Blue"),
                "Red",
                "/images/colors/green-red.jpg",
                DifficultyLevel.Advanced));
    }

    /**
     * Retrieves all color questions.
     * 
     * @return a list of all ColorModel questions.
     */
    public List<ColorModel> getAllQuestions() {
        return questions;
    }

    /**
     * Retrieves a random question of the specified difficulty level.
     * 
     * @param difficulty the difficulty level of the question (e.g., BEGINNER,
     *                   INTERMEDIATE, ADVANCED).
     * @return a random ColorModel question that matches the specified difficulty
     *         level,
     *         or null if no questions of that difficulty are found.
     */
    public ColorModel getRandomQuestionByDifficulty(DifficultyLevel difficulty) {

        // Step 1: Create a new list to store questions matching the specified
        // difficulty
        List<ColorModel> filteredQuestions = new ArrayList<>();

        // Step 2: Loop through each question in the main list of questions
        for (ColorModel question : questions) {

            // Step 3: Check if the question's difficulty matches the specified level
            if (question.getDifficulty() == difficulty) {

                // Step 4: If it matches, add the question to the filtered list
                filteredQuestions.add(question);
            }
        }

        // At this point, filteredQuestions contains only questions with the specified
        // difficulty

        // Step 5: Select and return a random question from filteredQuestions, if any
        // are available
        if (!filteredQuestions.isEmpty()) {
            Random random = new Random();

            // Generate a random index within the range of filteredQuestions
            int randomIndex = random.nextInt(filteredQuestions.size());

            return filteredQuestions.get(randomIndex); // Return the randomly selected question
        } else {
            return null; // Return null if no questions of the specified difficulty were found
        }
    }

}
