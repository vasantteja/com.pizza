package com.pizza.topping.repository;


import com.pizza.topping.domain.Topping;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Repository
public interface ToppingDao extends CrudRepository<Topping, Long> {

    Optional<Topping> findOneBytopping(String topping);

    @Transactional
    /*Added @Trasnactional as we are getting transaction based error
    Please refer to this website for more clarity
    https://www.wilfriedbarth.com/til/2018-03-31-spring-transactional-annotation/
     */
    void deleteByTopping(String topping);

}



