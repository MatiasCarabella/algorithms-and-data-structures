package main.java.com.app.adsw.lab4.team;

/**
 * Represents a sports team with name and points.
 */
public class Team {
    public String name;
    public int points;

    public Team(String name, int points) {
        this.name = name;
        this.points = points;
    }

    public String display() {
        return name + ": " + points + " points";
    }
}
