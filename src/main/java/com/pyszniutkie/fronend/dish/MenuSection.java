package com.pyszniutkie.fronend.dish;

import com.pyszniutkie.backend.dish.Dish;
import com.pyszniutkie.backend.dish.DishCategory;

import java.util.List;

public class MenuSection {

   /* private List<Dish> breakfast;
    private List<Dish> diner;
    private List<Dish> supper;
    private List<Dish> additives;*/

    private List<Dish> dishes;
    private DishCategory category;

    public MenuSection(List<Dish> dishes, DishCategory category) {
        this.dishes = dishes;
        this.category = category;
    }

    public List<Dish> getDishes() {
        return dishes;
    }

    public DishCategory getCategory() {
        return category;
    }

    @Override
    public String toString() {
        return "Menu{" +
                "dishes=" + dishes +
                ", category=" + category +
                '}';
    }
}
