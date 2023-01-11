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

import com.madrina.Service.OrderService;
import com.madrina.exception.OrderException;
import com.madrina.model.Order;


@RestController
public class OrderController {
	
	@Autowired
	private OrderService OService;
	
	@PostMapping("/orders")
	public ResponseEntity<Order> addOrder(@RequestBody Order order) throws OrderException {

		Order resisteredOrder = OService.addOrder(order);

		return new ResponseEntity<Order>(resisteredOrder, HttpStatus.ACCEPTED);

	}

	@GetMapping("/orders/{id}")
	public ResponseEntity<Order> viewProduct(@PathVariable("id") Integer cartId) throws OrderException {

		Order resisteredOrder = OService.viewOrder(cartId);

		return new ResponseEntity<Order>(resisteredOrder, HttpStatus.ACCEPTED);

	}

	@GetMapping("/getorders")
	ResponseEntity<List<Order>> viewAllOrder() throws OrderException {

		List<Order> allOrder = OService.viewAllOrder();

		return new ResponseEntity<List<Order>>(allOrder, HttpStatus.ACCEPTED);

	}

	@PutMapping("/orders")
	public ResponseEntity<Order> updateProduct(@RequestBody Order order) throws OrderException {

		Order updatedOrder = OService.updateOrder(order);

		return new ResponseEntity<Order>(updatedOrder, HttpStatus.OK);

	}

	@DeleteMapping("/orders/{id}")
	public ResponseEntity<Order>  removeProduct(@PathVariable("id") Integer cartId) throws OrderException{
		
		Order removedOrder = OService.removeOrder(cartId);

		return new ResponseEntity<Order>(removedOrder, HttpStatus.ACCEPTED);
		

		
	}

}
