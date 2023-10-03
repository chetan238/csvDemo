package com.csv.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.csv.model.Product;

public interface ProductRepo extends JpaRepository<Product,Long> {

}
