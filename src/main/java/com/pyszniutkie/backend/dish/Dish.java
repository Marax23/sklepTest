package com.pyszniutkie.backend.dish;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;

@Entity
public class Dish {

    @Id
    @GeneratedValue
    private int id;
    @NotBlank(message = "Wymagana nazwa potrawy!") // do validacji - wymaga dependency w pom
    private String name;
    @Positive(message = "Wprowadź poprawną cenę!")
    private double price;
    @Enumerated(value = EnumType.STRING) // sprawia że w bazie enum zapisze się jako tekst a nie numer
    @NotNull(message = "Trzeba wybrać kategorie!")
    private DishCategory category;

    public Dish() {
    }

    public Dish(String name, double price, DishCategory category) {
        this.name = name;
        this.price = price;
        this.category = category;
    }

    @Override
    public String toString() {
        return "Dish{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", cena=" + price +
                ", category='" + category + '\'' +
                '}';
    }

    public String getName() {
        return name;
    }

    public double getPrice() {
        return price;
    }

    public DishCategory getCategory() {
        return category;
    }

    public int getId() {
        return id;
    }


    public void setName(String name) {
        this.name = name;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public void setCategory(DishCategory category) {
        this.category = category;
    }
}
