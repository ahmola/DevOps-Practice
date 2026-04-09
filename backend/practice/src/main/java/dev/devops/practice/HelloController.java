package dev.devops.practice;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Tag(name= "hello", description="Hello API")
@Slf4j
@RequiredArgsConstructor
@RequestMapping("/api/v1/hello")
@RestController
public class HelloController{

    private final HelloRepository helloRepository;

    @Operation(summary="Health Check", description="API Health Check")
    @GetMapping("/health")
    public ResponseEntity<String> health(){
        log.info("API Health Check");
        return ResponseEntity.ok("OK");
    }

    @Operation(summary="Hello Count", description="If API is called, count will be increased")
    @GetMapping
    public ResponseEntity<String> hello() {
        log.info("hello is called");

        Hello hello = helloRepository.findById(1L).orElse(new Hello());
        hello.setCount(hello.getCount()+1);
        helloRepository.save(hello);

        String message = "hello "+ hello.getCount().toString();
        
        return ResponseEntity.ok(message);
    }

}