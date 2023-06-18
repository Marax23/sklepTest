package com.pyszniutkie.backend.order;

import com.pyszniutkie.backend.dish.Dish;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Entity
public class DishOrder {
    @Id
    @GeneratedValue
    private int id;
    @ElementCollection(fetch = FetchType.EAGER)
    private Map<Dish, Integer> dishes;
    @OneToOne
    private Address address = null; //domyślnie DishOrder tworzy się jeszcze bez adresu, o niego zapytamy osobno

    public DishOrder() {
    }

    public DishOrder(Map<Dish, Integer> dishes) {
        this.dishes = dishes;
    }

    public boolean isAccepted() {
        return address != null;
    }

    public int getId() {
        return id;
    }

    public List<BillDish> generateBillDishes() {
        List<BillDish> billDishes = new ArrayList<>();
        for (Dish dish : dishes.keySet()) {
            BillDish billDish = new BillDish(dish.getName(), dish.getPrice(), dishes.get(dish));
            billDishes.add(billDish);
        }
        return billDishes;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    public Map<Dish, Integer> getDishes() {
        return dishes;
    }

    public Address getAddress() {
        return address;
    }

    @Override
    public String toString() {
        return "DishOrder{" +
                "id=" + id +
                ", dishes=" + dishes +
                ", address=" + address +
                '}';
    }
}
