package main.java.com.app.adsw.lab3.productnode;

import main.java.com.app.adsw.lab3.product.Product;

/**
 * Node for doubly linked list of products.
 */
public class ProductNode {
    public Product product;
    public ProductNode previous;
    public ProductNode next;

    public ProductNode(Product product) {
        this.product = product;
        this.previous = null;
        this.next = null;
    }
}
