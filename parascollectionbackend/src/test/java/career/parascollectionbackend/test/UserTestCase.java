package career.parascollectionbackend.test;
import static org.junit.Assert.assertEquals;
import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import career.parascollectionbackend.dao.UserDAO;
import career.parascollectionbackend.dto.Address;
import career.parascollectionbackend.dto.Cart;
import career.parascollectionbackend.dto.User;

public class UserTestCase {
	private static AnnotationConfigApplicationContext context;
	private static UserDAO userDAO;
	private User user=null;
	private Cart cart=null;
	private Address address=null;
	
	
	@BeforeClass
	public static void init()
	{
		context=new AnnotationConfigApplicationContext();
		context.scan("career.parascollectionbackend");
		context.refresh();
		userDAO=(UserDAO) context.getBean("userDAO");
		
	}
	
	/*
	@Test
	
	public void testAllAddMethod()
	{
		user=new User();
		user.setFirstname("Gunjan");
		user.setLastname("dhon");
		user.setEmail("gunjan@gmail.com");
		user.setPassword("sai");
		user.setRole("Admin");
		user.setContactNumber("8691925057");
		
		//add the user
		assertEquals("failed to add user",true,userDAO.addUser(user));
		
	
	
	
	
	
	


	address=new Address();
		address.setAddressLineOne("sector 4");
		address.setAddressLineTwo("ghansoli");
		address.setCity("navi mumbai");
		address.setState("maharashtra");
		address.setCountry("india");
		address.setPostalCode("400701");
		address.setBilling(true);
		
		//link the user with the address using  user id 
		address.setId(user.getId());
		
		
		//add the user address
		assertEquals("failed to add user address",true,userDAO.addAddress(address));
		
		
		if(user.getRole().equals("User"))

		{
			//create cart for the user
			cart=new Cart();
			cart.setUser(user);

			
			//add the cart
			assertEquals("failed to add cart",true,userDAO.addCart(cart));
			
			
			
			//add shipping address for the user
			
			address=new Address();
			address.setAddressLineOne("sector 4");
			address.setAddressLineTwo("ghansoli");
			address.setCity("navi mumbai");
			address.setState("maharashtra");
			address.setCountry("india");
			address.setPostalCode("400701");
			address.setShipping(true);
			
			
			//link it to the user address
			
			
			
			
			
			//add the cart
			assertEquals("failed to add cart",true,userDAO.addCart(cart));
			
			
		}
	
	

	
	
		
		
	}
	
*/
	
	
	
	
	/*//after mapping
	@Test
	public void testAllAddMethod()
	{
		
		user=new User();
		user.setFirstname("Gunjan");
		user.setLastname("dhon");
		user.setEmail("gunjan@gmail.com");
		user.setPassword("sai");
		user.setRole("Admin");
		user.setContactNumber("8691925057");
		
		
		if(user.getRole().equals("User"))
		{
			cart=new Cart();
			cart.setUser(user);
			
			
			//attached cart with the user
			user.setCart(cart);
			
		}
		
		
		//add the user
		assertEquals("failed to user add",true,userDAO.addUser(user));
		
		
		
		//we are going to add address
		address=new Address();
		address.setAddressLineOne("sector 4");
		address.setAddressLineTwo("ghansoli");
		address.setCity("navi mumbai");
		address.setState("maharashtra");
		address.setCountry("india");
		address.setPostalCode("400701");
		address.setBilling(true);
		
		//link the user with address  using user id
		address.setUser(user);
		
		//add the user address
		assertEquals("failed to  add user address",true,userDAO.addAddress(address));
		
		
		
		
		//we are going to shipping address
		
		//add a shipping address for this user
		
		address=new Address();
		address.setAddressLineOne("sector 4");
		address.setAddressLineTwo("ghansoli");
		address.setCity("navi mumbai");
		address.setState("maharashtra");
		address.setCountry("india");
		
		address.setPostalCode("400701");
		address.setShipping(true);
		
		//link it to the user address
		address.setUser(user);
		
		
		//add user address
		assertEquals("failed to  add shipping address",true,userDAO.addAddress(address));
		
		
		
	}
	*/
	
	
	
	
	/*@Test
	public void testAllAddress()
	{
		
		user=userDAO.getByEmail("gunjan@gmail.com");
		address=new Address();
		address.setAddressLineOne("at lengarewadi");
		address.setAddressLineTwo("Atpadi");
		address.setCity("sangali");
		address.setState("maharashtra");
		address.setCountry("india");
		address.setPostalCode("415301");
		address.setShipping(true);

		//link user with address using user id
		address.setUser(user);
		
		//add the user address
		
		assertEquals("failed to  add user address",true,userDAO.addAddress(address));
		
		
		
		
		
		
	}
	*/
	
	
	@Test
	public void testGetAddress()
	{
		/*user=userDAO.getByEmail("gunjan@gmail.com");
		assertEquals("failed to fetch the user address",2,userDAO.listShippingAddress(user).size());
		
		
		assertEquals("failed to fetch the user address","navi mumbai",userDAO.getBillingAddress(user).getCity());*/
		
		

		
		
	}
	
	
	
	
}
