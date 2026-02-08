package com.example.sample.controller;

import com.example.sample.model.Item;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/items")
public class Itemcontroller {


    private List<Item> items = new ArrayList<>();

    @PostMapping
    public ResponseEntity<String> addItem(@RequestBody Item item) {

        // Input validation
        if (item.getName() == null || item.getName().isEmpty()) {
            return ResponseEntity.badRequest().body("Item name is required");
        }

        for (Item i : items) {
            if (i.getId() == item.getId()) {
                return ResponseEntity.status(HttpStatus.CONFLICT).body("Item ID already exists");
            }
        }

        items.add(item);
        return ResponseEntity.ok("Item added successfully!");
    }

    @GetMapping("/{id}")
    public ResponseEntity<Item> getItemById(@PathVariable int id) {
        for (Item i : items) {
            if (i.getId() == id) {
                return ResponseEntity.ok(i);
            }
        }

        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
    }

    @GetMapping
    public ResponseEntity<List<Item>> getAllItems() {
        return ResponseEntity.ok(items);
    }
}
