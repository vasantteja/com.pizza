package com.pizza.model;


import io.swagger.annotations.ApiModelProperty;
import org.hibernate.annotations.Type;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Objects;

@Entity
public class Topping {

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    @ApiModelProperty(notes = "The database generated product ID")
    private long id;

    @Column
    @ApiModelProperty(notes = "The name of the topping.")
    private String topping;

    @Column
    @ApiModelProperty(notes = "The price of the topping.")
    private BigDecimal price;

    @Column(columnDefinition = "TINYINT")
    @Type(type = "org.hibernate.type.NumericBooleanType")
    @ApiModelProperty(notes = "Flag used to represent if the topping is vegan or not.")
    private boolean veganFlag;



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

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public boolean isVeganFlag() {
        return veganFlag;
    }

    public void setVeganFlag(boolean veganFlag) {
        this.veganFlag = veganFlag;
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
