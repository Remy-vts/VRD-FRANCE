package hei.projet.vrd.servlets;

import java.io.IOException;
import java.text.SimpleDateFormat;
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

import hei.projet.vrd.entities.Chantier;
import hei.projet.vrd.entities.ImageS3Util;
import hei.projet.vrd.services.SiteService;

@WebServlet("/adm-realisations")
@MultipartConfig
public class editerReferenceServlet extends AbstractGenericServlet {
	private static final long serialVersionUID = 1L;
      
	/**
	 * @see HttpServlet#doGet(HttpServletRequest req, HttpServletResponse resp)
	 */
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		resp.setCharacterEncoding("UTF-8");
		
		TemplateEngine templateEngine =this.createTemplateEngine(req);
		
		WebContext context = new WebContext(req, resp, req.getServletContext());
		context.setVariable("references", SiteService.getInstance().listChantier());
		context.setVariable("coordonnees", SiteService.getInstance().getCoordonnees(1));
		templateEngine.process("editer-reference", context, resp.getWriter());
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String titre = req.getParameter("titre");
		String ville = req.getParameter("ville");
		Integer cp = Integer.parseInt(req.getParameter("cp"));
		String mo = req.getParameter("mo");
		String client = req.getParameter("client");
		String mission = req.getParameter("mission");		
		Part photo = req.getPart("photo");
		

		Calendar cal = Calendar.getInstance();
		cal.add(Calendar.DATE, 1);
		SimpleDateFormat format1 = new SimpleDateFormat("dd/MM/YYYY hh:mm:ss");
		String date = format1.format(cal.getTime());
		
		Chantier newChantier = new Chantier(
				null,
				ville,
				cp,
				date,
				mo,
				client,
				titre,
				mission,
				null
				);
		
		SiteService.getInstance().addChantier(newChantier, req.getPart("photo"));
		
		List <Chantier> listChantier = SiteService.getInstance().listChantier();
		int taille = listChantier.size();	
		Chantier leChantier = listChantier.get(taille-1);
				
		String id = leChantier.getId().toString();
		System.out.println("id : "+id);
		String chemin = "https://s3.eu-west-2.amazonaws.com/vrdfrance/chantier-"+id;
		ImageS3Util.uploadImageToAWSS3(photo, "chantier-"+id);
		
		Chantier ch = new Chantier(
				leChantier.getId(),
				ville,
				cp,
				date,
				mo,
				client,
				titre,
				mission,
				chemin
				);
		
		
		
		SiteService.getInstance().updateChantier(ch);
		
		resp.setCharacterEncoding("UTF8");
		resp.sendRedirect("adm-addmsg");
		
	}

}
