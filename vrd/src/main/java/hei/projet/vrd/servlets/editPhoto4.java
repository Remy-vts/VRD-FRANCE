package hei.projet.vrd.servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;
import hei.projet.vrd.entities.ImageS3Util;
import hei.projet.vrd.services.SiteService;

@WebServlet("/editPhoto4")
@MultipartConfig
public class editPhoto4 extends AbstractGenericServlet {
	
	private static final long serialVersionUID = 1L;
    
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		Part photo = req.getPart("add-photo4");
		
		if(photo.getSize() != 0)
		{
		ImageS3Util.uploadImageToAWSS3(photo, "sciage");
		
		
		
		SiteService.getInstance().updatePhoto(
				4, 
				"https://s3.eu-west-2.amazonaws.com/vrdfrance/sciage"
				);
		
		resp.setCharacterEncoding("UTF8");
		resp.sendRedirect("adm-modifmsg");
		}else{
			resp.setCharacterEncoding("UTF8");
			resp.sendRedirect("adm-accueil");			
		}
	}

}
