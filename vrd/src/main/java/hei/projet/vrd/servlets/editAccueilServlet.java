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
		context.setVariable("photo1", SiteService.getInstance().getPhoto(1));
		context.setVariable("photo2", SiteService.getInstance().getPhoto(2));
		context.setVariable("photo3", SiteService.getInstance().getPhoto(3));
		context.setVariable("photo4", SiteService.getInstance().getPhoto(4));
		context.setVariable("photo5", SiteService.getInstance().getPhoto(5));
		context.setVariable("photo6", SiteService.getInstance().getPhoto(6));
		context.setVariable("photo7", SiteService.getInstance().getPhoto(7));
		context.setVariable("photo8", SiteService.getInstance().getPhoto(8));
		
		
		context.setVariable("accueil", SiteService.getInstance().getGroupe(4));
		context.setVariable("chiffreun", SiteService.getInstance().getChiffres(1));
		context.setVariable("chiffredeux", SiteService.getInstance().getChiffres(2));
		context.setVariable("chiffretrois", SiteService.getInstance().getChiffres(3));
		context.setVariable("coordonnees", SiteService.getInstance().getCoordonnees(1));
		templateEngine.process("edit-accueil", context, resp.getWriter());
	}
	
	

}
