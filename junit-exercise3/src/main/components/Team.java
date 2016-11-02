package main.components;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by simon.gomez on 10/12/2016.
 */
public class Team {

    private String name;
    private Coach coach;
    private List<Player> playerList = new ArrayList<>();

    public Team(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public Coach getCoach() {
        return coach;
    }

    public List<Player> getPlayerList() {
        return playerList;
    }

    public boolean contractPlayer(Player player) {
        return false;
    }

    public boolean firePlayer(String name) {
        return false;
    }

    public Player getPlayer(String name) {
        return null;
    }

    public List<Player> getPlayers(Position position) {
        return null;
    }

    public boolean contractCoach(Coach coach) {
        return false;
    }

    public boolean fireCoach() {
        return false;
    }

    public boolean validateTeam() {
        return true;
    }
}
