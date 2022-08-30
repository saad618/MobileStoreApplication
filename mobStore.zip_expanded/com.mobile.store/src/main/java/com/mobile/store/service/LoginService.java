package com.mobile.store.service;

import com.mobile.store.dto.Customer;
import com.mobile.store.exception.AdminException;
import com.mobile.store.exception.CustomerException;

public interface LoginService {
	
	public String adminLogin(Integer adminId,String password) throws AdminException;

	public String customerLogin(Integer loginId, String password) throws CustomerException;
	
	public String customerLoginByEmailOrUserName(String data ,String password) throws CustomerException;
}
