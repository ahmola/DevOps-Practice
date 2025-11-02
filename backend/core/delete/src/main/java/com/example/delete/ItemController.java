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
    @DeleteMapping("/item/{id}")
    public ResponseEntity<Boolean> deleteItem(@PathVariable(name="id") Long id){
        log.info("Delete Item : {}", id);
        try {
            repository.deleteById(id);
            log.info("Item ID {} is deleted", id);
            return ResponseEntity.ok(Boolean.TRUE);
        } catch (Exception e) {
            log.error("Failed to Delete Item ID {}, cause = ", id, e.toString());
            return new ResponseEntity<>(Boolean.FALSE, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
