package com.pyszniutkie.backend.dish;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
public class DIshApiController {

    private DishApiService dishApiService;

    public DIshApiController(DishApiService dishApiService) {
        this.dishApiService = dishApiService;
    }

//    @GetMapping("/api/dishes")
//    public Dish getDish()
//    {
//        Dish dish = new Dish("Jajecznica", 15,"Sniadania");
//        return dish;
//    }

    @PostMapping("/api/dishes")
    public ResponseEntity<?> addDish(@RequestBody Dish dish) {
        //System.out.println(dish);
        try {
            dishApiService.add(dish);
            return ResponseEntity.status(200).body(dish);
        } catch (DishException e) {
            System.out.println(e.getMassage());
            return ResponseEntity.status(400).body(e.getMessage());
        }
    }

    @GetMapping("/api/dishes/{name}")
    public Dish findDishByName(@PathVariable String name) {
        return dishApiService.findByName(name);
    }
//        @GetMapping("/api/dishes")
//        public Dish findDishByName(@RequestParam String name) {
//            return dishService.findByName(name);
//        }

    @GetMapping("/api/dishes")
    public List<Dish> findAllDish() {
        return dishApiService.findALlDishes();
    }

    @GetMapping(value = "/api/dishes",params = "category")
    public List<Dish> findDishesByCategory(DishCategory category){
        return dishApiService.findDishesByCategory(category);
    }
}
