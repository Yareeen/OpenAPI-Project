package com.example.openapiproject.Controller;

import com.example.openapiproject.model.Shelf;
import com.example.openapiproject.repository.ShelfRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/shelves")
public class ShelfController {

    @Autowired
    private ShelfRepository shelfRepository;

    @GetMapping
    public List<Shelf> getAllShelves() {
        return shelfRepository.findAll();
    }

    @GetMapping("/{id}")
    public Shelf getShelfById(@PathVariable Long id) {
        return shelfRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Shelf not found with id " + id));
    }

    @PostMapping
    public Shelf createShelf(@RequestBody Shelf shelf) {
        return shelfRepository.save(shelf);
    }

    @PutMapping("/{id}")
    public Shelf updateShelf(@PathVariable Long id, @RequestBody Shelf shelfDetails) {
        Shelf shelf = shelfRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Shelf not found with id " + id));
        shelf.setName(shelfDetails.getName());
        return shelfRepository.save(shelf);
    }

    @DeleteMapping("/{id}")
    public void deleteShelf(@PathVariable Long id) {
        shelfRepository.deleteById(id);
    }
}