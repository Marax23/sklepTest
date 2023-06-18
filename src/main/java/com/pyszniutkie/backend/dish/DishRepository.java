package com.pyszniutkie.backend.dish;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface DishRepository extends JpaRepository<Dish,Integer> {

    public Dish findByName(String name);
    public List<Dish> findByCategory(DishCategory category);
    //Spring na podstawie nagłowka metody abstrakcyjnej jest w stanie wygenenerowac implementacje
}
