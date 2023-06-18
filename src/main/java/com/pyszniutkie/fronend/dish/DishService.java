package com.pyszniutkie.fronend.dish;

import com.pyszniutkie.backend.dish.Dish;
import com.pyszniutkie.backend.dish.DishCategory;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class DishService {

    private DishClient dishClient;

    public DishService(DishClient dishClient) {
        this.dishClient = dishClient;
    }

    public List<MenuSection> getAllDishes() {
        List<Dish> breakfast = dishClient.downloadByCategory(DishCategory.BREAK_FAST);
        List<Dish> diner = dishClient.downloadByCategory(DishCategory.DINER);
        List<Dish> supper = dishClient.downloadByCategory(DishCategory.SUPPER);
        List<Dish> additives = dishClient.downloadByCategory(DishCategory.ADDITIVES);
        MenuSection breakFastSection = new MenuSection(breakfast, DishCategory.BREAK_FAST);
        MenuSection dinnerSection = new MenuSection(diner, DishCategory.DINER);
        MenuSection supperSection = new MenuSection(supper, DishCategory.SUPPER);
        MenuSection additivesSection = new MenuSection(additives, DishCategory.ADDITIVES);
        return List.of(breakFastSection,dinnerSection,supperSection,additivesSection);
    }

    public void addDish(Dish dish) {
        dishClient.addDish(dish);
    }
}
