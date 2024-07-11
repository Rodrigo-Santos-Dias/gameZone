package com.generation.gameZone.repository;

import com.generation.gameZone.model.Products;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface CategoryRepository extends JpaRepository <Products, Long> {

    public List<Products>findAllBynameContainsIgnoreCase(@Param("name")String name);
}
