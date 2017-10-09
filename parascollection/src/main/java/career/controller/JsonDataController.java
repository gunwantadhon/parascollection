package career.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import career.parascollectionbackend.dao.ProductDAO;
import career.parascollectionbackend.dto.Product;

@Controller
@RequestMapping("/json/data")
public class JsonDataController {

	@Autowired
	ProductDAO productDAO;
	@RequestMapping("/all/products")
	@ResponseBody
	public List<Product> getAllProducts()
	{
		
		return productDAO.listActiveProducts();
		
	}
	
	@RequestMapping("category/{id}/products")
	@ResponseBody
	public List<Product> getAllProductsByCategoryid(@PathVariable("id")int categoryId)
	{
		
		return productDAO.listActiveProductsByCategory(categoryId);
	}
	
	
	

	@RequestMapping("/admin/all/products")
	@ResponseBody
	public List<Product> getAllProductsForAdmin()
	{
		
		return productDAO.list();
	}
	
	
}
