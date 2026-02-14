package org.example.ddd.application.service;

import lombok.RequiredArgsConstructor;
import org.example.ddd.application.dto.CreateOrderCommand;
import org.example.ddd.application.dto.OrderDTO;
import org.example.ddd.domain.model.Order;
import org.example.ddd.domain.model.OrderItem;
import org.example.ddd.domain.model.OrderRepository;
import org.example.ddd.domain.service.OrderDomainService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class OrderApplicationService {
    private final OrderRepository orderRepository;
    private final OrderDomainService domainService = new OrderDomainService();

    @Transactional
    public OrderDTO createOrder(CreateOrderCommand command) {

        Order order = new Order(command.getCustomerName());

        command.getItems().forEach(item ->
                order.addItem(new OrderItem(
                        item.getProductName(),
                        item.getQuantity(),
                        item.getPrice()
                ))
        );

        domainService.validateOrder(order);

        Order saved = orderRepository.save(order);

        return new OrderDTO(
                saved.getId(),
                saved.getCustomerName(),
                saved.getStatus().name(),
                saved.totalAmount()
        );
    }
}
