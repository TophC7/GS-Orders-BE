package com.toph.orders.entity;

import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Cart {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    private int UserId;
    private List<Integer> itemIds = new ArrayList<>();

    public Cart() {
    }

    public Cart(int userId, List<Integer> itemIds) {
        UserId = userId;
        this.itemIds = itemIds;
    }

    public int getId() {
        return id;
    }

    public int getUserId() {
        return UserId;
    }

    public List<Integer> getItemIds() {
        return itemIds;
    }

}
