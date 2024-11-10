package org.wecancodeit.backend.DataModels;

import java.util.*;

import org.wecancodeit.backend.Enums.DifficultyLevel;

public class AnimalQuestionModel {
    private Long id; // have an ID for the question
    private String questionText; // this will be the question
    private List<String> answerChoices; // this is the answer to the question
    private int answer; // int containing the answer index in the arraylist
    private String imageUrl; // url for the image source
    private DifficultyLevel difficulty; // this is using the enum to set difficulty

    /*
     * Constructor for my animal questions
     */
    public AnimalQuestionModel(Long id, String questionText, List<String> answerChoices, int answer, String imageUrl,
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
    public Long getId() {
        return id;
    }



    public void setId(Long id) {
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



    public int getAnswer() {
        return answer;
    }



    public void setAnswer(int answer) {
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
