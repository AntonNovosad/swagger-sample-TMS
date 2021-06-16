package com.example.demo.controller;

import com.example.demo.model.Order;
import org.apache.catalina.Store;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/store/order")
public class StoreController {
    private List<Order> storeList = new ArrayList<>();

    @PostMapping
    public ResponseEntity<Order> save(@RequestBody Order order) {
        if (storeList.add(order)) {
            return new ResponseEntity<>(order, HttpStatus.ACCEPTED);
        } else {
            return new ResponseEntity<>(order, HttpStatus.BAD_REQUEST);
        }
    }
}
