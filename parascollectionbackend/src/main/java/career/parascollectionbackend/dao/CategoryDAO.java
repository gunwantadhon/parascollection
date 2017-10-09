package career.parascollectionbackend.dao;

import java.util.List;

import career.parascollectionbackend.dto.Category;

public interface CategoryDAO {
	
	public Category get(int id);
	public List<Category> list();
	boolean add(Category category);
	boolean update(Category category);
	boolean delete(Category category);
	

}
