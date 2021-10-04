package com.example.cryptoshop_backend.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity // This tells Hibernate to make a table out of this class
public class User {
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private Integer id;
    private String name;
    private String email;
    private String username;
    private String hashed_pass;
    private int bought_p;
    private int sold_p;
    private String btcAddress;
    private String btcXpub;

    public User() {
    }
    public String getBtcAddress() {
        return btcAddress;
    }

    public void setBtcAddress(String btc_address) {
        this.btcAddress = btc_address;
    }

    public String getBtcXpub() {
        return btcXpub;
    }

    public void setBtcXpub(String btc_xpub) {
        this.btcXpub = btc_xpub;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getHashed_pass() {
        return hashed_pass;
    }

    public void setHashed_pass(String hashed_pass) {
        this.hashed_pass = hashed_pass;
    }

    public int getBought_p() {
        return bought_p;
    }

    public void setBought_p(int bought_p) {
        this.bought_p = bought_p;
    }

    public int getSold_p() {
        return sold_p;
    }

    public void setSold_p(int sold_p) {
        this.sold_p = sold_p;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}