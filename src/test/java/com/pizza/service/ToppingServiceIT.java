package com.pizza.service;

import com.pizza.topping.domain.Topping;
import com.pizza.topping.repository.ToppingDao;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.InstanceOfAssertFactories.OPTIONAL;
import static org.junit.jupiter.api.Assertions.*;
import static org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase.Replace.NONE;


@ActiveProfiles("test")
@RunWith(SpringRunner.class)
@DataJpaTest
@AutoConfigureTestDatabase(replace = NONE)
public class ToppingServiceIT {

    @Autowired
    private TestEntityManager entityManager;

    @Autowired
    private ToppingDao toppingDao;

    @Test
    public void testFindAll() {


        //when
        List<Topping> list = new ArrayList<>();
        toppingDao.findAll().iterator().forEachRemaining(list::add);

        //then
        assertThat(list.size()).isEqualTo(10);
        assertThat(list.get(1).getTopping()).isEqualTo("Broccoli");
        assertThat(list.get(1).getPrice()).isEqualTo(new BigDecimal("3.25"));
        assertTrue(list.get(1).isVeganFlag());

    }

    @Test
    public void testFindOneBytopping() {


        Optional<Topping> toppingOptional = toppingDao.findOneBytopping("Tomatoes");
        assertNotNull(toppingOptional);
        assertEquals(toppingOptional.get().getTopping(), "Tomatoes");
        assertEquals(toppingOptional.get().getPrice(), new BigDecimal("1.08"));
        assertTrue(toppingOptional.get().isVeganFlag());

    }

    @Test
    @Transactional
    public void testdeleteByTopping() {

        toppingDao.deleteByTopping("Tomatoes");
        Optional<Topping> toppingOptional = toppingDao.findOneBytopping("Tomatoes");
        assertTrue(toppingOptional.isEmpty());


    }

    @Test
    @Transactional
    public void testSave() {

        Topping topping = new Topping();
        topping.setTopping("Ground Beef");
        topping.setPrice(new BigDecimal("1.275"));
        topping.setVeganFlag(false);

        toppingDao.save(topping);

        Optional<Topping> toppingOptional = toppingDao.findOneBytopping("Ground Beef");
        assertTrue(toppingOptional.isPresent());

        assertEquals(toppingOptional.get().getTopping(), "Ground Beef");
        assertEquals(toppingOptional.get().getPrice(), new BigDecimal("1.275"));
        assertFalse(toppingOptional.get().isVeganFlag());


    }


}
