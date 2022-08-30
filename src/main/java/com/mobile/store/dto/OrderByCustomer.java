package com.mobile.store.dto;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

@Entity
public class OrderByCustomer {

	@Id
	private Integer OrderId;

	@OneToMany
	@JoinColumn(name = "orderId")
	private List<Product> product;

	@OneToOne
	private Payment payment;

	public OrderByCustomer() {
		super();
	}

	public OrderByCustomer(Integer orderId, List<Product> product, Payment payment) {
		super();
		this.OrderId = orderId;
		this.product = product;
		this.payment = payment;
	}

	public Integer getOrderId() {
		return OrderId;
	}

	public void setOrderId(Integer orderId) {
		this.OrderId = orderId;
	}

	public List<Product> getProduct() {
		return product;
	}

	public void setProduct(List<Product> product) {
		this.product = product;
	}

	public Payment getPayment() {
		return payment;
	}

	public void setPayment(Payment payment) {
		this.payment = payment;
	}

}