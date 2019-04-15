package com.flipkart.mc;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class ScoreBoard {

    private List<Player> players;

    public List<Player> getPlayers() {
        return players;
    }

    public void setPlayers(List<Player> players) {
        this.players = players;
    }

    ScoreBoard(Integer n){
        this.players = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            players.add(new Player("P" + Integer.toString(i)));
        }
    }

    public void displayScoreboard(){
        for (int i = 0; i < players.size(); i++) {
            Player player_i = players.get(i);
            System.out.print(player_i.getId() + " : ");
            player_i.showScores();
            System.out.println();
        }
    }
    public void rankPlayers(){

        Collections.sort(players,new Comparator<Player>(){
            @Override
            public int compare(Player p1, Player p2) {
                return p2.getTotalScore().compareTo(p1.getTotalScore());
            }
        });
    }

    public void displayRankingWise(){
        for (int i = 0; i < players.size(); i++) {
            Player player = players.get(i);
            System.out.print(player.getId() + " - " + player.getTotalScore());
            System.out.println();
        }
    }
}
