package org.example.ddd.domain.model;

import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Table(name = "orders")
public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String customerName;

    @Enumerated(EnumType.STRING)
    private OrderStatus status;

    @ElementCollection
    private List<OrderItem> items = new ArrayList<>();

    public Order(String customerName) {
        this.customerName = customerName;
        this.status = OrderStatus.CREATED;
    }

    public void addItem(OrderItem item) {
        if (status != OrderStatus.CREATED) {
            throw new IllegalStateException("Only created orders can add items.");
        }
        items.add(item);
    }

    public void pay() {
        if (items.isEmpty()) {
            throw new IllegalStateException("Cannot pay empty order.");
        }
        this.status = OrderStatus.PAID;
    }

    public void cancel() {
        if (status == OrderStatus.PAID) {
            throw new IllegalStateException("Paid order cannot be cancelled.");
        }
        this.status = OrderStatus.CANCELLED;
    }

    public double totalAmount() {
        return items.stream().mapToDouble(OrderItem::subtotal).sum();
    }
}
