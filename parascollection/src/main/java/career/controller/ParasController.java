package career.controller;



import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import career.exception.ProductNotFoundException;
import career.parascollectionbackend.dao.CategoryDAO;
import career.parascollectionbackend.dao.ProductDAO;
import career.parascollectionbackend.dto.Category;
import career.parascollectionbackend.dto.Product;

@Controller
public class ParasController {
private static final Logger logger = LoggerFactory.getLogger(ParasController.class);
	
	@Autowired 
	CategoryDAO categoryDAO;
	
	@Autowired 
	ProductDAO productDAO;
	@RequestMapping(value={"/","/home"})
	public ModelAndView index() {
		ModelAndView mm = new ModelAndView("page");
		mm.addObject("title","Home");
		
		logger.info("Inside page controller index method this is for Info");
		logger.debug("Inside page controller index method this is for debug");
		mm.addObject("categories", categoryDAO.list());
		mm.addObject("userClickHome",true);
		return mm;

	}
	
	
	@RequestMapping(value="/about")
	public ModelAndView about()
	{
		ModelAndView mm1=new ModelAndView("page");
		mm1.addObject("title","About");
		mm1.addObject("userClickAbout",true);
		return mm1;
		
	}
	
	@RequestMapping(value="/contact")
	public ModelAndView contact()
	{
		ModelAndView mm2=new ModelAndView("page");
		mm2.addObject("title","Contact");
		mm2.addObject("userClickContact",true);
		return mm2;
		
	}
	
	
	@RequestMapping(value="/show/all/products")
	public ModelAndView showAllProducts()
	{
	ModelAndView mv=new ModelAndView("page");
	mv.addObject("title","All Products");
	mv.addObject("categories", categoryDAO.list());
	mv.addObject("userClickAllProducts",true);
	return mv;
	}
	
	
	
	
	@RequestMapping(value="/show/category/{id}/products")
	public ModelAndView showCategoryProducts(@PathVariable("id")int id)
	{
	//CategoryDAO to fetch single category
	Category category=null;
	category=categoryDAO.get(id);
	ModelAndView mv=new ModelAndView("page");
	mv.addObject("title",category.getName());
	//passing the all category
	mv.addObject("categories", categoryDAO.list());
	//passing the sigle category.
	mv.addObject("category", category);
	mv.addObject("userClickCategoryProducts",true);
	return mv;
	}
	
	
	@RequestMapping(value = "/show/{id}/product")
	public ModelAndView showSinglProduct(@PathVariable("id") int id) throws ProductNotFoundException
	 {
	ModelAndView mv = new ModelAndView("page");
	Product product = productDAO.get(id);
	mv.addObject(product);
	// update the view count
	product.setViews(product.getViews() + 1);
	productDAO.update(product);
	// --------------------------
	mv.addObject("title", product.getName());
	mv.addObject("product", product);
	mv.addObject("userClickShowProduct", true);
	return mv;
	
	
}

}
