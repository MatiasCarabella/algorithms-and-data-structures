package main.java.com.app.ads1.lab1.building;

import java.util.Random;
import main.java.com.app.ads1.lab1.office.Office;

/**
 * Represents a building with multiple floors and offices. Demonstrates search algorithms and Big O
 * notation concepts.
 */
public class Building {
  private static final int FLOORS = 10;
  private static final int OFFICES_PER_FLOOR = 9;
  private static final int ELEVATOR_HALL = 5;

  public boolean getSensor(int floor, int office) throws Exception {
    if (floor < 1 || floor > FLOORS || office < 1 || office > OFFICES_PER_FLOOR) {
      throw new Exception(
          "Invalid floor/office combination (" + floor + "," + office + ") - No sensor available");
    }
    return new Random().nextBoolean();
  }

  public int countActiveOffices() throws Exception {
    int activeOffices = 0;
    for (int floor = 1; floor <= FLOORS; floor++) {
      for (int office = 1; office <= OFFICES_PER_FLOOR; office++) {
        if (office == ELEVATOR_HALL) continue;
        if (getSensor(floor, office)) activeOffices++;
      }
    }
    return activeOffices;
  }

  public Office findFirstActiveOffice() throws Exception {
    for (int floor = 1; floor <= FLOORS; floor++) {
      for (int office = 1; office <= OFFICES_PER_FLOOR; office++) {
        if (office == ELEVATOR_HALL) continue;
        if (getSensor(floor, office)) return new Office(office, floor);
      }
    }
    return null;
  }
}
