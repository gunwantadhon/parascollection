package career.parascollectionbackend.daoimpl;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import career.parascollectionbackend.dao.ProductDAO;
import career.parascollectionbackend.dto.Product;

@Transactional
@Repository("productDAO")
public class ProductDAOImpl  implements ProductDAO{
@Autowired
SessionFactory sessionFactory;
	public Product get(int productId) {
		try {
			return sessionFactory
			.getCurrentSession()
			.get(Product.class,
			Integer.valueOf(productId));
			} catch (Exception e) {

		return null;
	}
	}
	public List<Product> list() {
		try {
			return sessionFactory.getCurrentSession().createQuery("FROM Product",Product.class)
			.getResultList();
			} catch (Exception e) {

		return null;
	}
	}

	/*
	* Inserting Product into table ....
	* */
	
	public boolean add(Product product) {
		try {
			sessionFactory
			.getCurrentSession()
			.persist(product);
			return true;
			} catch (Exception e) {


		return false;
	}
	}
	/*
	* update the product table
	* */

	public boolean update(Product product) {

		try {
			sessionFactory
			.getCurrentSession()
			.update(product);
			return true;
			} catch (Exception e) {
		
		return false;
	}
	}

	public boolean delete(Product product) {
		try {
			product.setActive(false);
			//call the update method
			return this.update(product);
			} catch (Exception e) {
return false;
	}

}
	public List<Product> listActiveProducts() {
		String selectActiveProduct="FROM Product WHERE active= :active";

		return sessionFactory
				.getCurrentSession()
				.createQuery(selectActiveProduct,Product.class)
				.setParameter("active", true)
				.getResultList();

	}
	public List<Product> listActiveProductsByCategory(int categoryId) {
		String selectActiveProductByCategory="FROM Product WHERE active=:active AND categoryId= :categoryID";


		return sessionFactory
				.getCurrentSession()
				.createQuery(selectActiveProductByCategory,Product.class)
				.setParameter("active", true)
				.setParameter("categoryID", categoryId)
				.getResultList();
	}
	public List<Product> getLatestActiveProducts(int count) {


		return sessionFactory
				.getCurrentSession()
				.createQuery("FROM Product WHERE active=:active ORDER BY id",Product.class)
				.setParameter("active", true)
				.setFirstResult(0)
				.setMaxResults(count)
				.getResultList();
	}
}