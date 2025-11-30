package main.java.com.app.adsw.lab3.product;

/**
 * Represents a product with code, description, and price.
 */
public class Product {
    public int code;
    public String description;
    public double price;

    public Product(int code, String description, double price) {
        this.code = code;
        this.description = description;
        this.price = price;
    }

    public void display() {
        System.out.println("Code: " + code + ", Description: " + description + ", Price: " + price);
    }
}
