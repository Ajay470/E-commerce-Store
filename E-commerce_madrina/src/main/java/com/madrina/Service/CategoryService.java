package com.madrina.Service;

import java.util.List;

import com.madrina.exception.CategoryException;
import com.madrina.model.Category;




public interface CategoryService {
	
	Category addCategory(Category category) throws CategoryException;
	 
	 Category viewCategory(Integer cat_id) throws CategoryException;
	 
	 List<Category> viewAllCategory() throws CategoryException;
	 
	 Category updateCategory(Category category) throws CategoryException;
	 
	 Category removeCategory(Integer cat_id) throws CategoryException;

}
