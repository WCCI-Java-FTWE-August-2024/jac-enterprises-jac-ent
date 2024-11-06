package org.wecancodeit.backend.DataModels;

import java.util.*;

import org.wecancodeit.backend.Enums.DifficultyLevel;

public class AnimalQuestionModel {
    private int id; // have an ID for the question
    private String questionText; // this will be the question
    private List<String> answerChoices; // this is the answer to the question
    private String answer; // String containing the answer
    private String imageUrl; // url for the image source
    private DifficultyLevel difficulty; // this is using the enum to set difficulty

    /*
     * Constructor for my animal questions
     */
    public AnimalQuestionModel(int id, String questionText, List<String> answerChoices, String answer, String imageUrl,
            DifficultyLevel difficulty) {
        this.id = id;
        this.questionText = questionText;
        this.answerChoices = answerChoices;
        this.answer = answer;
        this.imageUrl = imageUrl;

        this.difficulty = difficulty;
    }

    /*
     * Setters and getters for my animal questions
     */
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getQuestionText() {
        return questionText;
    }

    public void setQuestionText(String questionText) {
        this.questionText = questionText;
    }

    public List<String> getAnswerChoices() {
        return answerChoices;
    }

    public void setAnswerChoices(List<String> answerChoices) {
        this.answerChoices = answerChoices;
    }

    public String getAnswer() {
        return answer;
    }

    public void setAnswer(String answer) {
        this.answer = answer;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public DifficultyLevel getDifficulty() {
        return difficulty;
    }

    public void setDifficulty(DifficultyLevel difficulty) {
        this.difficulty = difficulty;
    }

}
