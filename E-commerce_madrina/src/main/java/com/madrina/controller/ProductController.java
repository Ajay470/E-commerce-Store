package com.madrina.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.madrina.Service.ProductService;
import com.madrina.exception.ProductException;
import com.madrina.model.Product;


@RestController
public class ProductController {
	
	@Autowired
	private ProductService PService;
	
	@PostMapping("/products")
	public ResponseEntity<Product> addProduct(@RequestBody Product product) throws ProductException {

		Product resisteredProduct = PService.addProduct(product);

		return new ResponseEntity<Product>(resisteredProduct, HttpStatus.ACCEPTED);

	}

	@GetMapping("/products")
	public ResponseEntity<Product> viewProduct(@PathVariable("id") Integer Pro_Id) throws ProductException {

		Product resisteredProduct = PService.viewProduct(Pro_Id);

		return new ResponseEntity<Product>(resisteredProduct, HttpStatus.ACCEPTED);

	}

	@GetMapping("/getproducts")
	ResponseEntity<List<Product>> viewAllProduct() throws ProductException {

		List<Product> allProducts = PService.viewAllProduct();

		return new ResponseEntity<List<Product>>(allProducts, HttpStatus.ACCEPTED);

	}

	@PutMapping("/products")
	public ResponseEntity<Product> updateProduct(@RequestBody Product product) throws ProductException {

		Product updatedProduct = PService.updateProduct(product);

		return new ResponseEntity<Product>(updatedProduct, HttpStatus.OK);

	}

	@DeleteMapping("/products")
	public ResponseEntity<Product>  removeProduct(@PathVariable("id") Integer Pro_Id) throws ProductException{
		
		Product removedProduct = PService.removeProduct(Pro_Id);

		return new ResponseEntity<Product>(removedProduct, HttpStatus.ACCEPTED);
		

		
	}

}
