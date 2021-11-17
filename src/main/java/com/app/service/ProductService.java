package com.app.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.model.Billing;
import com.app.model.Product;
import com.app.repository.BillingRepositary;
import com.app.repository.ProductRepositary;
@Service
@Transactional
public class ProductService {

	@Autowired
	private ProductRepositary productrepo;
	
	public List<Product> listAllProducts(){
		return productrepo.findAll();
	}
	public void saveProduct(Product product) {
		 productrepo.save(product);
		 
	}
	public Product getProduct(Integer id) {
		return productrepo.findById(id).get();
	}
	public void deleteProduct(Integer id) {
		productrepo.deleteById(id);
	}
}
