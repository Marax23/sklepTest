package com.pyszniutkie.backend.order;

import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderRepository extends JpaRepository<DishOrder, Integer> {

}
