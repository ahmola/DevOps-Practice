package com.example.put;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@RequiredArgsConstructor
@RestController
public class ItemController {
    private final ItemRepository repository;

    @Transactional
    @PutMapping
    public ResponseEntity<Item> update(@RequestBody Item item){
        return ResponseEntity.ok(repository.save(item));
    }
}
