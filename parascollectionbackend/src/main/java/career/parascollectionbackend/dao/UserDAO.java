package career.parascollectionbackend.dao;

import java.util.List;

import career.parascollectionbackend.dto.Address;
import career.parascollectionbackend.dto.Cart;
import career.parascollectionbackend.dto.User;

public interface UserDAO {
	//add an user
	boolean addUser(User user);
	
	//user get by email
	User getByEmail(String email);
	
	//add an address
	boolean addAddress(Address address);
	
	Address getBillingAddress(int  userId);
	
	List<Address> listShippingAddress(int userId);
	
	//update cart
	boolean updateCart(Cart cart);
	
	//add a cart
	boolean addCart(Cart cart);
	
		
		
	
	

}
