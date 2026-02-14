package org.example.ddd.domain.model;

import jakarta.persistence.Embeddable;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Embeddable
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class OrderItem {
    private String productName;
    private Integer quantity;
    private Double price;

    public double subtotal() {
        return price * quantity;
    }
}
