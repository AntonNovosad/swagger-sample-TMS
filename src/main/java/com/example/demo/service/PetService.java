package com.example.demo.service;


import com.example.demo.dao.PetDao;
import com.example.demo.model.Pet;
import com.example.demo.model.PetStatus;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
public class PetService {
    @Autowired
    PetDao petDao;

    public void save(Pet pet) {
        if (!petDao.contains(pet.getId())) {
            petDao.add(pet);
        }
    }

    public void update(Pet pet) {
        if (petDao.contains(pet.getId())) {
            petDao.update(pet);
        }
    }

    public List<Pet> listByStatus(String[] status) {
        return petDao.getByStatus(status);
    }

    public Pet getById(long id) {
        Optional<Pet> byId = petDao.getById(id);
        if (byId.isPresent()) {
            return byId.get();
        }
        return null;
    }

    public void update(long id, String name, String status) {
        if (petDao.contains(id)) {
            petDao.update(id, name, PetStatus.valueOf(status));
        }
    }

    public void delete(long id) {
        if (petDao.contains(id)) {
            Pet pet = petDao.getById(id).get();
            petDao.delete(pet);
        }
    }
}
