package com.product.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import com.product.dao.ProductDao;
import com.product.entity.Product;

@Service
public class ProductServiceImpl implements ProductService {

	@Autowired
	private ProductDao productRepository;

	public boolean productExists(Integer productId) {
		return productRepository.existsById(productId);
	}

	public Product getProductDetails(Integer productId) {
		Optional<Product> product = productRepository.findById(productId);
		return product.orElse(null);
	}

	@Override
	 @CachePut(value = "products", key = "#product.productid")
	public Product addProduct(Product product) {

		return productRepository.save(product);
	}

	@Override
	@Cacheable(value = "product",key = "#id")
	public Optional<Product> fetchProductById(Integer id) {

		return productRepository.findById(id);

	}

}
