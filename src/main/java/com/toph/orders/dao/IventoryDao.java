package com.toph.orders.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.toph.orders.entity.Item;

public interface IventoryDao extends JpaRepository<Item, Integer> {

}
