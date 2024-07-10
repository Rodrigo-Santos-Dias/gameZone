package com.generation.gameZone.model;


import jakarta.persistence.*;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Entity
@Table(name = "tb_products")
public class Products {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "The name attribute is mandatory")
    @Size(max = 100,message = "The name attribute must have a maximum of 100 characters")
    private String name;

    private BigDecimal price;

    @Min(value = 0, message = "The stock quantity must be a non-negative value")
    private int stock_quantity;

    private LocalDateTime date;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public @NotBlank(message = "The name attribute is mandatory") @Size(max = 100, message = "The name attribute must have a maximum of 100 characters") String getName() {
        return name;
    }

    public void setName(@NotBlank(message = "The name attribute is mandatory") @Size(max = 100, message = "The name attribute must have a maximum of 100 characters") String name) {
        this.name = name;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    @Min(value = 0, message = "The stock quantity must be a non-negative value")
    public int getStock_quantity() {
        return stock_quantity;
    }

    public void setStock_quantity(@Min(value = 0, message = "The stock quantity must be a non-negative value") int stock_quantity) {
        this.stock_quantity = stock_quantity;
    }

    public LocalDateTime getDate() {
        return date;
    }

    public void setDate(LocalDateTime date) {
        this.date = date;
    }
}
