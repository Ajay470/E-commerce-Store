package com.madrina.Service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.madrina.exception.CategoryException;
import com.madrina.exception.ProductException;
import com.madrina.model.Category;
import com.madrina.model.Product;
import com.madrina.repository.CategoryRepo;
@Service
public class CategoryServiceImpl implements CategoryService{
	
	@Autowired
	private CategoryRepo CATrepo;

	@Override
	public Category addCategory(Category category) throws CategoryException {
		Optional<Category> checkExistance = CATrepo.findById(category.getId());

		if (checkExistance.isPresent())
			throw new CategoryException("This category alreday present...!");

		else

			return CATrepo.save(category);
	}

	@Override
	public Category viewCategory(Integer cat_id) throws CategoryException {
		Optional<Category> checkExistance = CATrepo.findById(cat_id);

		if (checkExistance.isPresent())
			return checkExistance.get();

		else

			throw new CategoryException("Category not found...!");
	}

	@Override
	public List<Category> viewAllCategory() throws CategoryException {
		List<Category> allCategory = CATrepo.findAll();

		if (allCategory.size() != 0)
			return allCategory;
		else
			throw new CategoryException("No category found...!");
	}

	@Override
	public Category updateCategory(Category category) throws CategoryException {
		Optional<Category> checkExistance = CATrepo.findById(category.getId());

		if (checkExistance.isPresent())
			return CATrepo.save(category);

		else

			throw new CategoryException("Invalid category...!");
	}

	@Override
	public Category removeCategory(Integer cat_id) throws CategoryException {
		Optional<Category> checkExistance = CATrepo.findById(cat_id);

		if (checkExistance.isPresent()) {
			CATrepo.delete(checkExistance.get());
		    return checkExistance.get();
		}
		else {

			throw new CategoryException("Invalid category...!");
		
		}
	}

	
	
	

}
