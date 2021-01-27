package com.pizza.user.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import io.swagger.annotations.ApiModelProperty;

import javax.persistence.*;

@Entity
@Table(name="User")
public class User {

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    @ApiModelProperty(notes = "The database generated product ID")
    private long id;
    @Column(name = "username")
    @ApiModelProperty(notes = "The user Id to login")
    private String username;
    @Column(name="password")
    @JsonIgnore
    @ApiModelProperty(notes = "The user password")
    private String password;

    public User(long id, String username, String password) {
        super();
        this.id = id;
        this.username = username;
        this.password = password;

    }


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


}
