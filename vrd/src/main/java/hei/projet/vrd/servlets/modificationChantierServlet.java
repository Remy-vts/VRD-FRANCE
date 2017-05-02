package hei.projet.vrd.servlets;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
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

@WebServlet("/adm-mrealisations")
@MultipartConfig
public class modificationChantierServlet extends AbstractGenericServlet {
	private static final long serialVersionUID = 1L;
      
	/**
	 * @see HttpServlet#doGet(HttpServletRequest req, HttpServletResponse resp)
	 */
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		Integer id = Integer.parseInt(req.getParameter("c"));
		resp.setCharacterEncoding("UTF-8");
		TemplateEngine templateEngine =this.createTemplateEngine(req);
		WebContext context = new WebContext(req, resp, req.getServletContext());
		context.setVariable("chantier", SiteService.getInstance().getChantier(id));
		context.setVariable("coordonnees", SiteService.getInstance().getCoordonnees(1));
		Calendar c = Calendar.getInstance();
		int year = c.get(Calendar.YEAR);
		context.setVariable("annee", year);
		templateEngine.process("modification-chantier", context, resp.getWriter());
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		Integer id = Integer.parseInt(req.getParameter("id"));
		String titre = req.getParameter("titre");
		String ville = req.getParameter("ville");
		Integer cp = Integer.parseInt(req.getParameter("cp"));
		String mo = req.getParameter("mo");
		String client = req.getParameter("client");
		String mission = req.getParameter("mission");
		Part photo = req.getPart("photo");
		
		LocalDate localDate = LocalDate.now();
		String date =DateTimeFormatter.ofPattern("yyy/MM/dd").format(localDate);
        System.out.println(date);	
        
        if(photo.getSize()!=0){ 
        	System.out.println("la photo n'est pas null est égale à "+photo.getSize());		
		
		String chemin = "https://s3.eu-west-2.amazonaws.com/vrdfrance/chantier-"+date+"-"+id;
		ImageS3Util.uploadImageToAWSS3(photo, "chantier-"+date+"-"+id);
		
		Chantier ch = new Chantier(id, ville, cp, null, mo, client, titre, mission, chemin);
		
		SiteService.getInstance().updateChantier(ch);
		
        }else{
        	System.out.println("la photo est null");	
        	
        	Chantier leChantier = SiteService.getInstance().getChantier(id);
            
            String urlString = leChantier.getUrl_photo();
        	      	
        	
        	Chantier ch = new Chantier(id, ville, cp, null, mo, client, titre, mission, urlString );
    		
    		SiteService.getInstance().updateChantier(ch);
        }
		resp.setCharacterEncoding("UTF8");
		resp.sendRedirect("adm-modifmsg");
	}

}
