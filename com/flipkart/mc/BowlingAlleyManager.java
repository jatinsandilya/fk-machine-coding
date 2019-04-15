package com.flipkart.mc;


import java.util.List;
import java.util.Scanner;

import static com.flipkart.mc.BowlingAlleyContants.*;

public class BowlingAlleyManager {

    private static ScoreBoard scoreBoard;
    private static Integer totalPlayers;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        totalPlayers = scanner.nextInt();
        init();
        play();
        addBonuses();
        displayFinalStandings();

    }

    private static void addBonuses() {

        for(Player p : scoreBoard.getPlayers()){
            for(int j = p.getScores().size()-1 ; j >=0;j--){
                Score score  = p.getScores().get(j);
                if(score.getRound()==TOTAL_ROUNDS-1 && score.getChanceScores().size() == TOTAL_CHANCES_PER_ROUND){
                    if(MAX_BOWLING_PINS.equals(score.getTotalRoundScore()) ){
                        p.addBonus(SPARE_BONUS);
                    }
                }
                else if(score.getRound()==TOTAL_ROUNDS-1 && score.getChanceScores().size() > TOTAL_CHANCES_PER_ROUND){

                    for(int i=0;i<score.getChanceScores().size();i++){
                        if(MAX_BOWLING_PINS.equals(score.getChanceScores().get(i))){
                            p.addBonus(STRIKE_BONUS);
                        }
                    }

                    if(score.getChanceScores().size()==TOTAL_CHANCES_PER_ROUND+1){
                        List<Integer> chancesScore = score.getChanceScores();
                        if(MAX_BOWLING_PINS.equals(chancesScore.get(1) + chancesScore.get(2))){
                            p.addBonus(SPARE_BONUS);
                        }
                    }
                    else{
                        List<Integer> chancesScore = score.getChanceScores();
                        if(MAX_BOWLING_PINS.equals(chancesScore.get(2) + chancesScore.get(3))){
                            p.addBonus(SPARE_BONUS);
                        }
                        if(MAX_BOWLING_PINS.equals(chancesScore.get(0) + chancesScore.get(1))){
                            p.addBonus(SPARE_BONUS);
                        }
                    }

                }
                else if(MAX_BOWLING_PINS.equals(score.getTotalRoundScore()) ){
                    if(TOTAL_CHANCES_PER_ROUND > score.getChanceScores().size()){
                        // strike
                        p.addBonus(STRIKE_BONUS);
                    }
                    else{
                        // spare
                        p.addBonus(SPARE_BONUS);
                    }
                }
            }
        }
    }

    private static void displayFinalStandings() {
        scoreBoard.rankPlayers();
        System.out.println("Rank wise players: ");
        scoreBoard.displayRankingWise();
        System.out.println("Final Scoreboard: ");
        scoreBoard.displayScoreboard();
    }

    public static void init(){
        scoreBoard = new ScoreBoard(totalPlayers);
    }
    public static void play(){
        for (Integer i = 0; i < TOTAL_ROUNDS; i++) {
            for(int j = 0;j < totalPlayers;j++ ){
                System.out.println("Enter score for per chance for round : " + Integer.toString(i+1)  + " & player : " + Integer.toString(j+1) );
                Player currentPlayer = scoreBoard.getPlayers().get(j);
                Integer totalInRound = 0;
                Score s = new Score(i);
                for (int k = 0; k < TOTAL_CHANCES_PER_ROUND ; k++) {
                    Scanner scanner = new Scanner(System.in);
                    Integer chanceScore = scanner.nextInt();
                    totalInRound += chanceScore;
                    s.addChanceScore(chanceScore);
                    if(MAX_BOWLING_PINS.equals(chanceScore)) {
                        break;
                    }
                }

                if((MAX_BOWLING_PINS.compareTo(totalInRound) == 0 ) && (((TOTAL_ROUNDS)-1)==i)) {
                    for (int k = 0; k < EXTRA_CHANCES_LAST_ROUND ; k++) {
                        Scanner scanner = new Scanner(System.in);
                        Integer chanceScore = scanner.nextInt();
                        totalInRound += chanceScore;
                        s.addChanceScore(chanceScore);
                    }
                }
                currentPlayer.addScore(s);
            }
        }
    }
}
