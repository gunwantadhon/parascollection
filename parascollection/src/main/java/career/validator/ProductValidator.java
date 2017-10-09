package career.validator;


import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import career.parascollectionbackend.dto.Product;


public class ProductValidator implements Validator{

	@Override
	public boolean supports(Class<?>clazz) {


		return Product.class.equals(clazz);
	}

	@Override
	public void validate(Object target, Errors error) {


		Product product=(Product)target;
		
		
		
		//while file has been selected or not
		if(product.getFile()==null||
				product.getFile().
				getOriginalFilename().equals(""))

		{
			error.rejectValue("file",null,"please select an image");
			return ; 
			
		}
		
		if(!(
				
				product.getFile().getContentType().equals("image/jpeg")||
				product.getFile().getContentType().equals("image/jpg")||
				product.getFile().getContentType().equals("image/png")||
				product.getFile().getContentType().equals("image/gif")
				
				
				))
			
		{
			
			error.rejectValue("file",null,"please select jpeg jpg png gif image only");
			return;
		}
	
	
	
	
	
	}

}
