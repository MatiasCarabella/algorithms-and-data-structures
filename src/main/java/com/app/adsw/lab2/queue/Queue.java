package main.java.com.app.adsw.lab2.queue;

import main.java.com.app.adsw.lab2.order.Order;

/**
 * Queue implementation using linked list.
 * Follows FIFO (First In, First Out) principle.
 */
public class Queue {
    private Node front;
    private Node rear;

    public Queue() {
        front = null;
        rear = null;
    }

    public boolean isEmpty() {
        return front == null;
    }

    public void enqueue(Order order) {
        Node newNode = new Node(order);
        if (isEmpty()) {
            front = newNode;
            rear = newNode;
        } else {
            rear.next = newNode;
            rear = newNode;
        }
    }

    public Order dequeue() {
        if (isEmpty()) {
            throw new IllegalStateException("Queue is empty.");
        }
        Order dequeuedOrder = front.order;
        front = front.next;
        if (front == null) {
            rear = null;
        }
        return dequeuedOrder;
    }

    public Order front() {
        if (isEmpty()) {
            throw new IllegalStateException("Queue is empty.");
        }
        return front.order;
    }

    public int size() {
        int count = 0;
        Node current = front;
        while (current != null) {
            count++;
            current = current.next;
        }
        return count;
    }

    public void displayQueue() {
        Node current = front;
        while (current != null) {
            Order order = current.order;
            System.out.println("Code: " + order.getCode() + ", Customer: " + order.getCustomerName() + ", Quantity: " + order.getBrickQuantity());
            current = current.next;
        }
    }

    private class Node {
        Order order;
        Node next;

        public Node(Order order) {
            this.order = order;
            this.next = null;
        }
    }
}
