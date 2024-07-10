package com.generation.gameZone.controller;


import com.generation.gameZone.model.Products;
import com.generation.gameZone.repository.ProductRepository;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/products")
@CrossOrigin(origins = "*",allowedHeaders = "*")
public class ProductsController {
    @Autowired
    private ProductRepository productRepository;

    @GetMapping
    public ResponseEntity<List<Products>> getAll(){
        return ResponseEntity.ok(productRepository.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Products> getById(@PathVariable Long id){
        return productRepository.findById(id)
                .map(response -> ResponseEntity.ok(response))
                .orElse(ResponseEntity.status(HttpStatus.NOT_FOUND).build());
    }

    @GetMapping("/name/{name}")
    public ResponseEntity<List<Products>>getByName(@PathVariable String name){
        return ResponseEntity.ok(productRepository.findAllBynameContainsIgnoreCase(name));
    }

    @PostMapping
    public ResponseEntity<Products>post(@Valid @RequestBody Products product){
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(productRepository.save(product));
    }

    @PutMapping
    public ResponseEntity<Products>put(@Valid @RequestBody Products product){
        return productRepository.findById(product.getId())
                .map(response -> ResponseEntity.status(HttpStatus.OK)
                        .body(productRepository.save(product)))
                .orElse(ResponseEntity.status(HttpStatus.NOT_FOUND).build());
    }

    @ResponseStatus(HttpStatus.NO_CONTENT)
    @DeleteMapping("/{id}")
    public void delete (@PathVariable Long id){
        Optional<Products> product = productRepository.findById(id);

        if (product.isEmpty())
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        productRepository.findById(id);
    }
}
