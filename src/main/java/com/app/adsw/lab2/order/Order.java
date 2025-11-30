package main.java.com.app.adsw.lab2.order;

/**
 * Represents an order with code, customer name, and quantity.
 */
public class Order {
    private int code;
    private String customerName;
    private int brickQuantity;

    public Order(int code, String customerName, int brickQuantity) {
        this.code = code;
        this.customerName = customerName;
        this.brickQuantity = brickQuantity;
    }

    public int getCode() {
        return code;
    }

    public String getCustomerName() {
        return customerName;
    }

    public int getBrickQuantity() {
        return brickQuantity;
    }
}
