package com.pyszniutkie.backend.order;

import com.pyszniutkie.backend.dish.Dish;
import com.pyszniutkie.backend.dish.DishRepository;

import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
public class OrderApiService {

    private DishRepository dishRepository;
    private OrderRepository orderRepository;
    private AddressRepository addressRepository;

    public OrderApiService(DishRepository dishRepository, OrderRepository orderRepository, AddressRepository addressRepository) {
        this.dishRepository = dishRepository;
        this.orderRepository = orderRepository;
        this.addressRepository = addressRepository;
    }

    public Bill saveDishOrder(Map<Integer, Integer> orderMap) {
        Map<Dish, Integer> preparedMap = new HashMap<>();
        for (Integer id : orderMap.keySet()) {
            int amount = orderMap.get(id);
            //jeśli ilośc mniejsza niż 1 - pomiń
            if(amount<1) {
                continue;
            }
            Dish dish = dishRepository.findById(id).orElseThrow(); //jeśli nie znajdziesz po ID tego dania to rzuć wyjątek
            preparedMap.put(dish, amount);
        }
        DishOrder order = new DishOrder(preparedMap);
        orderRepository.save(order);
        return new Bill(order);
    }


    public Bill addAddress(int orderId, Address address) { //todo ale czy poprawny ten address? -> dodać validacje
        DishOrder order = orderRepository.findById(orderId).orElseThrow(); //todo obsługa tego wyjątku - co jeśli wpisano błędne ID?
        order.setAddress(address);
        addressRepository.save(address);
        orderRepository.save(order);
        return new Bill(order);
    }
}
