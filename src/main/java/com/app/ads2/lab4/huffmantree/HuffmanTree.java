package main.java.com.app.ads2.lab4.huffmantree;

import java.io.*;

/**
 * Huffman Tree implementation for file compression.
 *
 * <p>Huffman coding is a lossless data compression algorithm that assigns variable-length codes to
 * characters based on their frequency of occurrence. More frequent characters get shorter codes.
 *
 * <p>Time Complexity: O(n log n) where n is the number of unique characters Space Complexity: O(n)
 */
public class HuffmanTree {

  /** Tree node class for Huffman tree. */
  class TreeNode {
    char key;
    int frequency;
    boolean isData;
    TreeNode left, right;

    public TreeNode(char character, int freq, boolean isDataNode) {
      key = character;
      frequency = freq;
      isData = isDataNode;
      left = right = null;
    }
  }

  /** List node class for maintaining a list of trees. */
  class ListNode {
    public TreeNode root;
    public ListNode next;

    public ListNode(TreeNode node) {
      root = node;
      next = null;
    }
  }

  // Initial node of the list
  ListNode initialNode;

  // Huffman table for ASCII characters (frequency table)
  int[] huffmanTable;

  // Huffman table for codes
  String[] huffmanCodes;

  int tableSize = 0;

  /** Converts a byte to an unsigned byte value. */
  int byteToUnsignedByte(byte data) {
    int result = (int) data;
    if (data < 0) {
      result = (int) data + 256;
    }
    return result;
  }

  /** Loads the frequency table from a string. Counts the occurrence of each character. */
  void loadTableFromString(String text) {
    initialNode = null;
    huffmanTable = new int[256];
    huffmanCodes = new String[256];

    for (int i = 0; i <= 255; i++) {
      huffmanTable[i] = 0;
      huffmanCodes[i] = "";
    }

    System.out.println("Text length: " + text.length() + " characters");

    // Count character frequencies
    for (int i = 0; i < text.length(); i++) {
      char c = text.charAt(i);
      int charCode = (int) c;
      if (charCode >= 0 && charCode < 256) {
        huffmanTable[charCode]++;
      }
    }

    // Count unique characters
    for (int i = 0; i <= 255; i++) {
      if (huffmanTable[i] > 0) {
        tableSize++;
      }
    }
    System.out.println("Unique characters: " + tableSize);
  }

  /** Loads the frequency table from a file. Counts the occurrence of each character in the file. */
  void loadTableFromFile(String filename) {
    initialNode = null;
    huffmanTable = new int[256];
    huffmanCodes = new String[256];

    for (int i = 0; i <= 255; i++) {
      huffmanTable[i] = 0;
      huffmanCodes[i] = "";
    }

    System.out.println("File: " + filename);
    try {
      RandomAccessFile file = new RandomAccessFile(filename, "r");
      byte data;
      int integer;
      long count = 0;
      long size = file.length();
      System.out.print("Size: ");
      System.out.println(size);

      while (count < size) {
        file.seek(count);
        data = file.readByte();
        integer = byteToUnsignedByte(data);
        huffmanTable[integer]++;
        count++;
      }
      file.close();

    } catch (IOException e) {
      e.printStackTrace();
    }

    for (int i = 0; i <= 255; i++) {
      if (huffmanTable[i] > 0) {
        tableSize++;
      }
    }
    System.out.print("Table size: ");
    System.out.println(tableSize);
  }

  /**
   * Inserts a node into the sorted list of trees. List is sorted by frequency in ascending order.
   */
  void insertNodeInList(ListNode nodeToInsert) {
    ListNode currentPos, previousPos, auxNode;

    if (initialNode == null) {
      initialNode = nodeToInsert;
    } else {
      currentPos = initialNode;
      previousPos = null;

      while ((nodeToInsert.root.frequency >= currentPos.root.frequency)
          && (currentPos.next != null)) {
        previousPos = currentPos;
        currentPos = currentPos.next;
      }

      if (previousPos == null) {
        if (nodeToInsert.root.frequency >= currentPos.root.frequency) {
          currentPos.next = nodeToInsert;
        } else {
          nodeToInsert.next = initialNode;
          initialNode = nodeToInsert;
        }
      } else {
        if (nodeToInsert.root.frequency >= currentPos.root.frequency) {
          auxNode = currentPos.next;
          currentPos.next = nodeToInsert;
          nodeToInsert.next = auxNode;
        } else {
          previousPos.next = nodeToInsert;
          nodeToInsert.next = currentPos;
        }
      }
    }
  }

  /** Displays the list of trees for debugging. */
  void displayTreeList() {
    ListNode auxNode = initialNode;
    int count = 0;
    System.out.print("Tree list: ");

    while (auxNode != null) {
      count++;
      System.out.print(count);
      System.out.print("'" + auxNode.root.key + "'");
      System.out.print("(");
      System.out.print(auxNode.root.frequency);
      System.out.print("), ");
      auxNode = auxNode.next;
    }
    System.out.println(" ");
  }

  /**
   * Creates a sorted list of trees from the frequency table. Each character becomes a leaf node in
   * its own tree.
   */
  void createTreeList() {
    int position = 0;
    char character;

    System.out.println("Table:");
    for (int i = 0; i <= 255; i++) {
      if (huffmanTable[i] > 0) {
        position++;
        character = (char) i;

        // Create a root tree node containing DATA (flag set to true)
        TreeNode treeNode = new TreeNode((char) i, huffmanTable[i], true);
        ListNode listNode = new ListNode(treeNode);

        // Table contents
        System.out.print("Node ");
        System.out.print(position);
        System.out.print(" " + (char) i + "(");
        System.out.print(huffmanTable[i]);
        System.out.print("); ");

        insertNodeInList(listNode);
      }
    }
    System.out.println(" ");
    displayTreeList();
  }

  /**
   * Processes the list of trees to build the final Huffman tree. Repeatedly combines the two trees
   * with lowest frequencies until only one tree remains.
   */
  void processTreeList() {
    if (initialNode != null) {
      ListNode currentNode, node1, node2;
      TreeNode treeRoot1, treeRoot2;
      currentNode = initialNode;

      if (currentNode != null) {
        // While the list has more than one node, process
        while (currentNode.next != null) {
          // Get the first two nodes
          node1 = currentNode;
          node2 = currentNode.next;

          // Assign the trees from each node
          treeRoot1 = node1.root;
          treeRoot2 = node2.root;

          // Remove both nodes from the list
          initialNode = node2.next;

          // Create a new root node with the two subtrees
          // This node does NOT contain DATA (flag set to false)
          // Frequency is the sum of both subtrees
          TreeNode newTreeNode =
              new TreeNode('*', node1.root.frequency + node2.root.frequency, false);
          newTreeNode.left = node1.root;
          newTreeNode.right = node2.root;

          // Create a new list node to insert in place of the two removed
          ListNode newListNode = new ListNode(newTreeNode);

          // Insert new node into the list in sorted order
          insertNodeInList(newListNode);
          currentNode = initialNode;
        }
      }
    }
  }

  /**
   * Recursively generates Huffman codes for each character. Traverses the tree: left = 0, right = 1
   *
   * @param rootNode the current node being processed
   * @param code the code string built so far
   */
  void generateHuffmanCodesRecursive(TreeNode rootNode, String code) {
    // Check if the current node is a leaf (contains a character)
    if (rootNode.isData) {
      // Print the character and its Huffman code
      System.out.println("Character: " + rootNode.key + " Huffman Code: " + code);
      // Store the Huffman code in the codes table
      huffmanCodes[(int) rootNode.key] = code;
    } else {
      // If not a leaf, continue traversing the tree recursively
      // Concatenate "0" to current code and call recursively to the left
      generateHuffmanCodesRecursive(rootNode.left, code + "0");
      // Concatenate "1" to current code and call recursively to the right
      generateHuffmanCodesRecursive(rootNode.right, code + "1");
    }
  }

  /** Converts a string of 8 bits to a byte. */
  byte stringByteToByte(String strToByte) {
    byte byteResult = 0;
    int intResult = 0;

    if (strToByte.length() > 0 && Integer.parseInt(strToByte.substring(0, 1)) > 0) {
      intResult = intResult + 128;
    }
    if (strToByte.length() > 1 && Integer.parseInt(strToByte.substring(1, 2)) > 0) {
      intResult = intResult + 64;
    }
    if (strToByte.length() > 2 && Integer.parseInt(strToByte.substring(2, 3)) > 0) {
      intResult = intResult + 32;
    }
    if (strToByte.length() > 3 && Integer.parseInt(strToByte.substring(3, 4)) > 0) {
      intResult = intResult + 16;
    }
    if (strToByte.length() > 4 && Integer.parseInt(strToByte.substring(4, 5)) > 0) {
      intResult = intResult + 8;
    }
    if (strToByte.length() > 5 && Integer.parseInt(strToByte.substring(5, 6)) > 0) {
      intResult = intResult + 4;
    }
    if (strToByte.length() > 6 && Integer.parseInt(strToByte.substring(6, 7)) > 0) {
      intResult = intResult + 2;
    }
    if (strToByte.length() > 7 && Integer.parseInt(strToByte.substring(7, 8)) > 0) {
      intResult = intResult + 1;
    }
    byteResult = (byte) intResult;
    return byteResult;
  }

  /**
   * Processes the buffer and writes complete bytes to the file. Returns the remaining bits that
   * don't form a complete byte.
   */
  String processBuffer(String buffer, RandomAccessFile file) throws IOException {
    String auxStr = buffer, stringByte = "";

    while (auxStr.length() >= 8) {
      stringByte = auxStr.substring(0, 8);
      auxStr = auxStr.substring(8, auxStr.length());
      file.writeByte(stringByteToByte(stringByte));
    }
    return auxStr;
  }

  /**
   * Generates the compressed file using Huffman encoding.
   *
   * @param sourceFilename the original file to compress
   * @param destFilename the compressed output file
   */
  void generateCompressedFile(String sourceFilename, String destFilename) {
    String buffer = "";
    String bufferTemp = "";

    // Delete the file if it already exists
    File file = new File(destFilename);
    if (file.delete()) {
      System.out.println("File already existed, file deleted.");
    }

    try {
      // Open the original file as read-only
      RandomAccessFile sourceFile = new RandomAccessFile(sourceFilename, "r");
      // Open the destination file as read-write
      RandomAccessFile destFile = new RandomAccessFile(destFilename, "rw");
      int integer;
      byte data;
      long count = 0;
      long size = sourceFile.length();

      while (count < size) {
        sourceFile.seek(count);
        data = sourceFile.readByte();
        integer = byteToUnsignedByte(data);

        // Encode in string buffer
        buffer = buffer + huffmanCodes[integer];
        bufferTemp = bufferTemp + " " + huffmanCodes[integer];
        buffer = processBuffer(buffer, destFile);

        count++;
      }
      System.out.println(bufferTemp);
      sourceFile.close();
      destFile.close();
    } catch (IOException e) {
      e.printStackTrace();
    }
  }

  /**
   * Compresses text directly without requiring a file.
   *
   * @param text the text to compress
   * @return the compressed representation as a string of bits
   */
  public String compressText(String text) {
    if (text == null || text.isEmpty()) {
      System.out.println("Error: Text is empty");
      return "";
    }

    System.out.println("\n=== Huffman Compression ===");
    System.out.println("Original text: \"" + text + "\"");
    System.out.println();

    System.out.println("Step 1: Analyzing character frequencies...");
    loadTableFromString(text);

    System.out.println("\nStep 2: Building tree list...");
    createTreeList();

    System.out.println("\nStep 3: Constructing Huffman tree...");
    processTreeList();

    System.out.println("\nStep 4: Generating Huffman codes...");
    generateHuffmanCodesRecursive(initialNode.root, "");

    System.out.println("\nStep 5: Encoding text...");
    StringBuilder compressed = new StringBuilder();
    for (int i = 0; i < text.length(); i++) {
      char c = text.charAt(i);
      compressed.append(huffmanCodes[(int) c]);
    }

    String result = compressed.toString();
    int originalBits = text.length() * 8;
    int compressedBits = result.length();
    double compressionRatio = (1 - (double) compressedBits / originalBits) * 100;

    System.out.println("\n=== Compression Results ===");
    System.out.println(
        "Original size: " + originalBits + " bits (" + text.length() + " characters)");
    System.out.println("Compressed size: " + compressedBits + " bits");
    System.out.println(
        "Compression ratio: " + String.format("%.2f", compressionRatio) + "% reduction");
    System.out.println("Compressed data: " + result);

    return result;
  }

  /**
   * Main compression method. Compresses a file using Huffman encoding.
   *
   * @param filename the file to compress
   */
  public void compress(String filename) {
    System.out.println("Loading table from file...");
    loadTableFromFile(filename);

    System.out.println("Creating tree list...");
    createTreeList();

    System.out.println("Processing tree list...");
    processTreeList();

    System.out.println("Generating Huffman codes recursively...");
    generateHuffmanCodesRecursive(initialNode.root, "");

    System.out.println("Generating compressed file...");
    generateCompressedFile(filename, filename + ".compress");
  }
}
