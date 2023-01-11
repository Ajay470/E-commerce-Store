package com.madrina.Service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.madrina.exception.ProductException;
import com.madrina.model.Product;
import com.madrina.repository.ProductRepo;
@Service
public class ProductServiceImpl implements ProductService{
	
	@Autowired
	private ProductRepo PRepo;

	@Override
	public Product addProduct(Product Product) throws ProductException {
		Optional<Product> checkExistance = PRepo.findById(Product.getId());

		if (checkExistance.isPresent())
			throw new ProductException("This product alreday present...!");

		else

			return PRepo.save(Product);
	}

	@Override
	public Product viewProduct(Integer Pro_Id) throws ProductException {
		Optional<Product> checkExistance = PRepo.findById(Pro_Id);

		if (checkExistance.isPresent())
			return checkExistance.get();

		else

			throw new ProductException("Product not found...!");
	}

	@Override
	public List<Product> viewAllProduct() throws ProductException {
		List<Product> allProduct = PRepo.findAll();

		if (allProduct.size() != 0)
			return allProduct;
		else
			throw new ProductException("No product found...!");
	}

	@Override
	public Product updateProduct(Product Product) throws ProductException {
		Optional<Product> checkExistance = PRepo.findById(Product.getId());

		if (checkExistance.isPresent())
			return PRepo.save(Product);

		else

			throw new ProductException("Invalid product...!");

	}

	@Override
	public Product removeProduct(Integer Pro_Id) throws ProductException {
		Optional<Product> checkExistance = PRepo.findById(Pro_Id);

		if (checkExistance.isPresent()) {
			PRepo.delete(checkExistance.get());
		    return checkExistance.get();
		}
		else {

			throw new ProductException("Invalid product...!");
		
		}
	}

}
