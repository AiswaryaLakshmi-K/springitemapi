package com.example.sample.controller;

import com.example.sample.model.Item;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@RestController
@RequestMapping("/items")
public class Itemcontroller {

    private ArrayList<Item> items = new ArrayList<>();

    // Add new item
    @PostMapping
    public String addItem(@RequestBody Item item) {

        if (item.getName() == null || item.getName().isEmpty()) {
            return "Item name is required";
        }

        items.add(item);
        return "Item added successfully!";
    }

    // Get item by ID (simple logic)
    @GetMapping("/{id}")
    public Item getItemById(@PathVariable int id) {

        for (Item i : items) {
            if (i.getId() == id) {
                return i;
            }
        }

        return null;   // not found na null return
    }
}
