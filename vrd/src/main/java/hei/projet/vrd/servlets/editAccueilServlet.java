package hei.projet.vrd.servlets;

import java.io.IOException;
import java.util.Calendar;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;
import org.thymeleaf.TemplateEngine;
import org.thymeleaf.context.WebContext;
import hei.projet.vrd.entities.Accueil;
import hei.projet.vrd.entities.ImageS3Util;
import hei.projet.vrd.services.SiteService;

@WebServlet("/adm-accueil")
@MultipartConfig
public class editAccueilServlet extends AbstractGenericServlet {
	private static final long serialVersionUID = 1L;
      
	/**
	 * @see HttpServlet#doGet(HttpServletRequest req, HttpServletResponse resp)
	 */
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		resp.setCharacterEncoding("UTF-8");
		
		TemplateEngine templateEngine =this.createTemplateEngine(req);
		
		WebContext context = new WebContext(req, resp, req.getServletContext());
		context.setVariable("photos", SiteService.getInstance().getPhoto(1));
		context.setVariable("accueil", SiteService.getInstance().getGroupe(4));
		context.setVariable("chiffreun", SiteService.getInstance().getChiffres(1));
		context.setVariable("chiffredeux", SiteService.getInstance().getChiffres(2));
		context.setVariable("chiffretrois", SiteService.getInstance().getChiffres(3));
		templateEngine.process("edit-accueil", context, resp.getWriter());
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		Part photo1 = req.getPart("add-photo1");
		Part photo2 = req.getPart("add-photo2");
		Part photo3 = req.getPart("add-photo3");
		Part photo4 = req.getPart("add-photo4");
		Part photo5 = req.getPart("add-photo5");
		Part photo6 = req.getPart("add-photo6");
		Part photo7 = req.getPart("add-photo7");
		Part photo8 = req.getPart("add-photo8");
		
		Calendar cal = Calendar.getInstance();
		cal.add(Calendar.DATE, 1);
			
		
		ImageS3Util.uploadImageToAWSS3(photo1, "deconstruction");
		ImageS3Util.uploadImageToAWSS3(photo2, "desamiantage");
		ImageS3Util.uploadImageToAWSS3(photo3, "recyclage");
		ImageS3Util.uploadImageToAWSS3(photo4, "sciage");
		ImageS3Util.uploadImageToAWSS3(photo5, "terrassement");
		ImageS3Util.uploadImageToAWSS3(photo6, "vrd");
		ImageS3Util.uploadImageToAWSS3(photo7, "equipe");
		ImageS3Util.uploadImageToAWSS3(photo8, "bandeau");
		
		
		SiteService.getInstance().updatePhoto(
				1, 
				"https://s3.eu-west-2.amazonaws.com/vrdfrance/deconstruction",
				"https://s3.eu-west-2.amazonaws.com/vrdfrance/desamiantage",
				"https://s3.eu-west-2.amazonaws.com/vrdfrance/recyclage",
				"https://s3.eu-west-2.amazonaws.com/vrdfrance/sciage",
				"https://s3.eu-west-2.amazonaws.com/vrdfrance/terrassement",
				"https://s3.eu-west-2.amazonaws.com/vrdfrance/vrd",
				"https://s3.eu-west-2.amazonaws.com/vrdfrance/equipe",
				"https://s3.eu-west-2.amazonaws.com/vrdfrance/bandeau"
				);
		
		resp.setCharacterEncoding("UTF8");
		resp.sendRedirect("adm-addmsg");
		
	}

}
