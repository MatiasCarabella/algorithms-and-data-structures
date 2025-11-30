package main.java.com.app.ads1.lab1.office;

public class Office {
  private int number;
  private int floor;

  public Office(int number, int floor) {
    this.number = number;
    this.floor = floor;
  }

  @Override
  public String toString() {
    return "Office [number=" + number + ", floor=" + floor + "]";
  }
}
