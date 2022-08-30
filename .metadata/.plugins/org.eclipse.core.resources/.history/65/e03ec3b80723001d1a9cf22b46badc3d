package com.mobile.store.dto;

import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Payment {

	@Id
	private Integer paymentId;
	private Double paymentAmount;
	private String paymentType;
	private LocalDate paymentDate;
	private Integer paymentCustomerId;

	public Payment() {
		super();
		this.paymentDate = LocalDate.now();
	}

	public Payment(Integer paymentId, Double paymentAmount, Integer paymentCustomerId) {
		super();

		this.paymentId = paymentId;
		this.paymentAmount = paymentAmount;
		this.paymentDate = LocalDate.now();
		this.paymentCustomerId = paymentCustomerId;
		this.paymentType = "COD";
	}

	public Integer getPaymentId() {
		return paymentId;
	}

	public void setPaymentId(Integer paymentId) {
		this.paymentId = paymentId;
	}

	public Double getPaymentAmount() {
		return paymentAmount;
	}

	public void setPaymentAmount(Double paymentAmount) {
		this.paymentAmount = paymentAmount;
	}

	public String getPaymentType() {
		return paymentType;
	}

	public void setPaymentType(String paymentType) {
		this.paymentType = paymentType;
	}

	public LocalDate getPaymentDate() {
		return paymentDate;
	}

	public void setPaymentDate(LocalDate paymentDate) {
		this.paymentDate = paymentDate;
	}

	public Integer getPaymentCustomerId() {
		return paymentCustomerId;
	}

	public void setPaymentCustomerId(Integer paymentCustomerId) {
		this.paymentCustomerId = paymentCustomerId;
	}

}
