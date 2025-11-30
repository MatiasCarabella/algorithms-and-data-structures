package main.java.com.app.adsw.lab3.productlist;

import main.java.com.app.adsw.lab3.product.Product;
import main.java.com.app.adsw.lab3.productnode.ProductNode;

/** Doubly linked list for managing products sorted by code. */
public class ProductList {
  ProductNode start;

  public ProductList() {
    this.start = null;
  }

  public void insertProduct(Product newProduct) {
    ProductNode newNode = new ProductNode(newProduct);
    System.out.print("Inserting... ");
    newProduct.display();

    if (start == null) {
      start = newNode;
    } else {
      ProductNode current = start;

      while (current != null) {
        if (current.product.code == newProduct.code) {
          System.out.println(
              "ERROR: Code "
                  + newProduct.code
                  + " already exists. Product '"
                  + newProduct.description
                  + "' was not inserted.");
          return;
        }

        if (current.product.code > newProduct.code) {
          if (current.previous == null) {
            newNode.next = current;
            current.previous = newNode;
            start = newNode;
          } else {
            newNode.next = current;
            newNode.previous = current.previous;
            current.previous.next = newNode;
            current.previous = newNode;
          }
          return;
        }

        if (current.next == null) {
          current.next = newNode;
          newNode.previous = current;
          return;
        }

        current = current.next;
      }
    }
  }

  public void listProducts() {
    ProductNode current = start;
    while (current != null) {
      current.product.display();
      current = current.next;
    }
  }
}
