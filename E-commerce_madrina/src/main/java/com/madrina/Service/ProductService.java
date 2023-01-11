package com.madrina.Service;

import java.util.List;

import com.madrina.exception.ProductException;
import com.madrina.model.Product;


public interface ProductService {
	
	Product addProduct(Product Product) throws ProductException;
	 
	Product viewProduct(Integer Pro_Id) throws ProductException;
	 
	 List<Product> viewAllProduct() throws ProductException;
	 
	 Product updateProduct(Product Product) throws ProductException;
	 
	 Product removeProduct(Integer Pro_Id) throws ProductException;

}
