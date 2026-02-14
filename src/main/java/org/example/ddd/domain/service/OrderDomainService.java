package org.example.ddd.domain.service;

import org.example.ddd.domain.model.Order;

public class OrderDomainService {
    public void validateOrder(Order order) {
        if (order.totalAmount() <= 0) {
            throw new IllegalStateException("Order total must be greater than 0.");
        }
    }
}
