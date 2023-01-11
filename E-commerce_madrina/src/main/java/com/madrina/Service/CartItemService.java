package com.madrina.Service;

import java.util.List;

import com.madrina.exception.CartItemException;
import com.madrina.model.CartItem;


public interface CartItemService {
	
	CartItem addCartItem(CartItem cartItem) throws CartItemException;
	 
	CartItem viewCartItem(Integer cartid) throws CartItemException;
	 
	 List<CartItem> viewAllCartItem() throws CartItemException;
	 
	 CartItem updateCartItem(CartItem cartItem) throws CartItemException;
	 
	 CartItem removeCartItem(Integer cartid) throws CartItemException;

}
