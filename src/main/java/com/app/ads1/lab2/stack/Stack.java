package main.java.com.app.ads1.lab2.stack;

import main.java.com.app.ads1.lab2.node.Node;

public class Stack {
  private Node top;

  public Stack() {
    this.top = null;
  }

  public void push(int value) {
    Node newNode = new Node(value);
    newNode.next = top;
    this.top = newNode;
  }

  public int pop() {
    int info = top.info;
    this.top = top.next;
    return info;
  }

  public void display() {
    Node node = this.top;
    while (node != null) {
      System.out.print(node.info);
      if (node.next != null) System.out.print(" -> ");
      node = node.next;
    }
    System.out.println();
  }
}
