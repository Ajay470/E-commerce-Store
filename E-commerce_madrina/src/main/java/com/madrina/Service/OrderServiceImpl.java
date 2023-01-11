package com.madrina.Service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.madrina.exception.OrderException;
import com.madrina.model.Order;
import com.madrina.repository.OrderRepo;
@Service
public class OrderServiceImpl implements OrderService{

	@Autowired
	private OrderRepo Orepo;
	 
	@Override
	public Order addOrder(Order order) throws OrderException {
		Optional<Order> checkExistance = Orepo.findById(order.getId());

		if (checkExistance.isPresent())
			throw new OrderException("This order alreday present...!");

		else

			return Orepo.save(order);
	}

	@Override
	public Order viewOrder(Integer cartid) throws OrderException {
		Optional<Order> checkExistance = Orepo.findById(cartid);

		if (checkExistance.isPresent())
			return checkExistance.get();

		else

			throw new OrderException("Order not found...!");
	}

	@Override
	public List<Order> viewAllOrder() throws OrderException {
		List<Order> allOrder = Orepo.findAll();

		if (allOrder.size() != 0)
			return allOrder;
		else
			throw new OrderException("No order found...!");
	}

	@Override
	public Order updateOrder(Order order) throws OrderException {
		Optional<Order> checkExistance = Orepo.findById(order.getId());

		if (checkExistance.isPresent())
			return Orepo.save(order);

		else

			throw new OrderException("Invalid order...!");
	}

	@Override
	public Order removeOrder(Integer cartid) throws OrderException {
		Optional<Order> checkExistance = Orepo.findById(cartid);

		if (checkExistance.isPresent()) {
			Orepo.delete(checkExistance.get());
		    return checkExistance.get();
		}
		else {

			throw new OrderException("Invalid order...!");
		
		}
	}

}
