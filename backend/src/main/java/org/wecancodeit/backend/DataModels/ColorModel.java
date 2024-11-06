package org.wecancodeit.backend.DataModels;

import java.util.List;
import org.wecancodeit.backend.Enums.DifficultyLevel;
import jakarta.persistence.*;

/**
 * Entity representing a color-related question, including question text, answer choices, 
 * correct answer, image URL, and difficulty level.
 */
@Entity
public class ColorModel {

    /** Unique identifier for each question (auto-generated when saved in a database). */
    @Id
    private Long id;

    /** List of possible answers for the question. */
    @ElementCollection
    private List<String> answerChoices;

    /** Difficulty level of the question (e.g., BEGINNER, INTERMEDIATE, ADVANCED). */
    private DifficultyLevel difficulty;

    /** Text of the question being asked. */
    private String questionText;

    /** Correct answer for the question. */
    private String answer;

    /** URL pointing to an image related to the question, if applicable. */
    private String imageUrl;

    /**
     * Default constructor required by JPA.
     */
    public ColorModel() {}

    /**
     * Constructs a new ColorModel question with specified details.
     * 
     * @param id            the unique identifier of the question
     * @param questionText  the text of the question
     * @param answerChoices a list of possible answers for the question
     * @param answer        the correct answer
     * @param imageUrl      the URL of an image related to the question
     * @param difficulty    the difficulty level of the question
     */
    public ColorModel(Long id, String questionText, List<String> answerChoices, String answer, String imageUrl, DifficultyLevel difficulty) {
        this.id = id;
        this.questionText = questionText;
        this.answerChoices = answerChoices;
        this.answer = answer;
        this.imageUrl = imageUrl;
        this.difficulty = difficulty;
    }

    /**
     * Retrieves the unique identifier of the question.
     * 
     * @return the question ID
     */
    public Long getId() {
        return id;
    }

    /**
     * Retrieves the list of possible answers for the question.
     * 
     * @return a list of answer choices
     */
    public List<String> getAnswerChoices() {
        return answerChoices;
    }

    /**
     * Sets the list of possible answers for the question.
     * 
     * @param answerChoices the list of answer choices
     */
    public void setAnswerChoices(List<String> answerChoices) {
        this.answerChoices = answerChoices;
    }

    /**
     * Retrieves the difficulty level of the question.
     * 
     * @return the difficulty level
     */
    public DifficultyLevel getDifficulty() {
        return difficulty;
    }

    /**
     * Sets the difficulty level of the question.
     * 
     * @param difficulty the difficulty level
     */
    public void setDifficulty(DifficultyLevel difficulty) {
        this.difficulty = difficulty;
    }

    /**
     * Retrieves the text of the question.
     * 
     * @return the question text
     */
    public String getQuestionText() {
        return questionText;
    }

    /**
     * Sets the text of the question.
     * 
     * @param questionText the question text
     */
    public void setQuestionText(String questionText) {
        this.questionText = questionText;
    }

    /**
     * Retrieves the correct answer to the question.
     * 
     * @return the correct answer
     */
    public String getAnswer() {
        return answer;
    }

    /**
     * Sets the correct answer to the question.
     * 
     * @param answer the correct answer
     */
    public void setAnswer(String answer) {
        this.answer = answer;
    }

    /**
     * Retrieves the URL of an image related to the question.
     * 
     * @return the image URL
     */
    public String getImageUrl() {
        return imageUrl;
    }

    /**
     * Sets the URL of an image related to the question.
     * 
     * @param imageUrl the image URL
     */
    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }
}
