package com.toph.orders.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.toph.orders.entity.Cart;

public interface CartDao extends JpaRepository<Cart, Integer> {

}
