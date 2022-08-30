package com.mobile.store.controller;

import java.util.*;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.mobile.store.dao.OrderRepository;
import com.mobile.store.dto.OrderByCustomer;
import com.mobile.store.exception.OrderException;
import com.mobile.store.service.OrderService;

@RestController
public class OrderController {

	@Autowired
	OrderService orderService;

	@PostMapping("order")
	public OrderByCustomer addOrder(@RequestBody OrderByCustomer orderByCustomer) throws OrderException {
		return this.orderService.addOrder(orderByCustomer);

	}

	@DeleteMapping("order/{orderId}")
	public Boolean deleteOrderById(@PathVariable Integer orderId) throws OrderException {
		return this.orderService.deleteOrderById(orderId);
	}

	@GetMapping("order/{orderId}")
	public Optional<OrderByCustomer> getOrderById(@PathVariable Integer orderId) throws OrderException {

		return this.orderService.getOrdersById(orderId);

	}

	@GetMapping("getAllOrders")
	public List<OrderByCustomer> getAllOrders() throws OrderException {

		return this.orderService.getAllOrders(null);

	}

}
