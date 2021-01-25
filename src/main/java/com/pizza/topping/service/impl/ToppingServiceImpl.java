package com.pizza.topping.service.impl;

import com.pizza.topping.repository.ToppingDao;

import com.pizza.topping.domain.Topping;

import com.pizza.topping.service.ToppingService;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;


@Service(value = "toppingService")
public class ToppingServiceImpl implements ToppingService {

    @Autowired
    private ToppingDao toppingDao;


    public List<Topping> findAll() {
        List<Topping> list = new ArrayList<>();
        toppingDao.findAll().iterator().forEachRemaining(list::add);
        return list;
    }


    @Override
    public Topping save(Topping topping) {
        return toppingDao.save(topping);
    }

    @Override
    public void delete(long id) {
        toppingDao.deleteById(id);
    }

    @Override
    public Optional<Topping> findOneBytopping(String topping) {
        return toppingDao.findOneBytopping(topping);
    }

    @Override
    public void deleteByTopping(String topping) {
        toppingDao.deleteByTopping(topping);
    }
}

