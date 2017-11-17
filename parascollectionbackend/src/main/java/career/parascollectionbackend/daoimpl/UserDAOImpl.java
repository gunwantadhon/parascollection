package career.parascollectionbackend.daoimpl;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import career.parascollectionbackend.dao.UserDAO;
import career.parascollectionbackend.dto.Address;
import career.parascollectionbackend.dto.Cart;
import career.parascollectionbackend.dto.User;


@Repository("userDAO")
@Transactional
public class UserDAOImpl implements UserDAO{
	@Autowired
	SessionFactory sessionFactory;

	public boolean addUser(User user) {
		
		try {
			sessionFactory.getCurrentSession().persist(user);
			return true;
		    }
		catch (Exception e) 
		{
			e.printStackTrace();
			return false;

		}
		
		
		
	}

	public User getByEmail(String email) {
String selectQuery="FROM User where email=:email";
		
try {
	return sessionFactory.getCurrentSession()
			.createQuery(selectQuery,User.class)
			.setParameter("email",email)
			.getSingleResult();
	
	
} 
catch (Exception e) {
	e.printStackTrace();
}
		
		
		
		return null;
	}

	public boolean addAddress(Address address) {

try {
	
	//will look for this code  later and why we need  to change it
	sessionFactory.getCurrentSession().persist(address);
	return true;
} 
catch (Exception e) 
{
e.printStackTrace();
	return false;
}
		
		
		
		
	}

	public Address getBillingAddress(int userId) {

		
try {
	
	String selectQuery="FROM Address WHERE userId=:userId AND billing=:isBilling";
	
	return sessionFactory.getCurrentSession()
			.createQuery(selectQuery,Address.class)
			.setParameter("userId",userId)
			.setParameter("isBilling",true)
			.getSingleResult();
	
}

catch (Exception e) {
e.printStackTrace();
return null;

}
		
		
		
		
	}

	public List<Address> listShippingAddress(int userId) {

try {
String selectQuery="FROM Address WHERE userId=:userId AND shipping=:isShipping ORDER BY id DESC";
	
	return sessionFactory.getCurrentSession()
			.createQuery(selectQuery,Address.class)
			.setParameter("userId",userId)
			.setParameter("isShipping",true)
			.getResultList();

	
} 
catch (Exception e) {

	e.printStackTrace();
	return null;
}
		
		
		
	}

	public boolean updateCart(Cart cart) {

		try {
			
			sessionFactory.getCurrentSession().update(cart);
			return true;
			
		} catch (Exception e) {

			e.printStackTrace();
			return false;

			
			
		}
		
		

		
	}

	public boolean addCart(Cart cart) {


		try {
			
			sessionFactory.getCurrentSession().persist(cart);
			return true;
			
			
		} catch (Exception e) {
e.printStackTrace();
return false;
		}
		
		
		
		
	}



}
