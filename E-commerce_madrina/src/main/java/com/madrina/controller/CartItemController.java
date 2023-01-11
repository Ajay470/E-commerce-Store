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

import com.madrina.Service.CartItemService;
import com.madrina.exception.CartItemException;
import com.madrina.model.CartItem;




@RestController
public class CartItemController {
	
	@Autowired
	private CartItemService CTService;
	
	
	@PostMapping("/cartitems")
	public ResponseEntity<CartItem> addCartItem(@RequestBody CartItem cartItem) throws CartItemException {

		CartItem resisteredCartItem = CTService.addCartItem(cartItem);

		return new ResponseEntity<CartItem>(resisteredCartItem, HttpStatus.ACCEPTED);

	}

	@GetMapping("/cartitems/{id}")
	public ResponseEntity<CartItem> viewCartItem(@PathVariable("id") Integer cartId) throws CartItemException {

		CartItem resisteredCartItem = CTService.viewCartItem(cartId);

		return new ResponseEntity<CartItem>(resisteredCartItem, HttpStatus.ACCEPTED);

	}

	@GetMapping("/getcartitems")
	ResponseEntity<List<CartItem>> viewAllCartItem() throws CartItemException {

		List<CartItem> allCartItem = CTService.viewAllCartItem();

		return new ResponseEntity<List<CartItem>>(allCartItem, HttpStatus.ACCEPTED);

	}

	@PutMapping("/cartitems")
	public ResponseEntity<CartItem> updateCartItem(@RequestBody CartItem cartItem) throws CartItemException {

		CartItem updatedCartItem = CTService.updateCartItem(cartItem);

		return new ResponseEntity<CartItem>(updatedCartItem, HttpStatus.OK);

	}

	@DeleteMapping("/cartitems/{id}")
	public ResponseEntity<CartItem>  removeCartItem(@PathVariable("id") Integer cartId) throws CartItemException{
		
		CartItem removedCartItem = CTService.removeCartItem(cartId);

		return new ResponseEntity<CartItem>(removedCartItem, HttpStatus.ACCEPTED);
		

		
	}
	
	

}
