package com.madrina.Service;

import java.util.List;

import com.madrina.exception.OrderException;
import com.madrina.model.Order;


public interface OrderService {

	Order addOrder(Order Order) throws OrderException;
	 
	 Order viewOrder(Integer cartid) throws OrderException;
	 
	 List<Order> viewAllOrder() throws OrderException;
	 
	 Order updateOrder(Order Order) throws OrderException;
	 
	 Order removeOrder(Integer cartid) throws OrderException;
}
