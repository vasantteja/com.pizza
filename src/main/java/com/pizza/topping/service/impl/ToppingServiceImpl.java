package com.pizza.topping.service.impl;

import com.pizza.topping.controller.ToppingController;
import com.pizza.topping.repository.ToppingDao;

import com.pizza.topping.domain.Topping;

import com.pizza.topping.service.ToppingService;

import com.pizza.user.domain.User;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Component
//@Service(value = "toppingService")
public class ToppingServiceImpl implements ToppingService {

    private static final Logger logger = LoggerFactory.getLogger(ToppingService.class);

    //@Autowired
    //private ToppingDao toppingDao;

    private static List<Topping> toppings = new ArrayList<>();

    static {
        //Initialize Data
        Topping topping1 = new Topping();
        topping1.setId(1);
        topping1.setTopping("Green Olives");
        topping1.setPrice(new BigDecimal("1.00"));
        topping1.setVeganFlag(true);
        Topping topping2 = new Topping();
        topping2.setId(2);
        topping2.setTopping("Chicken");
        topping2.setPrice(new BigDecimal("2.50"));
        topping2.setVeganFlag(false);
        toppings.add(topping1);
        toppings.add(topping2);
    }


    public List<Topping> findAll() {
        logger.debug("Retrieving all the toppings existing in the database.");
        //List<Topping> list = new ArrayList<>();
        //toppingDao.findAll().iterator().forEachRemaining(list::add);
        return toppings;
    }


    @Override
    public Topping save(Topping topping) {
        logger.debug("Saving the topping to the database.");
        //return toppingDao.save(topping);
        toppings.add(topping);
        return topping;
    }

    @Override
    public void delete(long id) {
        logger.debug("Deleting the topping from the database using the topping id.");
        //toppingDao.deleteById(id);
        toppings.removeIf(x -> String.valueOf(x.getId()).equals(String.valueOf(id)));
    }

    @Override
    public Optional<Topping> findOneBytopping(String topping) {
        logger.debug("Retrieving the topping existing in the database using topping name.");
        //return toppingDao.findOneBytopping(topping);
        Optional<Topping> toppingOptional = Optional.ofNullable(toppings.stream()
                .filter(x -> topping.equals(x.getTopping()))
                .findAny()
                .orElse(null));
        return toppingOptional;
    }

    @Override
    public void deleteByTopping(String topping) {
        logger.debug("Deleting the topping from the database using the topping name.");
        //toppingDao.deleteByTopping(topping);
        toppings.removeIf(x -> x.getTopping().equals(topping));
    }
}

