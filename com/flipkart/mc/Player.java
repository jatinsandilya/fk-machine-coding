package com.flipkart.mc;

import java.util.ArrayList;
import java.util.List;

import static com.flipkart.mc.BowlingAlleyContants.SCORE_DELIMITER_LEFT;
import static com.flipkart.mc.BowlingAlleyContants.SCORE_DELIMITER_RIGHT;

public class Player {

    private String id;
    private List<Score> scores;
    private Integer totalScore;

    Player(){

    }

    Player(String id){
        this.id = id;
        this.totalScore = 0;
        this.scores = new ArrayList<>();
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Integer getTotalScore() {
        return totalScore;
    }

    public void setTotalScore(Integer totalScore) {
        this.totalScore = totalScore;
    }

    public List<Score> getScores() {
        return scores;
    }

    public void setScores(List<Score> scores) {
        this.scores = scores;
    }

    public void addScore(Score score){
        for (int i = 0; i < score.getChanceScores().size(); i++) {
            this.totalScore += score.getChanceScores().get(i);
        }
        this.scores.add(score);
    }

    public void addBonus(Integer bonus){
        this.totalScore += bonus;
    }

    public void showScores(){
        for (int i = 0; i < this.scores.size(); i++) {
                System.out.print(SCORE_DELIMITER_LEFT);
                Score roundScore = scores.get(i);
                roundScore.display();
                System.out.print(SCORE_DELIMITER_RIGHT);
        }
    }
}
