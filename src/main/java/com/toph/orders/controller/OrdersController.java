package com.toph.orders.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.toph.orders.entity.Item;
import com.toph.orders.entity.Cart;
import com.toph.orders.entity.User;
import com.toph.orders.service.InventoryService;
import com.toph.orders.service.CartService;
import com.toph.orders.service.UserService;

@RestController
public class OrdersController {

    @Autowired
    private UserService userService;
    @Autowired
    private InventoryService inventoryService;
    @Autowired
    private CartService cartService;

    @GetMapping("/")
    public String home() {
        return "<HTMl><H1>Orders home API</H1></HTML>";
    }

    /////////////
    // * USERS //
    /////////////

    @GetMapping("/users")
    public List<User> users() {
        return this.userService.getAllUsers();
    }

    @GetMapping("/users/{id}")
    public User userById(@PathVariable String id) {
        return this.userService.getUserById(Integer.parseInt(id));
    }

    @PostMapping("/users")
    public User addUser(@RequestBody User user) {
        return this.userService.saveUser(user);
    }

    @PutMapping("/users")
    public User updateUser(@RequestBody User user) {
        return this.userService.saveUser(user);
    }

    @DeleteMapping("/users/{id}")
    public String delteUser(@PathVariable String id) {
        return this.userService.deleteUserById(Integer.parseInt(id));
    }

    /////////////////
    // * INVENTORY //
    /////////////////

    @GetMapping("/inventory")
    public List<Item> inventory() {
        return this.inventoryService.getAllItems();
    }

    @GetMapping("/inventory/{id}")
    public Item getInventoryItemById(@PathVariable String id) {
        return this.inventoryService.getItemById(Integer.parseInt(id));
    }

    @PostMapping("/inventory")
    public Item addItem(@RequestBody Item item) {
        return this.inventoryService.saveItem(item);
    }

    @PutMapping("/inventory")
    public Item updateItem(@RequestBody Item item) {
        return this.inventoryService.saveItem(item);
    }

    @DeleteMapping("/inventory/{id}")
    public String delteItem(@PathVariable String id) {
        return this.inventoryService.deleteItemById(Integer.parseInt(id));

    }

    //////////////
    // * CARTS //
    //////////////

    @GetMapping("/carts")
    public List<Cart> carts() {
        return this.cartService.getAllCarts();
    }

    @GetMapping("/carts/{id}")
    public Cart getCartById(@PathVariable String id) {
        return this.cartService.getCartById(Integer.parseInt(id));
    }

    @PostMapping("/carts")
    public Cart addCart(@RequestBody Cart cart) {
        return this.cartService.saveCart(cart);
    }

    @PutMapping("/carts")
    public Cart updateCart(@RequestBody Cart cart) {
        return this.cartService.saveCart(cart);
    }

    @DeleteMapping("/carts/{id}")
    public String delteCart(@PathVariable String id) {
        return this.cartService.deleteCartById(Integer.parseInt(id));

    }

    /////////////////////
    // * FUNCTIONALITY //
    /////////////////////
}
