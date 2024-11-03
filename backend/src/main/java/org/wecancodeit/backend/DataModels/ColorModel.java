package org.wecancodeit.backend.DataModels;

import java.util.List;
import org.wecancodeit.backend.Enums.DifficultyLevel;
import jakarta.persistence.*;

@Entity
public class ColorModel {
    @Id
    private Long id;

    @ElementCollection
    private List<String> answerChoices;

    
    private DifficultyLevel difficulty;

    private String questionText;
    private String answer;
    private String imageUrl;

    public ColorModel() {}

    public ColorModel(Long id, String questionText, List<String> answerChoices, String answer, String imageUrl, DifficultyLevel difficulty) {
        this.questionText = questionText;
        this.answerChoices = answerChoices;
        this.answer = answer;
        this.imageUrl = imageUrl;
        this.difficulty = difficulty;
    }

    public Long getId() {
        return id;
    }

    public List<String> getAnswerChoices() {
        return answerChoices;
    }

    public void setAnswerChoices(List<String> answerChoices) {
        this.answerChoices = answerChoices;
    }

    public DifficultyLevel getDifficulty() {
        return difficulty;
    }

    public void setDifficulty(DifficultyLevel difficulty) {
        this.difficulty = difficulty;
    }

    public String getQuestionText() {
        return questionText;
    }

    public void setQuestionText(String questionText) {
        this.questionText = questionText;
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

    
}
