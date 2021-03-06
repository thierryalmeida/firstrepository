package com.devsuperior.myfisrtproject.resources;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.devsuperior.myfisrtproject.entities.Product;
import com.devsuperior.myfisrtproject.repositories.ProductRepository;

@RestController
@RequestMapping(value = "/products")
public class ProductResource {
	
	@Autowired
	private ProductRepository productRepository;
	
	@GetMapping
	public ResponseEntity<List<Product>> findAll(){
		List<Product> products = productRepository.findAll();
		return ResponseEntity.ok().body(products);
	}
	
	@GetMapping(value = "/{id}")
	public ResponseEntity<Product> findById(@PathVariable Long id){
		Product product = productRepository.findById(id).get();
		return ResponseEntity.ok().body(product);
	}
}
