package com.toph.orders.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.toph.orders.dao.UserDao;
import com.toph.orders.entity.User;

@Service
public class UserService {

    @Autowired
    UserDao userDao;

    public List<User> getAllUsers() {
        return this.userDao.findAll();
    }

    public User getUserById(int id) {
        Optional<User> o = this.userDao.findById(id);
        User user = null;

        if (o.isPresent())
            user = o.get();
        else
            throw new RuntimeException("User not found for id: " + id);

        return user;
    }

    // ? add or update User
    public User saveUser(User user) {
        return this.userDao.save(user);
    }

    public String deleteUserById(int id) {
        this.userDao.deleteById(id);
        return "Deleted user with Id: " + id;
    }

}
