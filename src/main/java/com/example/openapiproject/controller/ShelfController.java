package com.example.openapiproject.controller;

import com.example.openapiproject.model.Shelf;
import com.example.openapiproject.repository.ShelfRepository;
import com.example.openapiproject.exception.ResourceNotFoundException;
import com.example.openapiproject.exception.CreationException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/shelves")
public class ShelfController {

    @Autowired
    private ShelfRepository shelfRepository;

    @GetMapping
    public ResponseEntity<List<Shelf>> getAllShelves() {
        List<Shelf> shelves = shelfRepository.findAll();
        if (shelves.isEmpty()) {
            throw new ResourceNotFoundException("No shelves found.");
        }
        return ResponseEntity.ok(shelves);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Shelf> getShelfById(@PathVariable Long id) {
        Shelf shelf = shelfRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Shelf not found with id " + id));
        return ResponseEntity.ok(shelf);
    }

    @PostMapping
    public ResponseEntity<Shelf> createShelf(@RequestBody Shelf shelf) {
        if (shelf.getName() == null) {
            throw new CreationException("Shelf name cannot be null.");
        }
        Shelf savedShelf = shelfRepository.save(shelf);
        return ResponseEntity.status(HttpStatus.CREATED).body(savedShelf);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Shelf> updateShelf(@PathVariable Long id, @RequestBody Shelf shelfDetails) {
        Shelf shelf = shelfRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Shelf not found with id " + id));
        shelf.setName(shelfDetails.getName());
        Shelf updatedShelf = shelfRepository.save(shelf);
        return ResponseEntity.ok(updatedShelf);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteShelf(@PathVariable Long id) {
        Shelf shelf = shelfRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Shelf not found with id " + id));
        shelfRepository.delete(shelf);
        return ResponseEntity.noContent().build();
    }
}
