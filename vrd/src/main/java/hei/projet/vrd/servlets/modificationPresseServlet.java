package hei.projet.vrd.servlets;

import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
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
import hei.projet.vrd.entities.Presse;
import hei.projet.vrd.services.SiteService;

@WebServlet("/adm-mpresse")
@MultipartConfig
public class modificationPresseServlet extends AbstractGenericServlet {
	private static final long serialVersionUID = 1L;
      
	/**
	 * @see HttpServlet#doGet(HttpServletRequest req, HttpServletResponse resp)
	 */
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		Integer id = Integer.parseInt(req.getParameter("p"));
		resp.setCharacterEncoding("UTF-8");
		TemplateEngine templateEngine =this.createTemplateEngine(req);
		WebContext context = new WebContext(req, resp, req.getServletContext());
		context.setVariable("presse", SiteService.getInstance().getPresse(id));
		context.setVariable("coordonnees", SiteService.getInstance().getCoordonnees(1));
		templateEngine.process("modification-presse", context, resp.getWriter());
	}
	
		
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		Integer id = Integer.parseInt(req.getParameter("id"));
		String media = req.getParameter("media");
		String lien = req.getParameter("lien");
		String titre = req.getParameter("titre");
		String description = req.getParameter("content");
		Part photo = req.getPart("photo");
		
		LocalDate localDate = LocalDate.now();
		String date =DateTimeFormatter.ofPattern("yyy/MM/dd").format(localDate);
        System.out.println(date);	
        
        if(photo.getSize()!=0){ 
        	System.out.println("la photo n'est pas null est égale à "+photo.getSize());		
		String chemin = "https://s3.eu-west-2.amazonaws.com/vrdfrance/presse-"+date+"-"+id;
		ImageS3Util.uploadImageToAWSS3(photo, "presse-"+date+"-"+id);
		
		Presse pr = new Presse(id, media, date, lien, titre, description, chemin);
		
		SiteService.getInstance().updatePresse(pr);
		
        }else{
        	System.out.println("la photo est null");	
        	
        	Presse lArticle = SiteService.getInstance().getPresse(id);
            
            String urlString = lArticle.getUrl_photo();
        	      	
            Presse pr = new Presse(id, media, date, lien, titre, description, urlString);
            
        	
    		
        	SiteService.getInstance().updatePresse(pr);
        }
		
		resp.setCharacterEncoding("UTF8");
		resp.sendRedirect("adm-modifmsg");
	}
	
	

}
