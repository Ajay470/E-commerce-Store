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

import com.madrina.Service.CategoryService;
import com.madrina.exception.CategoryException;
import com.madrina.model.Category;


@RestController
public class CategoryController {
	
	@Autowired
	private CategoryService CATService;
	
	@PostMapping("/categories")
	public ResponseEntity<Category> addCategory(@RequestBody Category category) throws CategoryException {

		Category resisteredCategory = CATService.addCategory(category);

		return new ResponseEntity<Category>(resisteredCategory, HttpStatus.ACCEPTED);

	}

	@GetMapping("/categories/{id}")
	public ResponseEntity<Category> viewCategory(@PathVariable("id") Integer Cat_id) throws CategoryException {

		Category resisteredCategory = CATService.viewCategory(Cat_id);

		return new ResponseEntity<Category>(resisteredCategory, HttpStatus.ACCEPTED);

	}

	@GetMapping("/getcategories")
	ResponseEntity<List<Category>> viewAllCategory() throws CategoryException {

		List<Category> allCategories = CATService.viewAllCategory();

		return new ResponseEntity<List<Category>>(allCategories, HttpStatus.ACCEPTED);

	}

	@PutMapping("/categories")
	public ResponseEntity<Category> updateCategory(@RequestBody Category category) throws CategoryException {

		Category updatedCategory = CATService.updateCategory(category);

		return new ResponseEntity<Category>(updatedCategory, HttpStatus.OK);

	}

	@DeleteMapping("/categories/{id}")
	public ResponseEntity<Category>  removeUser(@PathVariable("id") Integer Cat_id) throws CategoryException{
		
		Category removedCategory = CATService.removeCategory(Cat_id);

		return new ResponseEntity<Category>(removedCategory, HttpStatus.ACCEPTED);
		

		
	}

}
