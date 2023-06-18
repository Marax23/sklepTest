package com.pyszniutkie.backend.order;

import java.util.List;

public class Bill {
    private List<BillDish> dishes;
    private Address address = null;
    private int orderId;

    public Bill(DishOrder dishOrder) {
        orderId = dishOrder.getId();
        dishes = dishOrder.generateBillDishes();
        address = dishOrder.getAddress();
    }

    public Bill() {
    }

    public double getTotalPrice() {
        double sum = 0;
        for (BillDish dish : dishes) {
            sum += dish.getTotalPrice();
        }
        return sum;
    }

    public List<BillDish> getDishes() {
        return dishes;
    }

    public int getOrderId() {
        return orderId;
    }

    public Address getAddress() {
        return address;
    }

    @Override
    public String toString() {
        return "Bill{" +
                "dishes=" + dishes +
                ", orderId=" + orderId +
                ", address=" + address +
                ", totalPrice=" + getTotalPrice() +
                '}';
    }
}
