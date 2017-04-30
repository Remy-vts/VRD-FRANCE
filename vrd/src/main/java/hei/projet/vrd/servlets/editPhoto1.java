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

@WebServlet("/editPhoto1")
@MultipartConfig
public class editPhoto1 extends AbstractGenericServlet {
	
	private static final long serialVersionUID = 1L;
	
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		Part photo1 = req.getPart("add-photo1");
		
		ImageS3Util.uploadImageToAWSS3(photo1, "deconstruction");
				
		SiteService.getInstance().updatePhoto(
				1, 
				"https://s3.eu-west-2.amazonaws.com/vrdfrance/deconstruction"
				);
		
		resp.setCharacterEncoding("UTF8");
		resp.sendRedirect("adm-modifmsg");
		
	}

}
