package com.example.cryptoshop_backend.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Product {
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Integer id;
    private String name;
    private String description;
    private Double price;
    private String p_condition; //maybe this crashes MySQL since condition it's a reserved word.
    private String main_tag;
    private String sub_tag;
    private Double weight;
    private Double height;
    private Double width;
    private Double length;
    private Integer seller_id;
    private Integer buyer_id;
    private boolean has_been_bought;

    public Product() {
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

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public String getP_condition() {
        return p_condition;
    }

    public void setP_condition(String p_condition) {
        this.p_condition = p_condition;
    }

    public String getMain_tag() {
        return main_tag;
    }

    public void setMain_tag(String main_tag) {
        this.main_tag = main_tag;
    }

    public String getSub_tag() {
        return sub_tag;
    }

    public void setSub_tag(String sub_tag) {
        this.sub_tag = sub_tag;
    }

    public Double getWeight() {
        return weight;
    }

    public void setWeight(Double weight) {
        this.weight = weight;
    }

    public Double getHeight() {
        return height;
    }

    public void setHeight(Double height) {
        this.height = height;
    }

    public Double getWidth() {
        return width;
    }

    public void setWidth(Double width) {
        this.width = width;
    }

    public Double getLength() {
        return length;
    }

    public void setLength(Double length) {
        this.length = length;
    }

    public Integer getSeller_id() {
        return seller_id;
    }

    public void setSeller_id(Integer seller_id) {
        this.seller_id = seller_id;
    }

    public Integer getBuyer_id() {
        return buyer_id;
    }

    public void setBuyer_id(Integer buyer_id) {
        this.buyer_id = buyer_id;
    }

    public boolean isHas_been_bought() {
        return has_been_bought;
    }

    public void setHas_been_bought(boolean has_been_bought) {
        this.has_been_bought = has_been_bought;
    }
}
