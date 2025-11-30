package main.java.com.app.adsw.lab4.quicksort;

import main.java.com.app.adsw.lab4.team.Team;

/**
 * QuickSort implementation for sorting teams by points (descending).
 */
public class QuickSort {
    public static void sort(Team[] teams) {
        if (teams == null || teams.length == 0) {
            return;
        }
        quicksort(teams, 0, teams.length - 1);
    }

    private static void quicksort(Team[] teams, int low, int high) {
        int i = low, j = high;
        int pivot = teams[low + (high - low) / 2].points;

        while (i <= j) {
            while (teams[i].points > pivot) {
                i++;
            }
            while (teams[j].points < pivot) {
                j--;
            }
            if (i <= j) {
                swap(teams, i, j);
                i++;
                j--;
            }
        }

        if (low < j) {
            quicksort(teams, low, j);
        }
        if (i < high) {
            quicksort(teams, i, high);
        }
    }

    private static void swap(Team[] teams, int i, int j) {
        Team temp = teams[i];
        teams[i] = teams[j];
        teams[j] = temp;
    }
}
