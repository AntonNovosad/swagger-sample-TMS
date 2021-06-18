package com.example.demo.dao.inMemory;

import com.example.demo.dao.StoreDao;
import com.example.demo.model.Order;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Component
public class InMemoryStoreDao implements StoreDao {
    private List<Order> storeList = new ArrayList<>();

    @Override
    public void save(Order order) {
        storeList.add(order);
    }

    @Override
    public void delete(Order order) {
        storeList.remove(order);
    }

    @Override
    public Optional<Order> getById(long id) {
        for (Order order : storeList) {
            if (order.getId() == id) {
                return Optional.of(order);
            }
        }
        return Optional.empty();
    }

    @Override
    public boolean contains(long id) {
        for (Order order : storeList) {
            if (order.getId() == id) {
                return true;
            }
        }
        return false;
    }
}
