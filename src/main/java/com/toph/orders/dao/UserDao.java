package com.toph.orders.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.toph.orders.entity.User;

public interface UserDao extends JpaRepository<User, Integer> {

}
