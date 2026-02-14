package org.example.ddd.application.dto;

import lombok.Data;

import java.util.List;

@Data
public class CreateOrderCommand {
    private String customerName;
    private List<Item> items;

    @Data
    public static class Item {
        private String productName;
        private Integer quantity;
        private Double price;
    }
}
