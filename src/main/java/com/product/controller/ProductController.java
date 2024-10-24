package com.product.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.product.entity.Product;
import com.product.service.ProductService;

@RestController
@RequestMapping("/products")
public class ProductController {
	
	@Autowired
	private ProductService productService;
	
	@PostMapping("/add")
	public ResponseEntity<Product> addProduct(@RequestBody Product product){
		Product products = productService.addProduct(product);
		return new ResponseEntity<Product>(products,HttpStatus.CREATED);
		
	}
	
	@GetMapping("/findProduct/{id}")
	public ResponseEntity<Product> findProductbyid(@PathVariable Integer id){
		Optional<Product> productById = productService.fetchProductById(id);
		return new ResponseEntity<Product>(HttpStatus.OK);
		
	}
	
	@GetMapping("/get/{id}")
	public Product getProductByid(@PathVariable Integer id) {
		
		return productService.getProductDetails(id);
	}
	
	@GetMapping("/exists/{id}")
	public Product getProductExist(@PathVariable Integer id) {
		
		return productService.getProductDetails(id);
	}
	

}
