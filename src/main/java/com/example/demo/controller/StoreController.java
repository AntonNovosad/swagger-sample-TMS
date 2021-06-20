package com.example.demo.controller;

import com.example.demo.model.Order;
import com.example.demo.service.StoreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("store")
public class StoreController {
    @Autowired
    StoreService storeService;

    @PostMapping("/order")
    public ResponseEntity<Order> save(@RequestBody Order order) {
        Optional<Order> optionalOrder = storeService.save(order);
        if (optionalOrder.isPresent()) {
            return new ResponseEntity<>(optionalOrder.get(), HttpStatus.ACCEPTED);
        } else {
            return new ResponseEntity<>(order, HttpStatus.BAD_REQUEST);
        }
    }

    @DeleteMapping("/order/{orderId}")
    public void delete(@PathVariable long orderId) {
        storeService.delete(orderId);
    }

    @GetMapping("/order/{orderId}")
    public ResponseEntity<Order> get(@PathVariable long orderId) {
        Optional<Order> order = storeService.get(orderId);
        if (order.isPresent()) {
            return new ResponseEntity<>(order.get(), HttpStatus.ACCEPTED);
        }
        return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
    }
}
