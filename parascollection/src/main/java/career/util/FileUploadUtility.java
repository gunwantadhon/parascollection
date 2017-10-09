package career.util;

import java.io.File;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.multipart.MultipartFile;

public class FileUploadUtility {
	
	
	
	private static final String ABS_PATH="D:\\GitFolder\\parascollection\\parascollection\\src\\main\\webapp\\assets\\images";
	private static String REAL_PATH="";
	
	
	
	private static final Logger logger=LoggerFactory.getLogger(FileUploadUtility.class);
	public static void uploadFile(HttpServletRequest request, MultipartFile file, String code) {
		// TODO Auto-generated method stub
		
		//getReal path
		REAL_PATH=request.getSession().getServletContext().getRealPath("/assets/images/");
		logger.info(REAL_PATH);
		
		//to make sure all directory does not exist write the new directory.
		
		if(!new File(REAL_PATH).exists())
		{
			//create directory.
			new File(REAL_PATH).mkdirs();
		}
		
		try {
			//server upload
			file.transferTo(new File(REAL_PATH+code+".jpg"));
			//project upload
			file.transferTo(new File(ABS_PATH+code+".jpg"));
		} catch (Exception e) {
			// TODO: handle exception
		}
		
		
		
		
	}
	
	


}
