package com.springbootCRUD.springbootcrudpoc.service;

import java.util.List;

import javax.print.attribute.standard.MediaSize.Other;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springbootCRUD.springbootcrudpoc.entity.Product;
import com.springbootCRUD.springbootcrudpoc.repository.ProductRepository;

@Service
public class ProductService {

	@Autowired
	private ProductRepository repository;

	public Product saveProduct(Product product) {
		return repository.save(product);
	}

	public List<Product> saveProducts(List<Product> products) {
		return repository.saveAll(products);
	}
	
	//below method returns all the products in the database
	public List<Product> getProducts(){
		return repository.findAll();
	}
	
	//below method returns the product based on the ID from the database
	public Product getProductById(int id){
		return repository.findById(id).orElse(null);
	}
	
	//below method returns the product based on the name from the database
	public Product getProductByName(String name){
		return repository.findByName(name);
	}
	
	public String deleteProductById(int id) {
		repository.deleteById(id);
		return "Product removed!" +id;
	}
	
	public Product updateProduct(Product product) {
		Product existingProduct = repository.findById(product.getId()).orElse(null);
		existingProduct.setName(product.getName());
		existingProduct.setPrice(product.getPrice());
		existingProduct.setQuantity(product.getQuantity());
		return repository.save(existingProduct);
		
	}
}
