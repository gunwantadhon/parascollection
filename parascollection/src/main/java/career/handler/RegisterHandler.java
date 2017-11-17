package career.handler;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import career.model.RegisterModel;
import career.parascollectionbackend.dao.UserDAO;
import career.parascollectionbackend.dto.Address;
import career.parascollectionbackend.dto.Cart;
import career.parascollectionbackend.dto.User;

@Component

public class RegisterHandler {
@Autowired
private UserDAO userDAO;



//initialization method 
public RegisterModel init(){
	
	return new RegisterModel();
}
	

public void addUser(RegisterModel registerModel,User user){
	
	registerModel.setUser(user);
	
}
	

public void addBilling(RegisterModel registerModel,Address address)
{
	registerModel.setBilling(address);
	
}

public String saveAll(RegisterModel registerModel)
{
	
	String transitionValue="success";
	
	
	//fetch the userr
	
	User user=registerModel.getUser();
	if(user.getRole().equals("USER"))
	{
		Cart cart=new Cart();
		cart.setUser(user);
		user.setCart(cart);
		
	}
	
	
	
	//for password
	
	
	//save the user
	userDAO.addUser(user);
	
	return transitionValue;
			
}

}
