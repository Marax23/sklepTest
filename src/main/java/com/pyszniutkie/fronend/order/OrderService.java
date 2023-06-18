package com.pyszniutkie.fronend.order;

import com.pyszniutkie.backend.order.Address;
import com.pyszniutkie.backend.order.Bill;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
public class OrderService {

    private OrderClient client;

    public OrderService(OrderClient client) {
        this.client = client;
    }

    public Bill sendDishesOrder(Map<String, String> order) {
        //todo optional frontend dishes validation
        Map<Integer, Integer> orderAsNumbers = new HashMap<>();//przerabiamy ze Stringów na inty i zgarniamy wartość za myślnikiem
        for (String stringId : order.keySet()) {
            String[] array = stringId.split("-");
            int id = Integer.parseInt(array[1]);
            int count = Integer.parseInt(order.get(stringId));
            if (id <= 0) {
                throw new OrderServiceException("Id niepoprawne!");
            }
            if (count < 0) {
                throw new OrderServiceException("Ilość niepoprawna!");
            }
            orderAsNumbers.put(id, count);
        }
       return client.saveDishesOrder(orderAsNumbers);

    }

    public void finishDishOrder(Address address, int orderId) {
        client.finishDishOrder(address,orderId);
    }
}
