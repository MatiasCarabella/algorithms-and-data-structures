package main.java.com.app.ads2.lab3.bst;

public class BST {
    class Node {
        int key;
        Node left, right;
        public Node(int data) {
            key = data;
            left = right = null;
        }
    }

    Node root;

    public BST() {
        root = null;
    }

    public void deleteKey(int key) {
        root = deleteRecursive(root, key);
    }

    Node deleteRecursive(Node root, int key) {
        if (root == null) return root;
        if (key < root.key) {
            root.left = deleteRecursive(root.left, key);
        } else if (key > root.key) {
            root.right = deleteRecursive(root.right, key);
        } else {
            if (root.left == null) return root.right;
            else if (root.right == null) return root.left;
            root.key = findMinValue(root.right);
            root.right = deleteRecursive(root.right, root.key);
        }
        return root;
    }
    
    int findMinValue(Node root) {
        int minValue = root.key;
        while (root.left != null) {
            minValue = root.left.key;
            root = root.left;
        }
        return minValue;
    }
    
    public void insert(int key) {
        root = insertRecursive(root, key);
    }
    
    Node insertRecursive(Node root, int key) {
        if (root == null) {
            root = new Node(key);
            return root;
        }
        if (key < root.key) {
            root.left = insertRecursive(root.left, key);
        } else if (key > root.key) {
            root.right = insertRecursive(root.right, key);
        }
        return root;
    }
    
    public void inorder() {
        inorderRecursive(root);
    }
    
    void inorderRecursive(Node root) {
        if (root != null) {
            inorderRecursive(root.left);
            System.out.print(root.key + " ");
            inorderRecursive(root.right);
        }
    }
    
    public boolean search(int key) {
        root = searchRecursive(root, key);
        return root != null;
    }
    
    Node searchRecursive(Node root, int key) {
        if (root == null || root.key == key) return root;
        if (root.key > key) return searchRecursive(root.left, key);
        return searchRecursive(root.right, key);
    }
}
