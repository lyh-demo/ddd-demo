package org.example.ddd.application.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class OrderDTO {
    private Long id;
    private String customerName;
    private String status;
    private Double totalAmount;
}
