package org.example.ddd.interfaces;

import lombok.RequiredArgsConstructor;
import org.example.ddd.application.dto.CreateOrderCommand;
import org.example.ddd.application.dto.OrderDTO;
import org.example.ddd.application.service.OrderApplicationService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/orders")
@RequiredArgsConstructor
public class OrderController {
    private final OrderApplicationService service;

    @PostMapping
    public OrderDTO create(@RequestBody CreateOrderCommand command) {
        return service.createOrder(command);
    }
}
