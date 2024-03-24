package com.springbootCRUD.springbootcrudpoc.controller;

import java.io.UnsupportedEncodingException;
import java.time.LocalTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.springbootCRUD.springbootcrudpoc.entity.Product;
import com.springbootCRUD.springbootcrudpoc.service.ProductService;
import com.springbootCRUD.springbootcrudpoc.smtpmail.EmailSender;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import io.swagger.v3.oas.models.media.MediaType;
import jakarta.mail.MessagingException;

@Tag(name = "Ecommerce Product", description = "Product Api for CRUD")
@RestController
public class ProductController {

	@Autowired
	private ProductService service;
	
	// Create an instance of EmailSender
	@Autowired
	EmailSender emailSender;

	@Operation(summary = "Add a product", description = "Adds a product data to the database")
	@ApiResponses(value = { 
			@ApiResponse(responseCode = "200", description = "Successful Operation"),
			@ApiResponse(responseCode = "400", description = "Bad Request.. Product Details not metioned.") 
			})
	
	// For a single product
	@PostMapping("/addProduct")
	public Product addProduct(@RequestBody Product product) {
		return service.saveProduct(product);
	}

	// For list of products
	@PostMapping(value = "/addProducts", produces = org.springframework.http.MediaType.APPLICATION_JSON_VALUE)
	public List<Product> addProducts(@RequestBody List<Product> product) {
		return service.saveProducts(product);
	}

	// For getting a list of products
	@GetMapping("/products")
	public List<Product> findAllProducts() {
		System.out.println("Scheduling at fixedDelay : " + LocalTime.now());
		return service.getProducts();
	}

	// For getting a product based on its ID
	@GetMapping("/productById/{id}")
	public Product findProductById(@PathVariable int id) {
		return service.getProductById(id);
	}

	// For getting a product based on its name
	@GetMapping("/productByName/{name}")
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
	
	// Mails
	@GetMapping("/mail")
	
	public String mailSent() {
		JavaMailSenderImpl mailSender = new JavaMailSenderImpl();


		// Call the sendEmail method to send an email
		String recipientEmail = "abc@gmail.com";
		String subject = "Hello from Spring Boot";
		String content = "<p>Hello,</p><p>This is a test email sent from Spring Boot.</p>";

		try {
		emailSender.sendEmail(recipientEmail, subject, content);
		System.out.println("Email sent successfully.");
		} catch (MessagingException | UnsupportedEncodingException e) {
		System.out.println("Failed to send email. Error: " + e.getMessage());
		}
		return "Mail Sent";
	} 

}
