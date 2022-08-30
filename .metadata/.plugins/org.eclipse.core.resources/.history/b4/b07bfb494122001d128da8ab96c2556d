package com.mobile.store.service;

import java.util.List;
import java.util.Optional;

import com.mobile.store.dto.Payment;
import com.mobile.store.dto.Product;
import com.mobile.store.exception.CategoryException;
import com.mobile.store.exception.ProductException;



public interface ProductService {

	
	public Boolean addProduct(Product product)throws ProductException;
	
	public Optional<Product> getProductById(Integer productId)throws ProductException;
	
	public List<Product> getAllProduct() throws ProductException;
	
	public Boolean deleteProductById(Integer productId)throws ProductException;
	
	public Product updateProduct(Product product)throws ProductException;

/*	List<Product> findAllProductHighToLow();

	List<Product> findAllProductLowToHigh();

	Product findProductByName(String productName);
*/
	
}