package com.flipkart.mc;

import java.util.ArrayList;
import java.util.List;

import static com.flipkart.mc.BowlingAlleyContants.CHANCE_SCORE_DELIMITER_RIGHT;

public class Score {

    private Integer round;
    private List<Integer> chanceScores;
    private Integer totalRoundScore;

    public Integer getTotalRoundScore() {
        return totalRoundScore;
    }

    public void setTotalRoundScore(Integer totalRoundScore) {
        this.totalRoundScore = totalRoundScore;
    }

    public Score(Integer round) {
        this.round = round;
        this.totalRoundScore = 0;
        this.chanceScores = new ArrayList<>();
    }
    public Score(Integer round, List<Integer> chanceScores){
        this.round = round;
        this.chanceScores = chanceScores;
    }

    public Integer getRound() {
        return round;
    }

    public void setRound(Integer round) {
        this.round = round;
    }

    public List<Integer> getChanceScores() {
        return chanceScores;
    }

    public void setChanceScores(List<Integer> chanceScores) {
        this.chanceScores = chanceScores;
    }
    public void addChanceScore(Integer chanceScore){
        this.totalRoundScore += chanceScore;
        chanceScores.add(chanceScore);
    }

    public void display(){
        for (int i = 0; i < chanceScores.size(); i++) {
                System.out.print(chanceScores.get(i));
                if(i!=chanceScores.size()){
                    System.out.print(CHANCE_SCORE_DELIMITER_RIGHT);
                }
        }
    }
}
