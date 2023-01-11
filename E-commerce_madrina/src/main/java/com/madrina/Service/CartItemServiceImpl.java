package com.madrina.Service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.madrina.exception.CartItemException;
import com.madrina.model.CartItem;
import com.madrina.repository.CartItemRepo;
@Service
public class CartItemServiceImpl implements CartItemService{
	
	@Autowired
	private CartItemRepo CTRepo;

	@Override
	public CartItem addCartItem(CartItem cartItem) throws CartItemException {
		Optional<CartItem> checkExistance = CTRepo.findById(cartItem.getId());

		if (checkExistance.isPresent())
			throw new CartItemException("This cart item alreday present...!");

		else

			return CTRepo.save(cartItem);
	}

	@Override
	public CartItem viewCartItem(Integer cartid) throws CartItemException {
		Optional<CartItem> checkExistance = CTRepo.findById(cartid);

		if (checkExistance.isPresent())
			return checkExistance.get();

		else

			throw new CartItemException("Cart item not found...!");
	}

	@Override
	public List<CartItem> viewAllCartItem() throws CartItemException {
		List<CartItem> allCartItem = CTRepo.findAll();

		if (allCartItem.size() != 0)
			return allCartItem;
		else
			throw new CartItemException("No cart item found...!");
	}

	@Override
	public CartItem updateCartItem(CartItem cartItem) throws CartItemException {
		Optional<CartItem> checkExistance = CTRepo.findById(cartItem.getId());

		if (checkExistance.isPresent())
			return CTRepo.save(cartItem);

		else

			throw new CartItemException("Invalid cart item...!");
	}

	@Override
	public CartItem removeCartItem(Integer cartid) throws CartItemException {
		Optional<CartItem> checkExistance = CTRepo.findById(cartid);

		if (checkExistance.isPresent()) {
			CTRepo.delete(checkExistance.get());
		    return checkExistance.get();
		}
		else {

			throw new CartItemException("Invalid cart item...!");
		
		}
	}

}
