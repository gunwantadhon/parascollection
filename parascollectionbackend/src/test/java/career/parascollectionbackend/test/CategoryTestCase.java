package career.parascollectionbackend.test;

import static org.junit.Assert.assertEquals;

import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import career.parascollectionbackend.dao.CategoryDAO;
import career.parascollectionbackend.dto.Category;

public class CategoryTestCase {

	
	private static AnnotationConfigApplicationContext context;
	private static CategoryDAO categoryDAO;
	private static Category category=null;
	
	
	
	@BeforeClass
	public static void init()
	{
		context=new AnnotationConfigApplicationContext();
		context.scan("career");
		context.refresh();
		categoryDAO=(CategoryDAO) context.getBean("categoryDAO");
		
		
	}
	
	@Test
	public void testGetCategory()
	{
	category=categoryDAO.get(3);
	assertEquals("successfully fetched Single Category ",
	"mobile",category.getName());
	//System.out.println(category.getName());
	}
}
