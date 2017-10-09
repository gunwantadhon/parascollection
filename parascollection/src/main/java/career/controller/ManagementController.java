package career.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import career.parascollectionbackend.dao.CategoryDAO;
import career.parascollectionbackend.dao.ProductDAO;
import career.parascollectionbackend.dto.Category;
import career.parascollectionbackend.dto.Product;
import career.util.FileUploadUtility;
import career.validator.ProductValidator;

@Controller
@RequestMapping("/manage")
public class ManagementController {

	@Autowired
	CategoryDAO categoryDAO;
	
	@Autowired
	ProductDAO productDAO;
	
	private static Logger logger=LoggerFactory.getLogger(ManagementController.class);
	
	@RequestMapping(value="/products",method=RequestMethod.GET)
	@ResponseBody
	public ModelAndView showManageProducts(@RequestParam(name="operation",required=false) String operation)
	
	
	{
	
		ModelAndView mv=new ModelAndView("page");
		mv.addObject("userClickMangerProducts",true);
	    mv.addObject("title","Manage Products");
		
		
		
     Product nProduct=new Product();
		
		//set few of the  fields
		nProduct.setSupplierId(1);
		nProduct.setActive(true);
		mv.addObject("product",nProduct);
		
		
		if(operation!=null)
		{
			if(operation.equals("product"))
			{
				mv.addObject("message","Product Submited successfully ");
			}
			
			
			else if(operation.equals("category"))
			{
				mv.addObject("message","Category  Submited successfully ");
			}
		}
		return mv;	
	}
	
	
	//handling product submission
	
		@RequestMapping(value="/products",method=RequestMethod.POST)
		
		public String handleProductSubmission(@Valid@ModelAttribute ("product") Product mProduct,BindingResult result,Model model,HttpServletRequest request)
		{
			
			
			//adding the new product
			if(mProduct.getId()==0)
			{
				//create a new product record if the id id 0
				productDAO.add(mProduct);
				
			}
			//upadaing the product from edit button and then submit  by again form
			else
			{
				//update a product  record if the id is not 0
				productDAO.update(mProduct);
			}
			
			
			
			
			if(mProduct.getId()==0)
			{
			new ProductValidator().validate(mProduct, result);
			}
			else
			{
				if(!mProduct.getFile().getOriginalFilename().equals(""))
				{
					new ProductValidator().validate(mProduct, result);
				}
			}
			
			//check if any error 
			
			if(result.hasErrors())
			{
				
				model.addAttribute("userClickMangerProducts",true);
				model.addAttribute("title","Manage Products");
				model.addAttribute("message","Validation for product ");
				return"page";
			}
			
			logger.info(mProduct.toString());
			
			
			if(mProduct.getId()==0)
			{//create a new product record if the id is 0
			productDAO.add(mProduct);
			}
			else
			{
				//update a product record if the id is not  0
				productDAO.update(mProduct);
			}
			
			if(!mProduct.getFile().getOriginalFilename().equals(""))
			{
				FileUploadUtility.uploadFile(request,mProduct.getFile(),mProduct.getCode());
			}
			
			return"redirect:/manage/products?operation=product";
		}

	
		///parascollection/manage/product/1/activation
	
		//using for the activation and deactivation
		@RequestMapping(value="/product/{id}/activation",method=RequestMethod.POST)
		
		@ResponseBody
		public String handleProductActivation(@PathVariable("id")int id)
		{
			//fetching the product from the database
			Product product=productDAO.get(id);
			
			boolean isActive=product.isActive();
			
			//activating and deactivating the value
			product.setActive(!product.isActive());
			
			//for updating product
			productDAO.update(product);
			
			
			return (isActive)?"you have successfully deactivated product"+product.getId():
				"you have successfully activated product"+product.getId();
		}
		
	///////////////////////////////////////////////////////////////////////////	
		
		//editing products from the table this handler shows the data 
		//To spring form.for saving updated project we will use new product 
		//Save handler 

		
		@RequestMapping(value="/{id}/product",method=RequestMethod.GET)
		public ModelAndView showEditProducts(@PathVariable("id")int id)
		{
			ModelAndView m1=new ModelAndView("page");
			m1.addObject("userClickMangerProducts",true);
			m1.addObject("title","Manage Products");
			
			//fetch the product from the databae
			Product nProduct=productDAO.get(id);
			
			m1.addObject("product",nProduct);
			
			return m1;
		}
		
		
		
		//////////////////////////////////////////////////////////////
		
		
		

	@ModelAttribute("category")
	public Category getCategory()
	{
		return new Category();
	}

	
	//returning categories 
	
		@ModelAttribute("categories")
		public List<Category> getCategories()
		{ 
			
			return categoryDAO.list();
		}

	
}
