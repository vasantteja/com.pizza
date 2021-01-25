package com.pizza.model;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.Objects;

@Entity
public class Topping {

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private long id;

    @Column
    private String topping;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getTopping() {
        return topping;
    }

    public void setTopping(String topping) {
        this.topping = topping;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Topping topping1 = (Topping) o;
        return id == topping1.id && Objects.equals(topping, topping1.topping);
    }

    @Override
    public String toString() {
        return "Topping{" +
                "id=" + id +
                ", topping='" + topping + '\'' +
                '}';
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, topping);
    }
}
