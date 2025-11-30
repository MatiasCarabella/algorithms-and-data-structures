package main.java.com.app.ads2.lab2.tree;

import main.java.com.app.ads2.lab2.binarynode.BinaryNode;

public class BinaryTree {
  public BinaryNode parent;
  public BinaryNode root;

  public BinaryTree() {
    this.root = null;
  }

  public BinaryNode insertLeftChild(BinaryNode node, int data) {
    BinaryNode result = null;
    if (node == null) {
      BinaryNode newNode = new BinaryNode(data);
      result = newNode;
      this.root = newNode;
    } else {
      if (node.left == null) {
        BinaryNode newNode = new BinaryNode(data);
        node.left = newNode;
        result = newNode;
      } else {
        System.out.print("ERROR - Left child of " + data + " is not null");
      }
    }
    return result;
  }

  public BinaryNode insertRightChild(BinaryNode node, int data) {
    BinaryNode result = null;
    if (node == null) {
      BinaryNode newNode = new BinaryNode(data);
      result = newNode;
      this.root = newNode;
    } else {
      if (node.right == null) {
        BinaryNode newNode = new BinaryNode(data);
        node.right = newNode;
        result = newNode;
      } else {
        System.out.print("ERROR - Right child of " + data + " is not null");
      }
    }
    return result;
  }

  public void inorder(BinaryNode node) {
    if (node != null) {
      inorder(node.left);
      System.out.print(node.data + " ");
      inorder(node.right);
    }
  }

  public int height(BinaryNode node) {
    if (node == null) {
      return -1;
    } else {
      int leftHeight = height(node.left);
      int rightHeight = height(node.right);
      return Math.max(leftHeight, rightHeight) + 1;
    }
  }
}
