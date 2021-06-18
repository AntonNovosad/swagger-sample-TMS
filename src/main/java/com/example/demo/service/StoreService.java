package com.example.demo.service;


import com.example.demo.dao.PetDao;
import com.example.demo.dao.StoreDao;
import com.example.demo.model.Order;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class StoreService {
    @Autowired
    StoreDao storeDao;

    @Autowired
    PetDao petDao;

    public Optional<Order> save(Order order) {
        if (!storeDao.contains(order.getId()) && petDao.contains(order.getId())) {
            storeDao.save(order);
        }
        return storeDao.getById(order.getId());
    }

    public void delete(Order order) {
        Optional<Order> byId = storeDao.getById(order.getId());
        if (byId.isPresent()) {
            storeDao.delete(byId.get());
        }
    }


    public Optional<Order> get(long id) {
        return storeDao.getById(id);
    }
}
