package com.springbootCRUD.springbootcrudpoc.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.springbootCRUD.springbootcrudpoc.entity.Product;
import com.springbootCRUD.springbootcrudpoc.service.ProductService;

@RestController
public class ProductController {

	@Autowired
	private ProductService service;

	// For a single product
	@PostMapping("/addProduct")
	public Product addProduct(@RequestBody Product product) {
		return service.saveProduct(product);
	}

	// For list of products
	@PostMapping("/addProducts")
	public List<Product> addProducts(@RequestBody List<Product> product) {
		return service.saveProducts(product);
	}

	// For getting a list of products
	@GetMapping("/products")
	public List<Product> findAllProducts() {
		return service.getProducts();
	}

	// For getting a product based on its ID
	@GetMapping("/product/{id}")
	public Product findProductById(@PathVariable int id) {
		return service.getProductById(id);
	}

	// For getting a product based on its name
	@GetMapping("/product/{name}")
	public Product findProductByName(@PathVariable String name) {
		return service.getProductByName(name);
	}

	// For updating a product in the database
	@PutMapping("/update")
	public Product updateProduct(@RequestBody Product product) {
		return service.updateProduct(product);
	}
	
	// For deleting a product based on its ID
		@DeleteMapping("/delete/{id}")
		public String deleteProduct(@PathVariable int id) {
			return service.deleteProductById(id);
		}
	
}
