package com.example.ext0132016.navigationdrawervideotutorial;

/**
 * Created by EXT0132016 on 5/28/2016.
 */
public class Product {
    private String name;
    private int qty;
    private double price;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getQty() {
        return qty;
    }

    public void setQty(int qty) {
        this.qty = qty;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public Product(String name, int qty, double price) {

        this.name = name;
        this.qty = qty;
        this.price = price;
    }

    public Product() {

    }
}
