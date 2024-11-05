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

        // ---------------------------------------------------------------------------------------------------------
        // ----------------------------------------------------Beginner---------------------------------------------
        // ---------------------------------------------------------------------------------------------------------
        questions.add(new ColorModel(
                1L, // id
                "What color is the sky on a clear day?", // question text
                Arrays.asList("Blue", "Green", "Red", "Yellow"), // list of answer choices
                "Blue", // answer
                "https://images.pexels.com/photos/53594/blue-clouds-day-fluffy-53594.jpeg", // image url
                DifficultyLevel.Beginner)); // difficulty level enum | in this case 0

        questions.add(new ColorModel(
                2L,
                "What color do you get when you mix red and white?",
                Arrays.asList("Pink", "Purple", "Orange", "Brown"),
                "Pink",
                "https://cdn11.bigcommerce.com/s-3uewkq06zr/images/stencil/400x400/products/167/545/fluorescent_pink__88286.1492541116.png?c=2",
                DifficultyLevel.Beginner));

        questions.add(new ColorModel(
                3L,
                "What color are most leaves?",
                Arrays.asList("Green", "Blue", "Yellow", "Red"),
                "Green",
                "https://media.istockphoto.com/id/668288668/photo/green-leaves-background.jpg?s=612x612&w=0&k=20&c=0u4c95Hijsi6ErfMyyRRY7w1jDyeVK_US0TYvnef73Q=",
                DifficultyLevel.Beginner));

        questions.add(new ColorModel(
                4L,
                "What color is a lemon?",
                Arrays.asList("Yellow", "Blue", "Red", "Purple"),
                "Yellow",
                "https://i0.wp.com/images-prod.healthline.com/hlcmsresource/images/AN_images/lemons-1296x728-feature.jpg?w=1155&h=1528",
                DifficultyLevel.Beginner));

        questions.add(new ColorModel(
                5L,
                "What color do you get when you mix blue and yellow?",
                Arrays.asList("Green", "Orange", "Purple", "Brown"),
                "Green",
                "https://img.freepik.com/premium-vector/abstract-background-small-triangles-yellow-green-blue-colors_444390-7373.jpg",
                DifficultyLevel.Beginner));

        questions.add(new ColorModel(
                6L,
                "What color is the sun often drawn as?",
                Arrays.asList("Yellow", "Green", "Red", "Purple"),
                "Yellow",
                "https://images.ctfassets.net/hrltx12pl8hq/3PHSQUIo1jOzeug2XNNSjk/cb4f9c298aaf7dfc4a68e03d1e11f5fd/sun-images.jpg?fit=fill&w=600&h=400",
                DifficultyLevel.Beginner));

        questions.add(new ColorModel(
                7L,
                "What color are most strawberries?",
                Arrays.asList("Red", "Blue", "Yellow", "Green"),
                "Red",
                "https://media.istockphoto.com/id/477834644/photo/fresh-strawberries-background.jpg?s=612x612&w=0&k=20&c=JwLE9J3zbe9A3zdPmt2oF62moYytxeKTMBY-QCruMas=",
                DifficultyLevel.Beginner));

        questions.add(new ColorModel(
                8L,
                "What color do you get when you mix blue and red?",
                Arrays.asList("Purple", "Orange", "Green", "Pink"),
                "Purple",
                "https://wallpapers.com/images/hd/blue-and-red-background-1920-x-1200-honc1z1hrh0ilv0r.jpg",
                DifficultyLevel.Beginner));

        questions.add(new ColorModel(
                9L,
                "What color is a pumpkin usually?",
                Arrays.asList("Orange", "Red", "Green", "Purple"),
                "Orange",
                "https://hraf.yale.edu/wp-content/uploads/2014/10/pumpkin-4454745_1280.jpg",
                DifficultyLevel.Beginner));

        questions.add(new ColorModel(
                10L,
                "What color is grass?",
                Arrays.asList("Green", "Yellow", "Blue", "Pink"),
                "Green",
                "https://cdn.britannica.com/22/215522-050-8315BB78/green-grass-close-up.jpg",
                DifficultyLevel.Beginner));

        questions.add(new ColorModel(
                11L,
                "What color do you get when you mix red and yellow?",
                Arrays.asList("Orange", "Green", "Purple", "Gray"),
                "Orange",
                "https://img.freepik.com/premium-photo/red-yellow-gradient-background-with-copy-space-text-image_7954-38041.jpg?semt=ais_hybrid",
                DifficultyLevel.Beginner));

        questions.add(new ColorModel(
                12L,
                "What color is snow?",
                Arrays.asList("White", "Red", "Yellow", "Green"),
                "White",
                "https://hips.hearstapps.com/clv.h-cdn.co/assets/16/49/2048x1365/gettyimages-492392636-1.jpg?resize=980:*",
                DifficultyLevel.Beginner));

        questions.add(new ColorModel(
                13L,
                "What color are most apples?",
                Arrays.asList("Red", "Green", "Yellow", "Blue"),
                "Red",
                "https://cdn.britannica.com/22/187222-050-07B17FB6/apples-on-a-tree-branch.jpg",
                DifficultyLevel.Beginner));

        questions.add(new ColorModel(
                14L,
                "What color do you get when you mix white and black?",
                Arrays.asList("Gray", "Pink", "Purple", "Blue"),
                "Gray",
                "https://www.publicdomainpictures.net/pictures/410000/nahled/black-and-white-gradient-background.jpg",
                DifficultyLevel.Beginner));

        questions.add(new ColorModel(
                15L,
                "What color is chocolate typically?",
                Arrays.asList("Brown", "Red", "Yellow", "Orange"),
                "Brown",
                "https://elavegan.com/wp-content/uploads/2023/01/homemade-chocolate-bars.jpg",
                DifficultyLevel.Beginner));

        questions.add(new ColorModel(
                16L,
                "What color is the outside of a watermelon?",
                Arrays.asList("Green", "Red", "Yellow", "Blue"),
                "Green",
                "https://snaped.fns.usda.gov/sites/default/files/seasonal-produce/2018-05/watermelon.jpg",
                DifficultyLevel.Beginner));

        questions.add(new ColorModel(
                17L,
                "What color do you get when you mix blue and white?",
                Arrays.asList("Light Blue", "Purple", "Green", "Gray"),
                "Light Blue",
                "https://www.color-meanings.com/wp-content/uploads/2022/01/blue-white-abstract-pattern.png",
                DifficultyLevel.Beginner));

        questions.add(new ColorModel(
                18L,
                "What color are bananas?",
                Arrays.asList("Yellow", "Green", "Red", "Purple"),
                "Yellow",
                "https://www.foodandwine.com/thmb/4fzQW9u60XlhTk52CIuM1BlLhcc=/1500x0/filters:no_upscale():max_bytes(150000):strip_icc()/amazonfreebananas-em-86304874-2000-5a276309cf1944349fb55818c98c7b1b.jpg",
                DifficultyLevel.Beginner));

        questions.add(new ColorModel(
                19L,
                "What color is a carrot usually?",
                Arrays.asList("Orange", "Red", "Green", "Yellow"),
                "Orange",
                "https://ucarecdn.com/459eb7be-115a-4d85-b1d8-deaabc94c643/-/format/auto/-/preview/3000x3000/-/quality/lighter/",
                DifficultyLevel.Beginner));

        questions.add(new ColorModel(
                20L,
                "What color are most fire trucks?",
                Arrays.asList("Red", "Green", "Yellow", "Blue"),
                "Red",
                "https://www.piercemfg.com/hs-fs/hubfs/multipurpose-fire-truck-image-banner.jpg?width=1140&height=530&name=multipurpose-fire-truck-image-banner.jpg",
                DifficultyLevel.Beginner));

        // ---------------------------------------------------------------------------------------------------------
        // ----------------------------------------------------Intermediate-----------------------------------------
        // ---------------------------------------------------------------------------------------------------------

        questions.add(new ColorModel(
                21L, // id
                "What color do you get when you mix red and blue?", // question text
                Arrays.asList("Purple", "Green", "Orange", "Brown"), // answer choices
                "Purple", // correct answer
                "https://upload.wikimedia.org/wikipedia/commons/thumb/a/ab/Flag_of_Liechtenstein_old_blue_red.svg/640px-Flag_of_Liechtenstein_old_blue_red.svg.png", // image url
                DifficultyLevel.Intermediate)); // difficulty level enum | in this case 1

        questions.add(new ColorModel(
                22L,
                "What color are emeralds usually?",
                Arrays.asList("Green", "Blue", "Red", "Yellow"),
                "Green",
                "https://pyxis.nymag.com/v1/imgs/e68/cd4/567ced6d821d04a34592a42847eafaf188-20-keeper-gems.2x.rsquare.w536.jpg", 
                DifficultyLevel.Intermediate));

        questions.add(new ColorModel(
                23L,
                "What color do you get when you mix blue and green?",
                Arrays.asList("Teal", "Purple", "Gray", "Brown"),
                "Teal",
                "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcRWkVJyCiuGn3HljLrTlgtZOZKQT8qRDceRdg&s", 
                DifficultyLevel.Intermediate));

        questions.add(new ColorModel(
                24L,
                "What color is a ruby?",
                Arrays.asList("Red", "Blue", "Green", "Yellow"),
                "Red",
                "https://pyxis.nymag.com/v1/imgs/e68/cd4/567ced6d821d04a34592a42847eafaf188-20-keeper-gems.2x.rsquare.w536.jpg", 
                DifficultyLevel.Intermediate));

        questions.add(new ColorModel(
                25L,
                "What colors do you mix to make orange?",
                Arrays.asList("Red and Yellow", "Blue and Yellow", "Red and Green", "Purple and Green"),
                "Red and Yellow",
                "https://images.artfulcloud.com/46287_1487850org.jpg", 
                DifficultyLevel.Intermediate));

        questions.add(new ColorModel(
                26L,
                "What color do you get when you mix yellow and green?",
                Arrays.asList("Lime", "Blue", "Orange", "Brown"),
                "Lime",
                "https://img.freepik.com/free-photo/yellow-green-wall-background_23-2148992854.jpg", 
                DifficultyLevel.Intermediate));

        questions.add(new ColorModel(
                27L,
                "What is the complementary color of purple?",
                Arrays.asList("Yellow", "Green", "Orange", "Red"),
                "Yellow",
                "https://static.wikia.nocookie.net/colors/images/9/9d/Violet_-7F00FF.png/revision/latest?cb=20240706212435", 
                DifficultyLevel.Intermediate));

        questions.add(new ColorModel(
                28L,
                "What color do you get when you mix red and green?",
                Arrays.asList("Brown", "Orange", "Purple", "Gray"),
                "Brown",
                "https://cdn.prod.website-files.com/5a9ee6416e90d20001b20038/6401dca2db92dbf5a5718b5f_Bandera_Provincia_Boli%CC%81var.svg", 
                DifficultyLevel.Intermediate));

        questions.add(new ColorModel(
                29L,
                "What primary colors make up the color brown?",
                Arrays.asList("Red, Yellow, and Blue", "Red and Green", "Yellow and Green", "Blue and Green"),
                "Red, Yellow, and Blue",
                "https://static.wikia.nocookie.net/colors/images/c/cf/964b00.png/revision/latest?cb=20240324082303", 
                DifficultyLevel.Intermediate));

        questions.add(new ColorModel(
                30L,
                "What color is often associated with the ocean?",
                Arrays.asList("Blue", "Red", "Green", "Yellow"),
                "Blue",
                "https://thumbs.dreamstime.com/b/ocean-wave-14582420.jpg", 
                DifficultyLevel.Intermediate));

        questions.add(new ColorModel(
                31L,
                "What color do you get when you mix red and yellow?",
                Arrays.asList("Orange", "Green", "Purple", "Gray"),
                "Orange",
                "https://karenhaller.com/wp-content/uploads/2011/03/Branding-red-and-yellow-colours-1.jpg", 
                DifficultyLevel.Intermediate));

        questions.add(new ColorModel(
                32L,
                "What two colors do you mix to make green?",
                Arrays.asList("Blue and Yellow", "Red and Blue", "Yellow and Red", "Green and Yellow"),
                "Blue and Yellow",
                "https://img.freepik.com/premium-photo/green-background-with-words-name-it_947073-39170.jpg?semt=ais_hybrid", 
                DifficultyLevel.Intermediate));

        questions.add(new ColorModel(
                33L,
                "What color is often used to represent happiness?",
                Arrays.asList("Yellow", "Black", "Red", "Blue"),
                "Yellow",
                "https://images.inc.com/uploaded_files/image/1920x1080/getty_478389113_970647970450091_99776.jpg", 
                DifficultyLevel.Intermediate));

        questions.add(new ColorModel(
                34L,
                "What is the complementary color of blue?",
                Arrays.asList("Orange", "Purple", "Green", "Yellow"),
                "Orange",
                "https://static.wikia.nocookie.net/aesthetics/images/a/a3/Pure_blue.png/revision/latest?cb=20210323184329", 
                DifficultyLevel.Intermediate));

        questions.add(new ColorModel(
                35L,
                "What color do you get by mixing all primary colors?",
                Arrays.asList("Brown", "Purple", "Green", "Black"),
                "Brown",
                "https://i.pinimg.com/736x/c3/05/5b/c3055b37787ced7ea4347470756c5ebe.jpg", 
                DifficultyLevel.Intermediate));

        questions.add(new ColorModel(
                36L,
                "What color is often used to symbolize calmness?",
                Arrays.asList("Blue", "Red", "Orange", "Yellow"),
                "Blue",
                "https://media.istockphoto.com/id/1432690812/photo/old-wooden-dock-at-the-lake-sunset-shot.jpg?s=612x612&w=0&k=20&c=A9cpzCCO_nN2B0pCpcOGBBzr9WXooLCEOzNB4IE-KNM=", 
                DifficultyLevel.Intermediate));

        questions.add(new ColorModel(
                37L,
                "Which of these colors is considered a warm color?",
                Arrays.asList("Red", "Blue", "Green", "Gray"),
                "Red",
                "https://st4.depositphotos.com/1058411/31372/i/450/depositphotos_313726614-stock-photo-closeup-image-of-female-hands.jpg", 
                DifficultyLevel.Intermediate));

        questions.add(new ColorModel(
                38L,
                "What colors do you mix to get gray?",
                Arrays.asList("Black and White", "Red and Green", "Blue and Orange", "Yellow and Green"),
                "Black and White",
                "https://johnboyledecorating.com/cdn/shop/products/2121-10-gray_688ab4aa-91b0-46df-8938-ee01544dfd1d_600x.png?v=1618087120", 
                DifficultyLevel.Intermediate));

        questions.add(new ColorModel(
                39L,
                "What color do you get by mixing purple and blue?",
                Arrays.asList("Indigo", "Green", "Pink", "Gray"),
                "Indigo",
                "https://img.freepik.com/premium-vector/colorful-vector-gradient-abstract-background-design-projects_901408-13188.jpg?semt=ais_hybrid", 
                DifficultyLevel.Intermediate));

        questions.add(new ColorModel(
                40L,
                "What color is associated with danger?",
                Arrays.asList("Red", "Blue", "Yellow", "Green"),
                "Red",
                "https://www.shutterstock.com/image-vector/danger-warning-icon-set-alert-260nw-2350286333.jpg", 
                DifficultyLevel.Intermediate));

        // ---------------------------------------------------------------------------------------------------------
        // ----------------------------------------------------Advanced---------------------------------------------
        // ---------------------------------------------------------------------------------------------------------
        questions.add(new ColorModel(
                41L, // id
                "What color is produced when you mix all primary colors of paint?", // question text
                Arrays.asList("Brown", "Black", "Gray", "White"), // answer choices
                "Brown", // answer
                "https://i0.wp.com/bluebeachhouseart.com/wp-content/uploads/2019/10/blog-post-colour-wheel.jpg?fit=1024%2C1024&ssl=1", // image url
                DifficultyLevel.Advanced)); // difficulty level enum | in this case 2

        questions.add(new ColorModel(
                42L,
                "What is the complementary color of green?",
                Arrays.asList("Red", "Blue", "Yellow", "Purple"),
                "Red",
                "https://static.vecteezy.com/system/resources/thumbnails/011/168/575/small_2x/color-wheel-illustration-vector.jpg", 
                DifficultyLevel.Advanced));

        questions.add(new ColorModel(
                43L,
                "What color combination creates teal?",
                Arrays.asList("Blue and Green", "Red and Blue", "Yellow and Green", "Purple and Blue"),
                "Blue and Green",
                "https://static.wikia.nocookie.net/colors/images/5/52/Main-qimg-32d8b954f3e15a526660e4afc4c157f2.png/revision/latest?cb=20231102223801", 
                DifficultyLevel.Advanced));

        questions.add(new ColorModel(
                44L,
                "What color do you get by mixing blue and orange pigments?",
                Arrays.asList("Brown", "Green", "Gray", "Purple"),
                "Brown",
                "https://www.creativefabrica.com/wp-content/uploads/2023/01/27/Royal-Blue-And-Orange-Background-With-Paint-59129576-1-1.png", 
                DifficultyLevel.Advanced));

        questions.add(new ColorModel(
                45L,
                "What two colors make purple?",
                Arrays.asList("Red and Blue", "Yellow and Blue", "Red and Green", "Yellow and Red"),
                "Red and Blue",
                "https://media.istockphoto.com/id/1398944176/vector/abstract-blurred-magenta-purple-yellow-orange-magenta-purple-background-soft-gradient.jpg?s=612x612&w=0&k=20&c=MtnCKLfpzstjorkWAMyPdCE29mwuLTTuKEEqJRACk_0=", 
                DifficultyLevel.Advanced));

        questions.add(new ColorModel(
                46L,
                "What is the hexadecimal code for the color white?",
                Arrays.asList("#FFFFFF", "#000000", "#FF0000", "#FFFF00"),
                "#FFFFFF",
                "https://images.unsplash.com/photo-1638132035918-90a22beaab3b?fm=jpg&q=60&w=3000&ixlib=rb-4.0.3&ixid=M3wxMjA3fDB8MHxzZWFyY2h8Nnx8d2hpdGV8ZW58MHx8MHx8fDA%3D", 
                DifficultyLevel.Advanced));

        questions.add(new ColorModel(
                47L,
                "What primary colors of light combine to make white light?",
                Arrays.asList("Red, Green, and Blue", "Red, Yellow, and Blue", "Green, Yellow, and Blue",
                        "Red, Green, and Yellow"),
                "Red, Green, and Blue",
                "https://www.segmation.com/wp-content/uploads/colorwheel.jpg", 
                DifficultyLevel.Advanced));

        questions.add(new ColorModel(
                48L,
                "What color is created by mixing complementary colors on the color wheel?",
                Arrays.asList("Gray", "Brown", "Black", "White"),
                "Gray",
                "https://i.pinimg.com/564x/c0/37/7c/c0377c3c9d1fbd17bd1c87482e8209bf.jpg", 
                DifficultyLevel.Advanced));

        questions.add(new ColorModel(
                49L,
                "What does the term 'saturation' describe in a color?",
                Arrays.asList("Intensity", "Brightness", "Hue", "Temperature"),
                "Intensity",
                "https://www.clipstudio.net/wp-content/uploads/2020/06/0087_001.png", 
                DifficultyLevel.Advanced));

        questions.add(new ColorModel(
                50L,
                "In color theory, what color lies directly opposite of blue on the color wheel?",
                Arrays.asList("Orange", "Green", "Yellow", "Red"),
                "Orange",
                "https://hgtvhome.sndimg.com/content/dam/images/hgtv/fullset/2011/7/18/0/HGTV_Color-Wheel-Monochromatic_s4x3.jpg.rend.hgtvcom.476.357.85.suffix/1400966919241.webp", 
                DifficultyLevel.Advanced));

        questions.add(new ColorModel(
                51L,
                "What colors are considered analogous to green on the color wheel?",
                Arrays.asList("Yellow and Blue", "Red and Yellow", "Blue and Red", "Orange and Purple"),
                "Yellow and Blue",
                "https://upload.wikimedia.org/wikipedia/commons/b/bb/Linear_RGB_color_wheel.png", 
                DifficultyLevel.Advanced));

        questions.add(new ColorModel(
                52L,
                "What term is used to describe the lightness or darkness of a color?",
                Arrays.asList("Value", "Hue", "Saturation", "Temperature"),
                "Value",
                "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcQUKL8pk2-kr8tm8-TMy3sDQ5t4ttWJHMGPNg&s", 
                DifficultyLevel.Advanced));

        questions.add(new ColorModel(
                53L,
                "What is the complementary color of yellow?",
                Arrays.asList("Purple", "Red", "Green", "Blue"),
                "Purple",
                "https://cdn.britannica.com/70/191970-131-A85628DA/Color-wheel-light-color-spectrum.jpg", 
                DifficultyLevel.Advanced));

        questions.add(new ColorModel(
                54L,
                "Which color model is primarily used in digital screens?",
                Arrays.asList("RGB", "CMYK", "RYB", "HSL"),
                "RGB",
                "https://i.ytimg.com/vi/ikpTVwlXp7E/maxresdefault.jpg", 
                DifficultyLevel.Advanced));

        questions.add(new ColorModel(
                55L,
                "What does the term 'hue' refer to in color theory?",
                Arrays.asList("The pure color", "The brightness of a color", "The lightness or darkness",
                        "The warmth of a color"),
                "The pure color",
                "https://www.kategreendesign.com/uploads/1/3/8/3/13835678/colour-wheel_orig.jpg", 
                DifficultyLevel.Advanced));

        questions.add(new ColorModel(
                56L,
                "What two colors combine to make cyan in the CMY color model?",
                Arrays.asList("Green and Blue", "Red and Blue", "Yellow and Green", "Red and Green"),
                "Green and Blue",
                "https://learn.microsoft.com/en-us/windows/win32/wcs/images/cmyclrs1.png", 
                DifficultyLevel.Advanced));

        questions.add(new ColorModel(
                57L,
                "Which color is created by mixing yellow and purple?",
                Arrays.asList("Brown", "Gray", "Blue", "Orange"),
                "Brown",
                "https://media.istockphoto.com/id/1340439185/vector/abstract-geometric-background-mosaic-with-triangle-patterns-purple-gradient.jpg?s=612x612&w=0&k=20&c=VrsH6WHo76uc71l2cDmfE6ihrdM7kzID1FPfDwtK5NU=", 
                DifficultyLevel.Advanced));

        questions.add(new ColorModel(
                58L,
                "In art, what colors are often considered 'cool' colors?",
                Arrays.asList("Blue, Green, and Purple", "Red, Yellow, and Orange", "Green, Yellow, and Red",
                        "Blue, Orange, and Green"),
                "Blue, Green, and Purple",
                "https://www.creativeventuresfineart.com/wp-content/uploads/2019/11/36830524_S-300x300.jpg", 
                DifficultyLevel.Advanced));

        questions.add(new ColorModel(
                59L,
                "What does CMYK stand for in printing?",
                Arrays.asList("Cyan, Magenta, Yellow, Black", "Cyan, Magenta, Yellow, Green",
                        "Crimson, Magenta, Yellow, Black", "Cyan, Maroon, Yellow, Black"),
                "Cyan, Magenta, Yellow, Black",
                "https://images.squarespace-cdn.com/content/v1/5fe1c9a0013d1b71f8bbe7b0/58c72e6e-9604-487b-ab2d-28400f053d7f/CMYK+Colour+Wheel+Serena+Archetti+Blog", 
                DifficultyLevel.Advanced));

        questions.add(new ColorModel(
                60L,
                "What is the difference between a tint and a shade of a color?",
                Arrays.asList("Tint is a color mixed with white, shade with black",
                        "Tint is a color mixed with black, shade with white",
                        "Tint is a color mixed with gray, shade with black",
                        "Tint is a color mixed with green, shade with yellow"),
                "Tint is a color mixed with white, shade with black",
                "https://i.pinimg.com/originals/66/60/2e/66602e267be198544af42d3e6e13ae4a.jpg", 
                DifficultyLevel.Advanced));

    }

    // ---------------------------------------------------------------------------------------------------------
    // ----------------------------------------------------Methods----------------------------------------------
    // ---------------------------------------------------------------------------------------------------------

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
     * @param difficulty the difficulty level of the question (e.g., Beginner,
     *                   Intermediate, Advanced).
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
