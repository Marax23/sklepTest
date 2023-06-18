package com.pyszniutkie;

import com.pyszniutkie.backend.dish.Dish;
import com.pyszniutkie.backend.dish.DishCategory;
import com.pyszniutkie.backend.dish.DishRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
@ExtendWith(SpringExtension.class)
@DataJpaTest
public class DishIntegrationTest {

    @Autowired
    private DishRepository dishRepository;

    @Test
    public void testCreateDish() {

        String name = "Burger";
        double price = 20;
        DishCategory category = DishCategory.DINER;
        Dish dish = new Dish(name, price, category);


        Dish savedDish = dishRepository.save(dish);


        assertNotNull(savedDish.getId());
        assertEquals(name, savedDish.getName());
        assertEquals(price, savedDish.getPrice());
        assertEquals(category, savedDish.getCategory());
    }
}
