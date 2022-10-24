package com.toph.orders.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.toph.orders.dao.IventoryDao;
import com.toph.orders.entity.Item;

// TODO ????
// ? this is weird why am i returning item when its iventory 🤷🏼🤷🏼🤷🏼🤷🏼
@Service
public class InventoryService {

    @Autowired
    IventoryDao inventoryDao;

    public List<Item> getAllItems() {
        return this.inventoryDao.findAll();
    }

    public Item getItemById(int id) {
        Optional<Item> i = this.inventoryDao.findById(id);
        Item item = null;

        if (i.isPresent())
            item = i.get();
        else
            throw new RuntimeException("Item not found for id: " + id);

        return item;
    }

    // INFO: add or update item
    public Item saveItem(Item item) {
        return this.inventoryDao.save(item);
    }

    public String deleteItemById(int id) {
        this.inventoryDao.deleteById(id);
        return "Deleted Item with id: " + id;
    }
}
