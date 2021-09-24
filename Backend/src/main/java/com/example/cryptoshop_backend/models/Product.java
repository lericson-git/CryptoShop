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
    private String mainTag;
    private String subTag;
    private Double weight;
    private Double height;
    private Double width;
    private Double length;
    private Integer sellerId;
    private Integer buyerId;
    private boolean hasBeenBought;

    public boolean isHasBeenBought() {
        return hasBeenBought;
    }

    public void setHasBeenBought(boolean hasBeenBought) {
        this.hasBeenBought = hasBeenBought;
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

    public String getCondition() {
        return p_condition;
    }

    public void setCondition(String condition) {
        this.p_condition = condition;
    }

    public String getMainTag() {
        return mainTag;
    }

    public void setMainTag(String main_tag) {
        this.mainTag = main_tag;
    }

    public String getSubTag() {
        return subTag;
    }

    public void setSubTag(String sub_tag) {
        this.subTag = sub_tag;
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

    public Integer getSellerId() {
        return sellerId;
    }

    public void setSellerId(Integer seller_id) {
        this.sellerId = seller_id;
    }

    public Integer getBuyerId() {
        return buyerId;
    }

    public void setBuyerId(Integer buyer_id) {
        this.buyerId = buyer_id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }
}
