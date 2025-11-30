package main.java.com.app.adsw.lab4.standings;

import java.util.Arrays;
import main.java.com.app.adsw.lab4.team.Team;
import main.java.com.app.adsw.lab4.quicksort.QuickSort;

/**
 * Standings table that maintains teams sorted by points.
 */
public class Standings {
    private Team[] teams;

    public Standings() {
        this.teams = new Team[0];
    }

    public void addTeam(Team team) {
        System.out.println("Inserting team '" + team.name + "', pts: " + team.points);
        teams = Arrays.copyOf(teams, teams.length + 1);
        teams[teams.length - 1] = team;
        QuickSort.sort(teams);
    }

    public void displayTable() {
        int i = 1;
        for (Team team : teams) {
            System.out.println(i + ". " + team.name + " - Pts: " + team.points);
            i++;
        }
    }
}
