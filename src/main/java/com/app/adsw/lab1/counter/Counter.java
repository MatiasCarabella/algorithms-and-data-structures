package main.java.com.app.adsw.lab1.counter;

/** Counter utility class for character frequency analysis. */
public class Counter {
  /**
   * Counts the frequency of each character in a word.
   *
   * @param word the word to analyze (must be uppercase letters only)
   */
  public static void frequencyCount(String word) {
    int[] counts = new int[26];
    char lastCharacter = '.';

    try {
      for (int i = 0; i < word.length(); i++) {
        lastCharacter = word.charAt(i);
        counts[lastCharacter - 'A']++;
      }
    } catch (ArrayIndexOutOfBoundsException e) {
      System.out.println("Not a valid character: '" + lastCharacter + "'");
    }

    System.out.println();
    for (int i = 0; i < counts.length; i++) {
      if (counts[i] != 0) {
        System.out.println((char) (i + 'A') + ": " + counts[i]);
      }
    }
  }

  /**
   * Counts how many times a word appears in an array of words.
   *
   * @param words the array of words to search
   * @param word the word to count
   * @return the number of occurrences
   */
  public static int occurrenceCount(String[] words, String word) {
    int counter = 0;
    for (int i = 0; i < words.length - 1; i++) {
      if (words[i] == null) break;
      if (words[i].equalsIgnoreCase(word)) {
        counter++;
      }
    }
    return counter;
  }
}
