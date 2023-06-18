package com.pyszniutkie.fronend.dish;

import com.pyszniutkie.backend.dish.Dish;
import com.pyszniutkie.backend.dish.DishCategory;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Component
public class DishClient {

    private RestTemplate restTemplate; // sluzy do robienia zapytan http do backendu(tak jak postmen)

    public DishClient(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    public List<Dish> downloadDishes() {
        List<Dish> dishes = new ArrayList<>();
//        Dish potrawa1 = new Dish("Jajecznica",20,"Sniadanie");
//        Dish potrawa2 = new Dish("Schabowy",30,"Obiad");
//        dishes.add(potrawa1);
//        dishes.add(potrawa2);
        Dish[] dishesArray = restTemplate.getForObject("http://localhost:8080/api/dishes", Dish[].class);
        dishes.addAll(Arrays.asList(dishesArray));
        return dishes;
    }

    public List<Dish> downloadByCategory(DishCategory category) {
        List<Dish> dishes = new ArrayList<>();
        Dish[] dishesArray = restTemplate.getForObject("http://localhost:8080/api/dishes?category=" + category, Dish[].class);
        dishes.addAll(Arrays.asList(dishesArray));
        return dishes;
    }

    public void addDish(Dish dish) { //wysyła dish z frontendu na backend po sieci w formie jsona
        restTemplate.postForObject("http://localhost:8080/api/dishes", dish, Dish.class);
    }
}
