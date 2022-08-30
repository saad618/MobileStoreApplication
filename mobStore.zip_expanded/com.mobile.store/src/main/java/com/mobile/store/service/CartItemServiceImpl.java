package com.mobile.store.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mobile.store.dao.CartItemRepository;
import com.mobile.store.dao.CustomerRepository;
import com.mobile.store.dao.ProductRepository;
import com.mobile.store.dto.CartItem;
import com.mobile.store.dto.CartItemPrice;
import com.mobile.store.dto.CartProduct;
import com.mobile.store.dto.Customer;
import com.mobile.store.dto.Product;
import com.mobile.store.dto.Wishlist;
import com.mobile.store.exception.CartItemException;
import com.mobile.store.exception.CustomerException;
import com.mobile.store.exception.ProductException;
import com.mobile.store.exception.WishlistException;

@Service
public class CartItemServiceImpl implements CartItemService {

	@Autowired
	CustomerRepository customerRepository;

	@Autowired
	ProductRepository productRepository;

	@Autowired
	CartItemRepository cartItemRepository;

	/**
	 * Method:                       -  addProductToCart
	 * Description:                  -  Adding product into cart in the database  
	 * @return String                -  Success,if product added to cartsuccessfully,otherwise it throws CartException.
	 * @throws CartItemException :   -  It is raised due to  Customer already found in the database.
	 * Created By                    -  Bhumika Mulani
	 * Created Date                  -  16/August/2022
	 */
	@Override
	public String addProductToCart(CartItem cartItem) throws CartItemException, CustomerException, ProductException {
		Integer customerId = cartItem.getCustomerId();
		Integer productId = cartItem.getProductId();
		Optional<Customer> customer = this.customerRepository.findBycusotmerId(customerId);
		if (customer.isEmpty())
			throw new CustomerException("user not found.");
		Optional<Product> product = this.productRepository.findById(productId);
		if (product.isEmpty())
			throw new ProductException("product not found");
		List<CartItem> cartproduct = this.cartItemRepository.findCartitemsByCustomerIdAndProductId(customerId,
				productId);
		if (!(cartproduct.isEmpty()))
			throw new CartItemException("product already present in cart");
		this.cartItemRepository.save(cartItem);
		return "product added successfully to cart";
	}

	/**
	* Method:                      -   getProductByCusId
	* Description:                 -   Fetch product from the database with the help of cus's Id.
	* Integer                      -   Customer Id.  
	* @return Optional             -   Present if product found by customer id,otherwise it throws CartItemException,CustomerException,ProductException
	* @throws CartException :      -   It is raised due to  Product not found.
	* Created By                   -   Bhumika Mulani
	* Created Date
	*/
	@Override
	public CartItemPrice getProductByCusId(Integer customerId)
			throws CartItemException, CustomerException, ProductException {
		Optional<Customer> customer = this.customerRepository.findBycusotmerId(customerId);
		if (customer.isEmpty())
			throw new CustomerException("user not found.");
		List<CartItem> allcartitem = this.cartItemRepository.findCartitemsByCustomerId(customerId);
		List<CartProduct> cartProduct = new ArrayList<CartProduct>();
		Double amount = 0.0;
		
		for(CartItem iterator : allcartitem){
			Product temp1 = iterator.getProduct();
			Integer temp2 = iterator.getQuantity();
			Double temp3 = iterator.getTotalPrice();
			amount += temp3;
			CartProduct cartProductDto = new CartProduct(temp1,temp2,temp3);
			cartProduct.add(cartProductDto);
		}
		CartItemPrice cartItemPrice = new CartItemPrice(cartProduct,amount);
		
		
		return cartItemPrice;
	}

	/**
	* Method:                      -   getProductByCusIdAndProId
	* Description:                 -   Fetch product from the database with the help of customer id and Product id
	* Integer                      -   Customer Id and Product Id 
	* @return Optional             -   Present if product found,otherwise it throws CartItemException,CustomerException,ProductException.
	* @throws CartException :      -   It is raised due to  Product not found.
	* Created By                   -  Bhumika Mulani
	*/
	@Override
	public List<CartItem> getProductByCusIdAndProId(Integer customerId, Integer productId)
			throws CartItemException, CustomerException, ProductException {
		Optional<Customer> customer = this.customerRepository.findBycusotmerId(customerId);
		if (customer.isEmpty())
			throw new CustomerException("user not found.");
		Optional<Product> product = this.productRepository.findById(productId);
		if (product.isEmpty())
			throw new ProductException("product not found");
		List<CartItem> cartproduct = this.cartItemRepository.findCartitemsByCustomerIdAndProductId(customerId,
				productId);
		if ((cartproduct.isEmpty()))
			throw new CartItemException("product not present in cart");
		return this.cartItemRepository.findCartitemsByCustomerIdAndProductId(customerId, productId);
	}

	/**
	* Method:                      -   deleteProductFromCart
	* Description:                 -   Delete product from cart from the database
	* Integer                      -   Customer Id and Product Id     
	* @return String               -   Success,if product from cart deleted successfully,otherwise it throws CartItemException,CustomerException,ProductException.
	* @throws CartItemException :  -   It is raised due to  product not found or incorrect old password.
	* Created By					-  Bhumika Mulani
	*/
	@Override
	public String deleteProductFromCart(Integer customerId, Integer productId)
			throws CartItemException, CustomerException, ProductException {
		Optional<Customer> customer = this.customerRepository.findBycusotmerId(customerId);
		if (customer.isEmpty())
			throw new CustomerException("user not found.");
		List<CartItem> cartItem = this.cartItemRepository.findCartitemsByCustomerId(customerId);
		Integer temp = null;
		for (CartItem cart : cartItem) {
			if (cart.getProductId() == productId) {
				temp = cart.getCartitemId();
				this.cartItemRepository.deleteById(temp);
				break;
			}
		}

		if (temp != null)
			return "product delete sucessfully";
		else
			throw new CartItemException("product not found in the cart.");
	}

	/**
	* Method:                      -   updateQuantityOfCartProduct
	* Description:                 -   Update quantity of cart product in the database 
	* @return String               -   Success,if quantity of product in cart updated successfully,otherwise it throws CartItemException,CustomerException,ProductException.
	* @throws CartItemException :  -   It is raised due to  product not found.
	* Created By                   -   Bhumika Mulani
	* Created Date
	*/
	@Override
	public String updateQuantityOfCartProduct(Integer customerId, Integer productId, Integer quantity)
			throws CartItemException, CustomerException, ProductException {
		List<CartItem> product = this.cartItemRepository.findCartitemsByCustomerIdAndProductId(customerId, productId);
		if (product.isEmpty())
			throw new CartItemException("product not found in cart.");
		this.cartItemRepository.updateQuantity(quantity, customerId, productId);
		return "quantity update successfully";
	}
}
