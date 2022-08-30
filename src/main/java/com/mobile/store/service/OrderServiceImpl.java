package com.mobile.store.service;

import java.util.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.mobile.store.dao.OrderRepository;
import com.mobile.store.dto.OrderByCustomer;
import com.mobile.store.exception.OrderException;

@Service
public class OrderServiceImpl implements OrderService {

	@Autowired
	private OrderRepository orderRepository;

	@Override
	public OrderByCustomer addOrder(OrderByCustomer orderByCustomer) throws OrderException {

		return this.orderRepository.save(orderByCustomer);

	}

	@Override
	public Optional<OrderByCustomer> getOrdersById(Integer orderId) throws OrderException {
		Optional<OrderByCustomer> tempOrder = this.orderRepository.findById(orderId);
		if (tempOrder.isEmpty())
			throw new OrderException("order not found");
		return this.orderRepository.findById(orderId);
	}

	@Override
	public Boolean deleteOrderById(Integer orderId) throws OrderException {
		if (orderId == null)
			return false;
		Optional<OrderByCustomer> tempOrder = this.orderRepository.findById(orderId);
		if (tempOrder.isEmpty())
			throw new OrderException("order not found");
		this.orderRepository.deleteById(orderId);
		return true;
	}

	@Override
	public List<OrderByCustomer> getAllOrders(OrderByCustomer allOrders) throws OrderException {
		List<OrderByCustomer> allOfOrders = this.orderRepository.findAll();
		if (allOfOrders.isEmpty()) {
			throw new OrderException("No orders found");
		}
		return allOfOrders;
	}

}