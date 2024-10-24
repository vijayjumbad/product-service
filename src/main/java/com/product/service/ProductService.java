package com.product.service;

import java.util.Optional;

import com.product.entity.Product;

public interface ProductService {
	public boolean productExists(Integer productId);

	public Product getProductDetails(Integer productId);
	public Product addProduct(Product product);
	public Optional<Product>  fetchProductById(Integer id);

}
