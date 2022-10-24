package com.toph.orders.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.toph.orders.dao.CartDao;
import com.toph.orders.entity.Cart;

@Service
public class CartService {

    @Autowired
    CartDao cartDao;

    public List<Cart> getAllCarts() {
        return this.cartDao.findAll();
    }

    public Cart getCartById(int id) {
        Optional<Cart> c = this.cartDao.findById(id);
        Cart cart = null;

        if (c.isPresent())
            cart = c.get();
        else
            throw new RuntimeException("Cart not found for id: " + id);

        return cart;
    }

    // ? add or update order
    public Cart saveCart(Cart cart) {
        return this.cartDao.save(cart);
    }

    public String deleteCartById(int id) {
        this.cartDao.deleteById(id);
        return "Deleted cart with Id: " + id;
    }

}
