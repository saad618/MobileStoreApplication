package com.mobile.store.service;

import java.util.List;
import java.util.Optional;
import com.mobile.store.dto.OrderByCustomer;
import com.mobile.store.exception.OrderException;

public interface OrderService {

	OrderByCustomer addOrder(OrderByCustomer orderByCustomer) throws OrderException;

	Boolean deleteOrderById(Integer orderId) throws OrderException;

	Optional<OrderByCustomer> getOrdersById(Integer orderId) throws OrderException;

	List<OrderByCustomer> getAllOrders(OrderByCustomer allOrders) throws OrderException;

}