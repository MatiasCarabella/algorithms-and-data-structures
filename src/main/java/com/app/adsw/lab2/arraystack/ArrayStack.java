package main.java.com.app.adsw.lab2.arraystack;

import java.util.EmptyStackException;

/** Array-based stack implementation. Fixed size stack using an array. */
public class ArrayStack {
  private int maxSize;
  private int top;
  private int[] stack;

  public ArrayStack(int size) {
    maxSize = size;
    stack = new int[maxSize];
    top = -1;
  }

  public boolean isEmpty() {
    return (top == -1);
  }

  private boolean isFull() {
    return (top == maxSize - 1);
  }

  public void push(int value) {
    if (isFull()) {
      System.out.println("Stack is full. Cannot add more elements.");
    } else {
      stack[++top] = value;
    }
  }

  public int pop() {
    if (isEmpty()) {
      throw new EmptyStackException();
    } else {
      return stack[top--];
    }
  }

  public void display() {
    if (isEmpty()) {
      System.out.println("Stack is empty.");
    } else {
      System.out.print("Stack contents: ");
      for (int i = 0; i <= top; i++) {
        System.out.print(stack[i] + " ");
      }
      System.out.println();
    }
  }
}
