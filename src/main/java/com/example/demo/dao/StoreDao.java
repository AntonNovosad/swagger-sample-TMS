package com.example.demo.dao;

import com.example.demo.model.Order;

import java.util.Optional;

public interface StoreDao {
    void save(Order order);
    void delete(Order order);
    Optional<Order> getById(long id);
    boolean contains(long id);
}
