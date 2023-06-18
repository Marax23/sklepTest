package com.pyszniutkie.fronend.dish;

import com.pyszniutkie.backend.dish.Dish;
import com.pyszniutkie.backend.dish.DishCategory;
import org.dom4j.rule.Mode;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@Controller
public class DishController {
    private DishService dishService;

    public DishController(DishService dishService) {
        this.dishService = dishService;
    }

    @GetMapping("/dishes")
    public String getMenuPage(Model model){
        List<MenuSection> sections = dishService.getAllDishes();
        model.addAttribute("menu", sections);
        return "dishes";
    }

    @GetMapping("/admin")
    public String getDishAddPage(Model model) {
        includeCategories(model);
        model.addAttribute("dish", new Dish());
        return "add-dish-form";
    }

    @PostMapping("/admin/add-dish")
    public String addDish(@Valid @ModelAttribute("dish") Dish dish, BindingResult errors, Model model) { // BindingResult -> obiekt zawierający informacje o tym czy nie było żadnych problemów przy wiązaniu danych do obiektu
      //  Dish dish = new Dish(name, price, category);
        if (errors.hasErrors()) {
            includeCategories(model);
            return  "add-dish-form";
        }
        dishService.addDish(dish);
        model.addAttribute("message","Danie dodane poprawnie");
        return "index";
    }

    private void includeCategories(Model model) {
        DishCategory[] categories = DishCategory.values();
        model.addAttribute("categories", categories);
    }

}
