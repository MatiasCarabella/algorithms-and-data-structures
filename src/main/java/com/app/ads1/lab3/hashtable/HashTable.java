package main.java.com.app.ads1.lab3.hashtable;

public class HashTable {
  private int data;
  public int state;

  public static int hashFunction(int value, int tableSize) {
    return value % tableSize;
  }

  public static void insert(HashTable[] table, int tableSize, int value) {
    boolean inserted = false;
    int index = hashFunction(value, tableSize);
    do {
      if (table[index].state == 0 || table[index].state == 1) {
        table[index].data = value;
        table[index].state = 2;
        inserted = true;
      } else {
        index++;
      }
    } while (index < tableSize && !inserted);
    if (inserted) {
      System.out.print("Element " + value + " INSERTED successfully at position " + index + "\n");
    } else {
      System.out.print("Table is full!\n");
    }
  }

  public static int search(HashTable[] table, int tableSize, int value) {
    int index = hashFunction(value, tableSize);
    if (table[index].data == value && table[index].state == 2) {
      System.out.print("Element " + value + " FOUND at position " + index + "\n");
      return hashFunction(value, tableSize);
    } else {
      System.out.print("Element " + value + " NOT FOUND in hash table\n");
      return -1;
    }
  }

  public static int delete(HashTable[] table, int tableSize, int value) {
    int index = search(table, tableSize, value);
    if (index == -1) {
      return -1;
    } else {
      table[index].state = 1;
      System.out.print("Element " + value + " DELETED at position " + index + "\n");
      return 1;
    }
  }
}
