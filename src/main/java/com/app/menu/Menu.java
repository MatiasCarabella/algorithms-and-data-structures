package main.java.com.app.menu;

import java.util.Scanner;
import main.java.com.app.ads1.lab1.building.Building;
import main.java.com.app.ads1.lab1.office.Office;
import main.java.com.app.ads1.lab2.stack.Stack;
import main.java.com.app.ads1.lab3.hashtable.HashTable;
import main.java.com.app.ads1.lab4.mergesort.MergeSort;
import main.java.com.app.ads1.lab4.quicksort.QuickSort;
import main.java.com.app.ads2.lab2.binarynode.BinaryNode;
import main.java.com.app.ads2.lab2.tree.BinaryTree;
import main.java.com.app.ads2.lab3.bst.BST;
import main.java.com.app.ads2.lab4.huffmantree.HuffmanTree;
import main.java.com.app.adsw.lab1.counter.Counter;
import main.java.com.app.adsw.lab2.arraystack.ArrayStack;
import main.java.com.app.adsw.lab2.order.Order;
import main.java.com.app.adsw.lab2.queue.Queue;
import main.java.com.app.adsw.lab3.product.Product;
import main.java.com.app.adsw.lab3.productlist.ProductList;
import main.java.com.app.adsw.lab4.standings.Standings;
import main.java.com.app.adsw.lab4.team.Team;

public class Menu {

  private Scanner scanner;

  public Menu() {
    scanner = new Scanner(System.in);
  }

  public void showMainMenu() throws Exception {
    int option;
    do {
      System.out.println();
      System.out.println("Select the corresponding course option:");
      System.out.println("1. Algorithms and Data Structures I");
      System.out.println("2. Algorithms and Data Structures Workshop");
      System.out.println("3. Algorithms and Data Structures II");
      System.out.println("0. Exit");
      System.out.println();
      System.out.print("Option: ");

      while (!scanner.hasNextInt()) {
        System.out.println("Invalid option, please try again.");
        scanner.next();
      }
      option = scanner.nextInt();

      switch (option) {
        case 1:
          showADS1Menu();
          break;
        case 2:
          showADSW1Menu();
          break;
        case 3:
          showADS2Menu();
          break;
        case 0:
          System.out.println("Goodbye!");
          break;
        default:
          System.out.println("Invalid option, please try again.");
      }
    } while (option != 0);
  }

  public void showADS1Menu() throws Exception {
    int option;
    do {
      System.out.println();
      System.out.println("Select an option:");
      System.out.println("1. LAB1: Search Algorithms - Big O Notation");
      System.out.println("2. LAB2: Data Structures - Stacks - Linked Lists");
      System.out.println("3. LAB3: Hash Tables");
      System.out.println("4. LAB4: QuickSort - MergeSort");
      System.out.println("0. Back");
      System.out.println();
      System.out.print("Option: ");

      while (!scanner.hasNextInt()) {
        System.out.println("Invalid option, please try again.");
        scanner.next();
      }
      option = scanner.nextInt();

      switch (option) {
        case 1:
          demonstrateSearchAlgorithms();
          break;
        case 2:
          demonstrateStack();
          break;
        case 3:
          demonstrateHashTable();
          break;
        case 4:
          demonstrateSortingAlgorithms();
          break;
        case 0:
          System.out.println("Returning to main menu...");
          break;
        default:
          System.out.println("Invalid option, please try again.");
      }
    } while (option != 0);
  }

  public void showADSW1Menu() throws Exception {
    int option;
    Scanner keyboard = new Scanner(System.in);
    do {
      System.out.println();
      System.out.println("Select an option:");
      System.out.println("1. LAB1: Object Handling, Arrays and Exceptions");
      System.out.println("2. LAB2: Stacks and Queues");
      System.out.println("3. LAB3: Linked Lists");
      System.out.println("4. LAB4: QuickSort");
      System.out.println("0. Back");
      System.out.println();
      System.out.print("Option: ");

      while (!scanner.hasNextInt()) {
        System.out.println("Invalid option, please try again.");
        scanner.next();
      }
      option = scanner.nextInt();

      switch (option) {
        case 1:
          demonstrateObjectsAndArrays(keyboard);
          break;
        case 2:
          demonstrateStacksAndQueues(keyboard);
          break;
        case 3:
          demonstrateLinkedLists();
          break;
        case 4:
          demonstrateQuickSortWithTeams();
          break;
        case 0:
          System.out.println("Returning to main menu...");
          break;
        default:
          System.out.println("Invalid option, please try again.");
      }
    } while (option != 0);
  }

  public void showADS2Menu() {
    int option;
    do {
      System.out.println();
      System.out.println("Select an option:");
      System.out.println("1. LAB2: Binary Trees");
      System.out.println("2. LAB3: Binary Search Trees (BST)");
      System.out.println("3. LAB4: Huffman Tree");
      System.out.println("0. Back");
      System.out.println();
      System.out.print("Option: ");

      while (!scanner.hasNextInt()) {
        System.out.println("Invalid option, please try again.");
        scanner.next();
      }
      option = scanner.nextInt();

      switch (option) {
        case 1:
          demonstrateBinaryTree();
          break;
        case 2:
          demonstrateBinarySearchTree();
          break;
        case 3:
          demonstrateHuffmanTree();
          break;
        case 0:
          System.out.println("Returning to main menu...");
          break;
        default:
          System.out.println("Invalid option, please try again.");
      }
    } while (option != 0);
  }

  // Helper demonstration methods
  private void demonstrateSearchAlgorithms() {
    try {
      Building building = new Building();
      System.out.println("Number of active offices: " + building.countActiveOffices());

      Office firstOffice = building.findFirstActiveOffice();
      if (firstOffice != null) {
        System.out.println("First office: " + firstOffice.toString());
      } else {
        System.out.println("No active offices found");
      }
    } catch (Exception e) {
      System.out.println("Error: " + e.getMessage());
    }
    pressEnterToContinue();
  }

  private void demonstrateStack() {
    Stack stack = new Stack();
    stack.push(10);
    stack.push(40);
    stack.push(3);
    stack.display();
    System.out.println("Popping top of stack: " + stack.pop());
    stack.display();
    pressEnterToContinue();
  }

  private void demonstrateHashTable() {
    int i, element;

    int tableSize = 15;
    HashTable[] hashTable = new HashTable[tableSize];
    for (i = 0; i < tableSize; i++) {
      hashTable[i] = new HashTable();
      hashTable[i].state = 0;
    }

    HashTable.insert(hashTable, tableSize, 15);
    HashTable.insert(hashTable, tableSize, 130);
    HashTable.insert(hashTable, tableSize, 7);
    HashTable.insert(hashTable, tableSize, 32);

    element = 7;
    i = HashTable.search(hashTable, tableSize, element);
    i = HashTable.delete(hashTable, tableSize, 130);
    pressEnterToContinue();
  }

  private void demonstrateSortingAlgorithms() {
    int[] arr = {12, 11, 13, 5, 6, 7};
    System.out.println("\nOriginal array before MergeSort");
    displayArray(arr);
    MergeSort mergeSort = new MergeSort();
    mergeSort.sort(arr, 0, arr.length - 1);
    System.out.println("\nArray sorted by Merge Sort");
    displayArray(arr);

    int[] arr2 = {12, 11, 13, 5, 6, 7};
    System.out.println("\nOriginal array before QuickSort");
    displayArray(arr2);
    QuickSort quickSort = new QuickSort();
    quickSort.sort(arr2, 0, arr2.length - 1);
    System.out.println("\nArray sorted by Quick Sort");
    displayArray(arr2);
    pressEnterToContinue();
  }

  private void demonstrateObjectsAndArrays(Scanner keyboard) {
    String[] words = new String[50];
    int wordCount = 0;

    System.out.print("Enter a word (letters only, please): ");
    String word = keyboard.nextLine();
    word = word.toUpperCase();
    words[wordCount] = word;
    wordCount++;

    int subMenuOption;
    do {
      System.out.println();
      System.out.println("Select an option:");
      System.out.println("1. Enter more words");
      System.out.println("2. List entered words");
      System.out.println("3. Character count of a word");
      System.out.println("4. Word occurrence count");
      System.out.println("0. Exit");
      System.out.println();
      System.out.print("Option: ");

      while (!keyboard.hasNextInt()) {
        System.out.println("Invalid option, please try again.");
        System.out.print("Option: ");
        keyboard.next();
      }
      subMenuOption = keyboard.nextInt();

      switch (subMenuOption) {
        case 1:
          System.out.print("Enter a word (letters only, please): ");
          keyboard.nextLine();
          word = keyboard.nextLine();
          word = word.toUpperCase();
          words[wordCount] = word;
          wordCount++;
          break;
        case 2:
          System.out.print("\nEntered words: \n");
          for (int i = 0; i < words.length; i++) {
            if (words[i] == null) break;
            System.out.println((i + 1) + ". " + words[i]);
          }
          pressEnterToContinue();
          keyboard.nextLine();
          break;
        case 3:
          String wordOption;
          System.out.print("\nEntered words: \n");
          for (int i = 0; i < words.length; i++) {
            if (words[i] == null) break;
            System.out.println((i + 1) + ". " + words[i]);
          }
          System.out.println("Enter the word number for character count: ");
          System.out.print("Option: ");
          wordOption = keyboard.next();

          while (!(isNumeric(wordOption)
              && Integer.parseInt(wordOption) >= 1
              && Integer.parseInt(wordOption) <= wordCount)) {
            System.out.println("Invalid option, please try again.");
            System.out.print("Option: ");
            wordOption = keyboard.next();
          }

          word = words[Integer.parseInt(wordOption) - 1];
          System.out.println("Selected word: " + word);
          Counter.frequencyCount(word);
          pressEnterToContinue();
          break;
        case 4:
          System.out.print("\nEntered words: \n");
          for (int i = 0; i < words.length; i++) {
            if (words[i] == null) break;
            System.out.println((i + 1) + ". " + words[i]);
          }
          System.out.println("Enter the word number for occurrence count:");
          System.out.print("Option: ");
          wordOption = keyboard.next();

          while (!(isNumeric(wordOption)
              && Integer.parseInt(wordOption) >= 1
              && Integer.parseInt(wordOption) <= wordCount)) {
            System.out.println("Invalid option, please try again.");
            System.out.print("Option: ");
            wordOption = keyboard.next();
          }

          word = words[Integer.parseInt(wordOption) - 1];
          System.out.println(
              "The selected word '"
                  + word
                  + "' appears "
                  + Counter.occurrenceCount(words, word)
                  + " times.");
          pressEnterToContinue();
          break;
        case 0:
          System.out.println("Goodbye!");
          break;
        default:
          System.out.println("Invalid option, please try again.");
      }
    } while (subMenuOption != 0);
  }

  private void demonstrateStacksAndQueues(Scanner keyboard) {
    int subMenuOption;
    do {
      System.out.println();
      System.out.println("Select an option:");
      System.out.println("1. Stack Menu");
      System.out.println("2. Queue Demonstration");
      System.out.println("0. Exit");
      System.out.println();
      System.out.print("Option: ");

      while (!keyboard.hasNextInt()) {
        System.out.println("Invalid option, please try again.");
        System.out.print("Option: ");
        keyboard.next();
      }
      subMenuOption = keyboard.nextInt();

      switch (subMenuOption) {
        case 1:
          demonstrateStackMenu(keyboard);
          break;
        case 2:
          demonstrateQueueOperations();
          break;
        case 0:
          System.out.println("Goodbye!");
          break;
        default:
          System.out.println("Invalid option, please try again.");
      }
    } while (subMenuOption != 0);
  }

  private void demonstrateStackMenu(Scanner keyboard) {
    int maxSize = 10;
    ArrayStack stack = new ArrayStack(maxSize);

    int stackMenuOption;
    do {
      System.out.println("\nStack Menu:");
      System.out.println("1. Push element");
      System.out.println("2. Pop element");
      System.out.println("3. Check if stack is empty");
      System.out.println("4. Display stack contents");
      System.out.println("5. Exit");
      System.out.print("Select an option: ");
      stackMenuOption = keyboard.nextInt();

      switch (stackMenuOption) {
        case 1:
          System.out.print("Enter element to push: ");
          int element = keyboard.nextInt();
          stack.push(element);
          System.out.println("Element " + element + " pushed.");
          break;
        case 2:
          if (!stack.isEmpty()) {
            int poppedElement = stack.pop();
            System.out.println("Element " + poppedElement + " popped from stack.");
          } else {
            System.out.println("Stack is empty. Cannot pop elements.");
          }
          break;
        case 3:
          if (stack.isEmpty()) {
            System.out.println("Stack is empty.");
          } else {
            System.out.println("Stack is not empty.");
          }
          break;
        case 4:
          stack.display();
          break;
        case 5:
          System.out.println("Exiting program.");
          break;
        default:
          System.out.println("Invalid option. Please choose a valid option.");
          break;
      }
    } while (stackMenuOption != 5);
  }

  private void demonstrateQueueOperations() {
    Queue queue = new Queue();

    if (queue.isEmpty()) {
      System.out.println("Queue is empty");
    }

    Order order1 = new Order(101, "Rodrigo Hernandez", 500);
    Order order2 = new Order(102, "Hernán Calto", 125);
    Order order3 = new Order(103, "Matías Carabella", 2500);
    Order order4 = new Order(104, "Sofia Martinez", 400);
    Order order5 = new Order(105, "Ayelén Vittora", 1000);
    Order order6 = new Order(106, "Camila Leguizamon", 750);

    queue.enqueue(order1);
    queue.enqueue(order2);
    queue.enqueue(order3);
    queue.enqueue(order4);
    queue.enqueue(order5);
    queue.enqueue(order6);

    System.out.println("Queue contents:");
    queue.displayQueue();

    if (!queue.isEmpty()) {
      Order frontOrder = queue.front();
      System.out.println(
          "Front of queue: Code: "
              + frontOrder.getCode()
              + ", Customer: "
              + frontOrder.getCustomerName()
              + ", Brick Quantity: "
              + frontOrder.getBrickQuantity());
    }

    Order dequeuedOrder1 = queue.dequeue();
    Order dequeuedOrder2 = queue.dequeue();

    System.out.println("\nQueue contents after dequeuing:");
    queue.displayQueue();

    System.out.println("\nDequeued orders:");
    System.out.println(
        "Order 1: Code: "
            + dequeuedOrder1.getCode()
            + ", Customer: "
            + dequeuedOrder1.getCustomerName()
            + ", Brick Quantity: "
            + dequeuedOrder1.getBrickQuantity());
    System.out.println(
        "Order 2: Code: "
            + dequeuedOrder2.getCode()
            + ", Customer: "
            + dequeuedOrder2.getCustomerName()
            + ", Brick Quantity: "
            + dequeuedOrder2.getBrickQuantity());
    pressEnterToContinue();
  }

  private void demonstrateLinkedLists() {
    ProductList list = new ProductList();

    list.insertProduct(new Product(1001, "Laptop Lenovo", 899.99));
    list.insertProduct(new Product(2522, "Smartphone Samsung", 599.99));
    list.insertProduct(new Product(311, "Monitor Dell", 249.99));
    list.insertProduct(new Product(4003, "Impresora HP", 129.99));
    list.insertProduct(new Product(105, "Teclado Logitech", 49.99));
    list.insertProduct(new Product(1001, "Laptop ASUS", 799.99));

    System.out.println();
    System.out.println("Product list:");
    list.listProducts();

    pressEnterToContinue();
  }

  private void demonstrateQuickSortWithTeams() {
    Standings table = new Standings();

    table.addTeam(new Team("Liverpool", 66));
    table.addTeam(new Team("Arsenal", 50));
    table.addTeam(new Team("Manchester United", 58));
    table.addTeam(new Team("Manchester City", 68));
    table.addTeam(new Team("Tottenham Hotspur", 48));
    table.addTeam(new Team("Leicester City", 43));
    table.addTeam(new Team("Chelsea", 60));
    table.addTeam(new Team("West Ham United", 45));

    System.out.println("\nSTANDINGS TABLE");
    System.out.println("-------------------");
    table.displayTable();

    pressEnterToContinue();
  }

  private void demonstrateBinaryTree() {
    BinaryTree tree = new BinaryTree();
    BinaryNode auxNode = null, auxNode2 = null, auxNode3 = null, auxNode4 = null;

    System.out.println("\nAdding root 30");
    auxNode2 = tree.insertLeftChild(auxNode, 30);
    auxNode = auxNode2;

    auxNode2 = tree.insertLeftChild(auxNode, 25);
    auxNode3 = tree.insertRightChild(auxNode, 45);
    auxNode = auxNode2;

    auxNode2 = tree.insertLeftChild(auxNode, 20);
    auxNode4 = tree.insertRightChild(auxNode, 27);

    System.out.println("Binary tree in Inorder:");
    tree.inorder(tree.root);
    Integer height = tree.height(tree.root);
    System.out.println("\n\nTree height: " + height.toString());
    pressEnterToContinue();
  }

  private void demonstrateBinarySearchTree() {
    BST bst = new BST();

    bst.insert(45);
    bst.insert(10);
    bst.insert(7);
    bst.insert(12);
    bst.insert(90);
    bst.insert(50);

    System.out.println("BST has been created (left-root-right):");
    bst.inorder();

    System.out.println("\nBST after deleting 12 (leaf node):");
    bst.deleteKey(12);
    bst.inorder();

    System.out.println("\nBST after deleting 90 (node with 1 child):");
    bst.deleteKey(90);
    bst.inorder();

    System.out.println("\nBST after deleting 45 (node with 2 children):");
    bst.deleteKey(45);
    bst.inorder();

    boolean found = bst.search(50);
    System.out.println("\n\nKey 50 in BST: " + found);
    found = bst.search(12);
    System.out.println("Key 12 in BST: " + found);
    pressEnterToContinue();
  }

  private void demonstrateHuffmanTree() {
    System.out.println("\n=== Huffman Tree Compression Demo ===");
    System.out.println(
        "Huffman coding assigns shorter codes to frequent characters for efficient compression.\n");

    // Sample texts to demonstrate compression
    String[] sampleTexts = {
      "HELLO WORLD",
      "MISSISSIPPI RIVER",
      "The quick brown fox jumps over the lazy dog",
      "AAAAAABBBBCCCDDE"
    };

    HuffmanTree huffmanTree = new HuffmanTree();

    for (int i = 0; i < sampleTexts.length; i++) {
      System.out.println("\n--- Example " + (i + 1) + " ---");
      huffmanTree.compressText(sampleTexts[i]);
      System.out.println();
    }

    System.out.println("\n=== Demo Complete ===");
    System.out.println(
        "Notice how texts with repeated characters achieve better compression ratios!");
    pressEnterToContinue();
  }

  // Helper methods
  private static void displayArray(int[] arr) {
    for (int value : arr) {
      System.out.print(value + " ");
    }
    System.out.println();
  }

  private static void pressEnterToContinue() {
    System.out.println("\nPress ENTER to continue...");
    try {
      System.in.read();
    } catch (Exception e) {
      System.out.println("Error");
    }
  }

  public static boolean isNumeric(String str) {
    try {
      Double.parseDouble(str);
      return true;
    } catch (NumberFormatException e) {
      return false;
    }
  }
}
