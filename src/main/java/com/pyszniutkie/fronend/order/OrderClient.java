package com.pyszniutkie.fronend.order;

import com.pyszniutkie.backend.order.Address;
import com.pyszniutkie.backend.order.Bill;
import com.pyszniutkie.backend.order.DishOrder;
import org.hibernate.criterion.Order;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.util.Map;

@Component
public class OrderClient {

    private RestTemplate restTemplate;

    public OrderClient(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    public Bill saveDishesOrder(Map<Integer, Integer> order) {
        //wysyłamy wybrane potrawy po ich ilosci i id na backend
        ResponseEntity<Bill> response = restTemplate.postForEntity("http://localhost:8080/api/orders", order, Bill.class);
        return response.getBody();
        //backend w tle zatwierdza nam te potrawy, zapisuje do bazy, przidziela im id i tworzy pełny obiekt DishOrder z miejscem na adres
    }


    public void finishDishOrder(Address address, int orderId) {
        ResponseEntity<Bill> order = restTemplate.postForEntity("http://localhost:8080/api/orders/" + orderId + "/address", address, Bill.class);
        System.out.println("Created order: " + order);
    }
}
