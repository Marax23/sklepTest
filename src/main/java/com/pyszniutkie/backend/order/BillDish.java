package com.pyszniutkie.backend.order;

//wygodna klasa z
public class BillDish {

    private String name;
    private double price;
    private int amount;


    public BillDish(String name, double price, int amount) {
        this.name = name;
        this.price = price;
        this.amount = amount;
    }

    public BillDish() {
    }

    public double getTotalPrice() {
        return price * amount;
    }

    public String getName() {
        return name;
    }

    public double getPrice() {
        return price;
    }

    public int getAmount() {
        return amount;
    }

    @Override
    public String toString() {
        return "BillDish{" +
                "name='" + name + '\'' +
                ", price=" + price +
                ", amount=" + amount +
                '}';
    }
}
