package com.example.put;

import java.util.Optional;

import org.springframework.http.HttpStatus;
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
    public ResponseEntity<?> update(@RequestBody Item item){
        Optional<Item> request_item = repository.findById(item.getId());
        if(request_item.isEmpty()){
            return new ResponseEntity<>("Not Found", HttpStatus.NOT_FOUND);
        }
        return ResponseEntity.ok(repository.save(item));
    }
}
