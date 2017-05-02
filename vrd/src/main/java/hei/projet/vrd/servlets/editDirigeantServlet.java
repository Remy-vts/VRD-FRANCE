package hei.projet.vrd.servlets;

import java.io.IOException;
import java.util.Calendar;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

import org.thymeleaf.TemplateEngine;
import org.thymeleaf.context.WebContext;

import hei.projet.vrd.entities.Dirigeant;
import hei.projet.vrd.entities.ImageS3Util;
import hei.projet.vrd.services.SiteService;

@WebServlet("/adm-dir")
@MultipartConfig
public class editDirigeantServlet extends AbstractGenericServlet {
	private static final long serialVersionUID = 1L;
      
	/**
	 * @see HttpServlet#doGet(HttpServletRequest req, HttpServletResponse resp)
	 */
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		resp.setCharacterEncoding("UTF-8");
		TemplateEngine templateEngine =this.createTemplateEngine(req);
		WebContext context = new WebContext(req, resp, req.getServletContext());
		context.setVariable("dirigeants", SiteService.getInstance().listDirigeant());
		context.setVariable("coordonnees", SiteService.getInstance().getCoordonnees(1));
		Calendar c = Calendar.getInstance();
		int year = c.get(Calendar.YEAR);
		context.setVariable("annee", year);
		templateEngine.process("adm-dirigeant", context, resp.getWriter());
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String nom = req.getParameter("dirigeantnom");
		String fonction = req.getParameter("dirigeantfonction");
		String presentation = req.getParameter("dirigeantpresentation");
		Part photo = req.getPart("dirigeantphoto");
		
		Dirigeant newDirigeant = new Dirigeant(
				null,
				nom,
				fonction,
				presentation,
				null
				);
		
		SiteService.getInstance().addDirigeant(newDirigeant, req.getPart("dirigeantphoto"));
		
		List <Dirigeant> listDirigeant = SiteService.getInstance().listDirigeant();
		int taille = listDirigeant.size();	
		Dirigeant lDirigeant = listDirigeant.get(taille-1);
				
		String id = lDirigeant.getID_individu().toString();
		System.out.println("id : "+id);
		String chemin = "https://s3.eu-west-2.amazonaws.com/vrdfrance/dirigeant-"+id;
		ImageS3Util.uploadImageToAWSS3(photo, "dirigeant-"+id);
		
		Dirigeant dir = new Dirigeant (lDirigeant.getID_individu(), nom, fonction, presentation, chemin);
		
		SiteService.getInstance().updateDirigeant(dir);
				
		resp.setCharacterEncoding("UTF8");
		resp.sendRedirect("adm-addmsg");
	}

}
