package com.example.demo.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

import java.time.LocalDate;

@Component
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Order {
    private int id;
    private int petId;
    private int quantity;
    private LocalDate shipDate;
    private OrderStatus status;
    private boolean complete;
}
