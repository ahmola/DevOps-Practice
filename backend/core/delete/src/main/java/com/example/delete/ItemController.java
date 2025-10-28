package com.example.delete;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
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
    @DeleteMapping
    public ResponseEntity<Boolean> deleteItem(@PathVariable(name="id") Long id){
        try {
            repository.deleteById(id);
            return ResponseEntity.ok(Boolean.TRUE);
        } catch (Exception e) {
            return new ResponseEntity<>(Boolean.FALSE, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
