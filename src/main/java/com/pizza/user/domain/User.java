package com.pizza.user.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import io.swagger.annotations.ApiModelProperty;

import javax.persistence.*;

@Entity
public class User {

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    @ApiModelProperty(notes = "The database generated product ID")
    private long id;
    @Column(name = "username")
    @ApiModelProperty(notes = "The user Id to login")
    private String username;
    @Column
    @JsonIgnore
    @ApiModelProperty(notes = "The user password")
    private String password;
    @Column
    @ApiModelProperty(notes = "The user salary")
    private long salary;
    @Column
    @ApiModelProperty(notes = "The user age")
    private int age;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public long getSalary() {
        return salary;
    }

    public void setSalary(long salary) {
        this.salary = salary;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
}
