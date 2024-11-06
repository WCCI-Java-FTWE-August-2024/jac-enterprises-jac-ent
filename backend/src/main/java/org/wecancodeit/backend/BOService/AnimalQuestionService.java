package org.wecancodeit.backend.BOService;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

import org.springframework.stereotype.Service;
import org.wecancodeit.backend.DataModels.AnimalQuestionModel;
import org.wecancodeit.backend.Enums.DifficultyLevel;

@Service
public class AnimalQuestionService {

        private List<AnimalQuestionModel> animalQuestions; // List to store all animal questions

        /**
         * Constructor to initialize AnimalQuestionService with hardcoded questions.
         * Each question is added with a unique ID, question text, options, answer,
         * image URL, and difficulty level.
         */
        public AnimalQuestionService() {
                animalQuestions = new ArrayList<>(); // Initialize the list of questions

                // Adding questions to the list with specific difficulty levels

                // Beginner-level questions
                animalQuestions.add(new AnimalQuestionModel(
                                1L, // ID of the question
                                "What is the largest mammal?",
                                Arrays.asList("Elephant", "Blue Whale", "Giraffe", "Hippopotamus"),
                                "Blue Whale", // Correct answer
                                "https://www.oceanactionhub.org/storage/2024/08/A-blue-whales-heart-dwarfs-a-small-car-in-size-1024x702.jpg",
                                DifficultyLevel.Beginner // Difficulty level
                ));

                animalQuestions.add(new AnimalQuestionModel(
                                2L,
                                "Which animal is known for having a pouch?",
                                Arrays.asList("Penguin", "Kangaroo", "Elephant", "Panda"),
                                "Kangaroo",
                                "https://cdn.mos.cms.futurecdn.net/ETb2xLjvc62eb7PPLspSsU.jpg",
                                DifficultyLevel.Beginner));

                animalQuestions.add(new AnimalQuestionModel(
                                3L,
                                "What animal is known for making honey?",
                                Arrays.asList("Bee", "Wasp", "Ant", "Mongoose"),
                                "Bee",
                                "https://www.utm.utoronto.ca/hospitality/sites/files/hospitality/styles/landscape/public/2024-10/Worker%20Bee.jpg.webp?itok=ZN9njD6r",
                                DifficultyLevel.Beginner));

                // Intermediate-level questions
                animalQuestions.add(new AnimalQuestionModel(
                                4L,
                                "How many legs does a spider have?",
                                Arrays.asList("6", "8", "10", "12"),
                                "8",
                                "https://i.natgeofe.com/n/76aea853-00cf-41f4-a618-3a1b0ff2afb4/spiders_07_3x4.jpg",
                                DifficultyLevel.Intermediate));

                animalQuestions.add(new AnimalQuestionModel(
                                5L,
                                "What is a group of lions called?",
                                Arrays.asList("Herd", "Pack", "Flock", "Pride"),
                                "Pride",
                                "https://cdn.mos.cms.futurecdn.net/FVqUjfbiHS9imyJiRiM53-1200-80.jpg",
                                DifficultyLevel.Intermediate));

                animalQuestions.add(new AnimalQuestionModel(
                                6L,
                                "What is the fastest land animal?",
                                Arrays.asList("Cheetah", "Horse", "Lion", "Elephant"),
                                "Cheetah",
                                "https://seethewild.org/wp-content/uploads/2022/09/Cheetah_Kruger-1024x671-1.jpg",
                                DifficultyLevel.Intermediate));

                // Advanced-level questions
                animalQuestions.add(new AnimalQuestionModel(
                                7L,
                                "Which bird is known for its ability to mimic sounds?",
                                Arrays.asList("Parrot", "Sparrow", "Eagle", "Owl"),
                                "Parrot",
                                "https://t4.ftcdn.net/jpg/07/18/12/87/360_F_718128776_nJReWqPkf5qF4Y5na8ZqGWAbdCJTpczZ.jpg",
                                DifficultyLevel.Advanced));

                animalQuestions.add(new AnimalQuestionModel(
                                8L,
                                "What animal is used to hunt for mushrooms",
                                Arrays.asList("Pig", "Rat", "Cat", "Python"),
                                "Pig",
                                "https://i.natgeofe.com/k/0ed36c42-672a-425b-9e62-7cc946b98051/pig-fence_square.jpg",
                                DifficultyLevel.Advanced));

                animalQuestions.add(new AnimalQuestionModel(
                                9L,
                                "Which animal is used to produce designer fabric",
                                Arrays.asList("Inchworm", "Earworm", "Silkworm", "Ringworm"),
                                "Silkworm",
                                "https://news.cgtn.com/news/3d3d514f7751544d33457a6333566d54/img/09d34ce2ac6c465cb09306d27a2d9083/09d34ce2ac6c465cb09306d27a2d9083.jpg",
                                DifficultyLevel.Advanced));
        }

        /**
         * Method to retrieve all the animal questions.
         * 
         * @return List of all animal questions
         */
        public List<AnimalQuestionModel> getAllAnimalQuestions() {
                return animalQuestions;
        }

        /**
         * Method to get a random question based on a specified difficulty level.
         * 
         * @param difficulty the desired DifficultyLevel (Beginner, Intermediate, or
         *                   Advanced)
         * @return A random AnimalQuestionModel of the specified difficulty, or null if
         *         no questions match
         */
        public AnimalQuestionModel getRandomAnimalQuestion(DifficultyLevel difficulty) {

                List<AnimalQuestionModel> questionByDifficulty = new ArrayList<>(); // List to store questions filtered
                                                                                    // by difficulty

                // Filter questions based on the specified difficulty level
                for (AnimalQuestionModel question : animalQuestions) {
                        if (question.getDifficulty() == difficulty) { // Check if question's difficulty matches
                                questionByDifficulty.add(question);
                        }
                }

                // If there are questions of the specified difficulty, select a random one
                if (!questionByDifficulty.isEmpty()) {
                        Random random = new Random(); // Random object to generate random index

                        int randomIndex = random.nextInt(questionByDifficulty.size()); // Generate random index within
                                                                                       // the list size

                        return questionByDifficulty.get(randomIndex); // Return the randomly selected question
                } else {
                        return null; // Return null if no questions match the specified difficulty
                }
        }
}
