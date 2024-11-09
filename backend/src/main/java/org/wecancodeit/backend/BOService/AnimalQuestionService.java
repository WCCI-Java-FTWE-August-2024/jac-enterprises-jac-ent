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
                                1L, // ID of the question. The L casts it to a Long
                                "What is the largest mammal?",
                                Arrays.asList("Elephant", "Giraffe", "Hippopotamus", "Blue Whale"),
                                  3 , // "Blue Whale" Correct answer. This is the index of the answer in the arraylist
                                "https://www.oceanactionhub.org/storage/2024/08/A-blue-whales-heart-dwarfs-a-small-car-in-size-1024x702.jpg",
                                DifficultyLevel.Beginner // Difficulty level
                ));

                animalQuestions.add(new AnimalQuestionModel(
                                2L,
                                "Which animal is known for having a pouch?",
                                Arrays.asList("Penguin", "Kangaroo", "Elephant", "Panda"),
                                 1, // Kangaroo
                                 "https://cdn.mos.cms.futurecdn.net/ETb2xLjvc62eb7PPLspSsU.jpg",
                                DifficultyLevel.Beginner));

                animalQuestions.add(new AnimalQuestionModel(
                                3L,
                                "What animal is known for making honey?",
                                Arrays.asList("Bee", "Wasp", "Ant", "Mongoose"),
                                0, // "Bee"
                                "https://www.utm.utoronto.ca/hospitality/sites/files/hospitality/styles/landscape/public/2024-10/Worker%20Bee.jpg.webp?itok=ZN9njD6r",
                                DifficultyLevel.Beginner));

                // Intermediate-level questions
                animalQuestions.add(new AnimalQuestionModel(
                                4L,
                                "How many legs does a spider have?",
                                Arrays.asList("6", "8", "10", "12"),
                                1, // "8"
                                "https://i.natgeofe.com/n/76aea853-00cf-41f4-a618-3a1b0ff2afb4/spiders_07_3x4.jpg",
                                DifficultyLevel.Intermediate));

                animalQuestions.add(new AnimalQuestionModel(
                                5L,
                                "What is a group of lions called?",
                                Arrays.asList("Herd", "Pack", "Flock", "Pride"),
                                3, // "Pride"
                                "https://cdn.mos.cms.futurecdn.net/FVqUjfbiHS9imyJiRiM53-1200-80.jpg",
                                DifficultyLevel.Intermediate));

                animalQuestions.add(new AnimalQuestionModel(
                                6L,
                                "What is the fastest land animal?",
                                Arrays.asList("Horse", "Cheetah", "Lion", "Elephant"),
                                1, // "Cheetah"
                                "https://seethewild.org/wp-content/uploads/2022/09/Cheetah_Kruger-1024x671-1.jpg",
                                DifficultyLevel.Intermediate));

                // Advanced-level questions
                animalQuestions.add(new AnimalQuestionModel(
                                7L,
                                "Which bird is known for its ability to mimic sounds?",
                                Arrays.asList("Parrot", "Sparrow", "Eagle", "Owl"),
                                0, // "Parrot"
                                "https://t4.ftcdn.net/jpg/07/18/12/87/360_F_718128776_nJReWqPkf5qF4Y5na8ZqGWAbdCJTpczZ.jpg",
                                DifficultyLevel.Advanced));

                animalQuestions.add(new AnimalQuestionModel(
                                8L,
                                "What animal is used to hunt for mushrooms",
                                Arrays.asList("Pig", "Rat", "Cat", "Python"),
                                0, // "Pig"
                                "https://i.natgeofe.com/k/0ed36c42-672a-425b-9e62-7cc946b98051/pig-fence_square.jpg",
                                DifficultyLevel.Advanced));

                animalQuestions.add(new AnimalQuestionModel(
                                9L,
                                "Which animal is used to produce designer fabric",
                                Arrays.asList("Inchworm", "Earworm", "Silkworm", "Ringworm"),
                                2, // "Silkworm"
                                "https://news.cgtn.com/news/3d3d514f7751544d33457a6333566d54/img/09d34ce2ac6c465cb09306d27a2d9083/09d34ce2ac6c465cb09306d27a2d9083.jpg",
                                DifficultyLevel.Advanced));

                // Beginner-level questions
                animalQuestions.add(new AnimalQuestionModel(
                                10L,
                                "What is the tallest animal in the world?",
                                Arrays.asList("Elephant",  "Lion", "Tiger", "Giraffe"),
                                3, // "Giraffe"
                                "https://images.unsplash.com/photo-1547721064-da6cfb341d50?w=500&auto=format&fit=crop&q=60&ixlib=rb-4.0.3&ixid=M3wxMjA3fDB8MHxzZWFyY2h8OXx8Z2lyYWZmZXxlbnwwfHwwfHx8Mg%3D%3D",
                                DifficultyLevel.Beginner));

                animalQuestions.add(new AnimalQuestionModel(
                                11L,
                                "Which animal is known for having black and white stripes?",
                                Arrays.asList("Lion", "Zebra", "Giraffe", "Elephant"),
                                1, // "Zebra"
                                "https://images.unsplash.com/photo-1518709594023-6eab9bab7b23?w=500&auto=format&fit=crop&q=60&ixlib=rb-4.0.3&ixid=M3wxMjA3fDB8MHxzZWFyY2h8M3x8emVicmF8ZW58MHx8MHx8fDI%3D",
                                DifficultyLevel.Beginner));

                animalQuestions.add(new AnimalQuestionModel(
                                12L,
                                "What type of animal is a dolphin?",
                                Arrays.asList("Fish", "Mammal", "Bird", "Reptile"),
                                1, // "Mammal"
                                "https://images.unsplash.com/photo-1523670982602-6bb44fd1586e?w=500&auto=format&fit=crop&q=60&ixlib=rb-4.0.3&ixid=M3wxMjA3fDB8MHxzZWFyY2h8MXx8ZG9scGhpbnxlbnwwfHwwfHx8Mg%3D%3D",
                                DifficultyLevel.Beginner));

                animalQuestions.add(new AnimalQuestionModel(
                                13L,
                                "Which animal is known as man's best friend?",
                                Arrays.asList("Cat", "Bird",  "Fish", "Dog"),
                                3, // "Dog"
                                "https://images.unsplash.com/photo-1532592333381-a141e3f197c9?w=500&auto=format&fit=crop&q=60&ixlib=rb-4.0.3&ixid=M3wxMjA3fDB8MHxzZWFyY2h8OXx8ZG9nfGVufDB8fDB8fHwy",
                                DifficultyLevel.Beginner));

                animalQuestions.add(new AnimalQuestionModel(
                                14L,
                                "Which bird is famous for its pink color?",
                                Arrays.asList("Eagle", "Parrot", "Flamingo", "Owl"),
                                2, // "Flamingo"
                                "https://images.unsplash.com/photo-1497206365907-f5e630693df0?w=500&auto=format&fit=crop&q=60&ixlib=rb-4.0.3&ixid=M3wxMjA3fDB8MHxzZWFyY2h8Mnx8ZmxhbWluZ298ZW58MHx8MHx8fDI%3D",
                                DifficultyLevel.Beginner));

                // Intermediate-level questions
                animalQuestions.add(new AnimalQuestionModel(
                                15L,
                                "How many arms does an octopus have?",
                                Arrays.asList("6", "8", "10", "12"),
                                1, // "8"
                                "https://images.unsplash.com/photo-1564492051408-8969bf1b8ffb?w=500&auto=format&fit=crop&q=60&ixlib=rb-4.0.3&ixid=M3wxMjA3fDB8MHxzZWFyY2h8Mnx8b2N0b3B1c3xlbnwwfHwwfHx8Mg%3D%3D",
                                DifficultyLevel.Intermediate));

                animalQuestions.add(new AnimalQuestionModel(
                                16L,
                                "What is the fastest bird in the world?",
                                Arrays.asList("Eagle",  "Sparrow", "Pigeon", "Falcon"),
                                3, // "Falcon"
                                "https://images.unsplash.com/photo-1432123885140-abba5bf8cbb7?w=500&auto=format&fit=crop&q=60&ixlib=rb-4.0.3&ixid=M3wxMjA3fDB8MHxzZWFyY2h8Nnx8ZmFsY29ufGVufDB8fDB8fHwy",
                                DifficultyLevel.Intermediate));

                animalQuestions.add(new AnimalQuestionModel(
                                17L,
                                "What type of animal is a Komodo dragon?",
                                Arrays.asList("Mammal", "Bird", "Reptile", "Amphibian"),
                                2, // "Reptile"
                                "https://images.unsplash.com/photo-1686016833013-605fe465981d?w=500&auto=format&fit=crop&q=60&ixlib=rb-4.0.3&ixid=M3wxMjA3fDB8MHxzZWFyY2h8Nnx8a29tb2RvJTIwZHJhZ29ufGVufDB8fDB8fHwy",
                                DifficultyLevel.Intermediate));

                animalQuestions.add(new AnimalQuestionModel(
                                18L,
                                "Which animal is known for its ability to change color?",
                                Arrays.asList("Chameleon", "Lizard", "Frog", "Turtle"),
                                0, // "Chameleon"
                                "https://images.unsplash.com/photo-1488031470693-c1a6d1a4fff7?w=500&auto=format&fit=crop&q=60&ixlib=rb-4.0.3&ixid=M3wxMjA3fDB8MHxzZWFyY2h8NXx8Y2hhbWVsZW9ufGVufDB8fDB8fHwy",
                                DifficultyLevel.Intermediate));

                animalQuestions.add(new AnimalQuestionModel(
                                19L,
                                "Which mammal is known for hanging upside down?",
                                Arrays.asList("Monkey", "Bat", "Raccoon", "Possum"),
                                1, // "Bat"
                                "https://images.unsplash.com/photo-1593594926126-d0ed6fb8a638?w=500&auto=format&fit=crop&q=60&ixlib=rb-4.0.3&ixid=M3wxMjA3fDB8MHxzZWFyY2h8MTB8fGJhdHxlbnwwfHwwfHx8Mg%3D%3D",
                                DifficultyLevel.Intermediate));

                // Advanced-level questions
                animalQuestions.add(new AnimalQuestionModel(
                                20L,
                                "What is the only mammal capable of true flight?",
                                Arrays.asList("Bat", "Squirrel", "Penguin", "Parrot"),
                                0, // "Bat"
                                "https://images.unsplash.com/photo-1593594926126-d0ed6fb8a638?w=500&auto=format&fit=crop&q=60&ixlib=rb-4.0.3&ixid=M3wxMjA3fDB8MHxzZWFyY2h8MTB8fGJhdHxlbnwwfHwwfHx8Mg%3D%3D",
                                DifficultyLevel.Advanced));

                animalQuestions.add(new AnimalQuestionModel(
                                21L,
                                "Which animal has the largest brain relative to its body size?",
                                Arrays.asList("Dolphin", "Octopus", "Elephant", "Squirrel"),
                                1, // "Octopus"
                                "https://images.unsplash.com/photo-1564492051408-8969bf1b8ffb?w=500&auto=format&fit=crop&q=60&ixlib=rb-4.0.3&ixid=M3wxMjA3fDB8MHxzZWFyY2h8Mnx8b2N0b3B1c3xlbnwwfHwwfHx8Mg%3D%3D",
                                DifficultyLevel.Advanced));

                animalQuestions.add(new AnimalQuestionModel(
                                22L,
                                "Which animal's scientific name is Panthera leo?",
                                Arrays.asList("Tiger", "Lion", "Jaguar", "Cheetah"),
                                1, // "Lion"
                                "https://images.unsplash.com/photo-1552410260-0fd9b577afa6?w=500&auto=format&fit=crop&q=60&ixlib=rb-4.0.3&ixid=M3wxMjA3fDB8MHxzZWFyY2h8MTF8fExpb258ZW58MHx8MHx8fDI%3D",
                                DifficultyLevel.Advanced));

                animalQuestions.add(new AnimalQuestionModel(
                                23L,
                                "What animal has the longest migration route?",
                                Arrays.asList("Elephant", "Humpback Whale", "Arctic Tern", "Monarch Butterfly"),
                                2, // "Arctic Tern"
                                "https://images.unsplash.com/photo-1704303666797-82b42f5b05a1?w=500&auto=format&fit=crop&q=60&ixlib=rb-4.0.3&ixid=M3wxMjA3fDB8MHxzZWFyY2h8Nnx8YXJjdGljJTIwdGVybnxlbnwwfHwwfHx8Mg%3D%3D",
                                DifficultyLevel.Advanced));

                animalQuestions.add(new AnimalQuestionModel(
                                24L,
                                "Which animal can live without water for months?",
                                Arrays.asList("Camel",  "Elephant", "Giraffe", "Kangaroo Rat"),
                                3, // "Kangaroo Rat"
                                "https://www.nps.gov/orpi/learn/nature/images/Merriam-s_Kangaroo_Rat_Chihuahuan_Desert_New_Mexico_cropped.jpg?maxwidth=1300&maxheight=1300&autorotate=false",
                                DifficultyLevel.Advanced));

                // Additional Beginner-level questions
                animalQuestions.add(new AnimalQuestionModel(
                                25L,
                                "What animal is often kept as a pet and known for purring?",
                                Arrays.asList("Dog", "Hamster",  "Parrot", "Cat"),
                                3, // "Cat"
                                "https://images.unsplash.com/photo-1514888286974-6c03e2ca1dba?w=500&auto=format&fit=crop&q=60&ixlib=rb-4.0.3&ixid=M3wxMjA3fDB8MHxzZWFyY2h8N3x8Y2F0fGVufDB8fDB8fHwy",
                                DifficultyLevel.Beginner));

                animalQuestions.add(new AnimalQuestionModel(
                                26L,
                                "Which animal lives in colonies and is known for its honeycomb nests?",
                                Arrays.asList("Bee", "Ant", "Wasp", "Termite"),
                                0, // "Bee"
                                "https://images.unsplash.com/photo-1534512547189-5944d6fd30e8?w=500&auto=format&fit=crop&q=60&ixlib=rb-4.0.3&ixid=M3wxMjA3fDB8MHxzZWFyY2h8OXx8YmVlfGVufDB8fDB8fHwy",
                                DifficultyLevel.Beginner));

                animalQuestions.add(new AnimalQuestionModel(
                                27L,
                                "Which animal is known for its distinctive black and white fur and loves bamboo?",
                                Arrays.asList("Giraffe", "Bear", "Panda", "Tiger"),
                                2, // "Panda"
                                "https://images.unsplash.com/photo-1527118732049-c88155f2107c?w=500&auto=format&fit=crop&q=60&ixlib=rb-4.0.3&ixid=M3wxMjA3fDB8MHxzZWFyY2h8Nnx8cGFuZGF8ZW58MHx8MHx8fDI%3D",
                                DifficultyLevel.Beginner));

                animalQuestions.add(new AnimalQuestionModel(
                                28L,
                                "Which marine animal is known for its eight tentacles?",
                                Arrays.asList("Starfish", "Shark", "Octopus", "Jellyfish"),
                                2, // "Octopus"
                                "https://images.unsplash.com/photo-1564492051408-8969bf1b8ffb?w=500&auto=format&fit=crop&q=60&ixlib=rb-4.0.3&ixid=M3wxMjA3fDB8MHxzZWFyY2h8Mnx8b2N0b3B1c3xlbnwwfHwwfHx8Mg%3D%3D",
                                DifficultyLevel.Beginner));

                animalQuestions.add(new AnimalQuestionModel(
                                29L,
                                "Which animal has a trunk and large ears and is known as the largest land animal?",
                                Arrays.asList("Giraffe", "Elephant", "Rhino", "Lion"),
                                1, // "Elephant"
                                "https://images.unsplash.com/photo-1507461476191-0ed4f9f18533?w=500&auto=format&fit=crop&q=60&ixlib=rb-4.0.3&ixid=M3wxMjA3fDB8MHxzZWFyY2h8N3x8ZWxlcGhhbnR8ZW58MHx8MHx8fDI%3D",
                                DifficultyLevel.Beginner));

                // Additional Intermediate-level questions
                animalQuestions.add(new AnimalQuestionModel(
                                30L,
                                "Which animal has the most powerful bite in the animal kingdom?",
                                Arrays.asList("Lion", "Tiger", "Crocodile", "Shark"),
                                2, // "Crocodile"
                                "https://images.unsplash.com/photo-1520542099817-0d19524eccca?w=500&auto=format&fit=crop&q=60&ixlib=rb-4.0.3&ixid=M3wxMjA3fDB8MHxzZWFyY2h8OHx8Y3JvY29kaWxlfGVufDB8fDB8fHwy",
                                DifficultyLevel.Intermediate));

                animalQuestions.add(new AnimalQuestionModel(
                                31L,
                                "Which bird is known for its elaborate mating dance and colorful feathers?",
                                Arrays.asList("Sparrow", "Peacock", "Parrot", "Eagle"),
                                2, // "Peacock"
                                "https://images.unsplash.com/photo-1502031176098-2e91ccc16e59?w=500&auto=format&fit=crop&q=60&ixlib=rb-4.0.3&ixid=M3wxMjA3fDB8MHxzZWFyY2h8Mnx8cGVhY29ja3xlbnwwfHwwfHx8Mg%3D%3D",
                                DifficultyLevel.Intermediate));

                animalQuestions.add(new AnimalQuestionModel(
                                32L,
                                "What is the name of the world's largest fish?",
                                Arrays.asList("Great White Shark", "Whale Shark", "Dolphin", "Manta Ray"),
                                1, // "Whale Shark"
                                "https://images.unsplash.com/photo-1464926322190-70f42beb8250?w=500&auto=format&fit=crop&q=60&ixlib=rb-4.0.3&ixid=M3wxMjA3fDB8MHxzZWFyY2h8OXx8d2hhbGUlMjBzaGFya3xlbnwwfHwwfHx8Mg%3D%3D",
                                DifficultyLevel.Intermediate));

                animalQuestions.add(new AnimalQuestionModel(
                                33L,
                                "Which animal is known as the king of the jungle?",
                                Arrays.asList("Elephant", "Tiger", "Lion", "Leopard"),
                                2, // "Lion"
                                "https://images.unsplash.com/photo-1552410260-0fd9b577afa6?w=500&auto=format&fit=crop&q=60&ixlib=rb-4.0.3&ixid=M3wxMjA3fDB8MHxzZWFyY2h8MTF8fExpb258ZW58MHx8MHx8fDI%3D",
                                DifficultyLevel.Intermediate));

                animalQuestions.add(new AnimalQuestionModel(
                                34L,
                                "What type of animal is a koala?",
                                Arrays.asList("Marsupial", "Mammal", "Bird", "Reptile"),
                                0, // "Marsupial"
                                "https://images.unsplash.com/photo-1459262838948-3e2de6c1ec80?w=500&auto=format&fit=crop&q=60&ixlib=rb-4.0.3&ixid=M3wxMjA3fDB8MHxzZWFyY2h8Mnx8a29hbGF8ZW58MHx8MHx8fDI%3D",
                                DifficultyLevel.Intermediate));

                // Additional Advanced-level questions
                animalQuestions.add(new AnimalQuestionModel(
                                35L,
                                "Which animal has a species that can survive in space?",
                                Arrays.asList("Human", "Tardigrade", "Cat", "Elephant"),
                                1, // "Tardigrade"
                                "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcRBWrz1ZQJREV-9QB5mXgMR3t5yaJncyTLyhQ&s",
                                DifficultyLevel.Advanced));

                animalQuestions.add(new AnimalQuestionModel(
                                36L,
                                "Which animal produces one of the most potent toxins?",
                                Arrays.asList("Cobra", "Scorpion", "Box Jellyfish", "Piranha"),
                                2, // "Box Jellyfish"
                                "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcRovQSLIBHRyCrUO0xfxPzKUPgYw0Zucq4b_A&s",
                                DifficultyLevel.Advanced));

                animalQuestions.add(new AnimalQuestionModel(
                                37L,
                                "Which insect is known for living in a hive and having a single queen?",
                                Arrays.asList("Bee", "Ant", "Wasp", "Butterfly"),
                                0, // "Bee"
                                "https://images.unsplash.com/photo-1470938330186-da818256fa34?w=500&auto=format&fit=crop&q=60&ixlib=rb-4.0.3&ixid=M3wxMjA3fDB8MHxzZWFyY2h8MXx8YmVlfGVufDB8fDB8fHwy",
                                DifficultyLevel.Advanced));

                animalQuestions.add(new AnimalQuestionModel(
                                38L,
                                "What mammal can hold its breath underwater for up to 2 hours?",
                                Arrays.asList("Seal", "Whale", "Dolphin", "Sperm Whale"),
                                3, // "Sperm Whale"
                                "https://nws.ams3.cdn.digitaloceanspaces.com/content/5A33D1474A94741A998AA72B8C722C9B/526-2048.webp",
                                DifficultyLevel.Advanced));

                animalQuestions.add(new AnimalQuestionModel(
                                39L,
                                "Which animal is known for using tools in the wild, like sticks for catching food?",
                                Arrays.asList("Dolphin", "Chimpanzee", "Elephant", "Lion"),
                                1, // "Chimpanzee"
                                "https://images.unsplash.com/photo-1533725920959-5cd2c514d898?w=500&auto=format&fit=crop&q=60&ixlib=rb-4.0.3&ixid=M3wxMjA3fDB8MHxzZWFyY2h8Mnx8Y2hpbXBhbnplZXxlbnwwfHwwfHx8Mg%3D%3D",
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
