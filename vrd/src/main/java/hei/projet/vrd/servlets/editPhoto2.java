package hei.projet.vrd.servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;import hei.projet.vrd.entities.ImageS3Util;
import hei.projet.vrd.services.SiteService;

@WebServlet("/editPhoto2")
@MultipartConfig
public class editPhoto2 extends AbstractGenericServlet {
	
	private static final long serialVersionUID = 1L;
    
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		Part photo = req.getPart("add-photo2");
		
		if(photo.getSize() != 0)
		{
		ImageS3Util.uploadImageToAWSS3(photo, "desamiantage");
		
		
		
		SiteService.getInstance().updatePhoto(
				2, 
				"https://s3.eu-west-2.amazonaws.com/vrdfrance/desamiantage"
				);
		
		resp.setCharacterEncoding("UTF8");
		resp.sendRedirect("adm-modifmsg");
		}else{
			resp.setCharacterEncoding("UTF8");
			resp.sendRedirect("adm-accueil");			
		}
	}

}
