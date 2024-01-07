package com.springbootCRUD.springbootcrudpoc.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.springbootCRUD.springbootcrudpoc.entity.Product;

public interface ProductRepository extends JpaRepository<Product, Integer> {

}
