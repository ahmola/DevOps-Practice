package com.example.get;

import java.util.List;
import java.util.Optional;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;


@Slf4j
@RequiredArgsConstructor
@RestController
public class ItemController {
    private final ItemRepository repository;

    @GetMapping("/all")
    public ResponseEntity<List<Item>> getAllItem() {
        log.info("All Item will be returned");
        return ResponseEntity.ok(repository.findAll());
    }
    

    @GetMapping("/item/{id}")
    public ResponseEntity<Optional<Item>> getItemById(@PathVariable Long id) {
        log.info("Get Item By ID {}", id);
        return ResponseEntity.ok(repository.findById(id));
    }

    @GetMapping
    public ResponseEntity<List<Item>> getItemByName(@RequestParam(name="name") String name) {
        log.info("Get All Items By Name {}", name);
        return ResponseEntity.ok(repository.findAllByName(name));
    }
    
}
