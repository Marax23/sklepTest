package com.pyszniutkie.backend.dish;

import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class DishApiService {
    private DishRepository dishRepository;

    public DishApiService(DishRepository dishRepository) {
        this.dishRepository = dishRepository;
    }

    void add(Dish dish) {
        System.out.println(dish);
        if (dish.getName().equals("")) {
            throw new DishException("Nie podano nazwy posilku");
        }
        dishRepository.save(dish);
        //Tutaj bedzie kod dodajacy do bazy danych disha
    }

    Dish findByName(String name) {
        return dishRepository.findByName(name);
    }

     List<Dish> findALlDishes() {
        return dishRepository.findAll();
    }

    public List<Dish> findDishesByCategory(DishCategory category){
        return dishRepository.findByCategory(category);  //
    }
}
