# Data Structures and Algorithms - Java Implementation

![Java](https://img.shields.io/badge/Java-25-orange?style=flat&logo=openjdk&logoColor=white)
![Gradle](https://img.shields.io/badge/Gradle-9.2.1-02303A?style=flat&logo=gradle&logoColor=white)
![Spotless](https://img.shields.io/badge/Spotless-8.1.0-blue?style=flat)
![License](https://img.shields.io/badge/License-MIT-green?style=flat)

A comprehensive collection of data structures and algorithms implementations in Java, organized by course modules. This project serves as a practical reference for computer science students and developers learning fundamental algorithms and data structures.

## 📋 Project Overview

This repository contains implementations for three main course modules:

### 1. Algorithms and Data Structures I
- **lab1**: Search Algorithms & Big O Notation
- **lab2**: Data Structures - Stacks & Linked Lists
- **lab3**: Hash Tables
- **lab4**: QuickSort & MergeSort

### 2. Algorithms and Data Structures Workshop
- **lab1**: Object Handling, Arrays & Exception Management
- **lab2**: Stacks & Queues
- **lab3**: Linked Lists
- **lab4**: QuickSort Implementation

### 3. Algorithms and Data Structures II
- **lab2**: Binary Trees
- **lab3**: Binary Search Trees (BST)
- **lab4**: Huffman Tree Compression (in-memory text compression)

## 🚀 Getting Started

### Prerequisites
- Java Development Kit (JDK) 25 (Gradle will automatically download it if needed)

### Running the Project

1. Clone the repository:
```bash
git clone https://github.com/MatiasCarabella/algorithms-and-data-structures
cd algorithms-and-data-structures
```

2. Run the application
```bash
./gradlew run
```


## 📁 Project Structure

```
src/
└── main/
    └── java/
        ├── App.java                    # Main entry point
        └── com/
            └── app/
                ├── menu/               # Interactive menu system
                ├── ads1/               # Algorithms & Data Structures I
                │   ├── lab1/           # Search algorithms (Building, Office)
                │   ├── lab2/           # Stacks & linked lists (Stack, Node)
                │   ├── lab3/           # Hash tables (HashTable)
                │   └── lab4/           # Sorting algorithms (QuickSort, MergeSort)
                ├── ads2/               # Algorithms & Data Structures II
                │   ├── lab2/           # Binary trees (BinaryTree, BinaryNode)
                │   ├── lab3/           # Binary search trees (BST)
                │   └── lab4/           # Huffman trees (HuffmanTree)
                └── adsw/               # Algorithms & Data Structures Workshop
                    ├── lab1/           # Objects & arrays (Counter)
                    ├── lab2/           # Stacks & queues (ArrayStack, Queue, Order)
                    ├── lab3/           # Linked lists (ProductList, Product)
                    └── lab4/           # QuickSort with teams (Team, Standings)
```

## 🎯 Features

### Data Structures Implemented
- **Stacks** (Array-based and Linked List-based)
- **Queues**
- **Linked Lists**
- **Hash Tables**
- **Binary Trees**
- **Binary Search Trees (BST)**
- **Huffman Trees**

### Algorithms Implemented
- **Sorting Algorithms**: QuickSort, MergeSort
- **Search Algorithms**: Linear Search, Binary Search
- **Tree Traversals**: Inorder, Preorder, Postorder
- **Compression**: Huffman Encoding

## 📝 License

This project is licensed under the MIT [License](LICENSE).
