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
import hei.projet.vrd.entities.ImageS3Util;
import hei.projet.vrd.entities.Metier;
import hei.projet.vrd.services.SiteService;

@WebServlet("/adm-metier")
@MultipartConfig
public class editerMetierServlet extends AbstractGenericServlet {
	private static final long serialVersionUID = 1L;
      
	/**
	 * @see HttpServlet#doGet(HttpServletRequest req, HttpServletResponse resp)
	 */
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		resp.setCharacterEncoding("UTF-8");
		Integer id = Integer.parseInt(req.getParameter("m"));
		TemplateEngine templateEngine =this.createTemplateEngine(req);
		WebContext context = new WebContext(req, resp, req.getServletContext());
		context.setVariable("metier", SiteService.getInstance().getMetier(id));
		context.setVariable("coordonnees", SiteService.getInstance().getCoordonnees(1));
		Calendar c = Calendar.getInstance();
		int year = c.get(Calendar.YEAR);
		context.setVariable("annee", year);
		templateEngine.process("editer-metier", context, resp.getWriter());
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		Integer idMetier = Integer.parseInt(req.getParameter("idMetier"));
		String description = req.getParameter("description");
		Part photo = req.getPart("photo");
		
		if(photo.getSize() != 0)
		{
		ImageS3Util.uploadImageToAWSS3(photo, "metier-"+idMetier.toString());
				
		Metier met = new Metier(idMetier,null, "https://s3.eu-west-2.amazonaws.com/vrdfrance/metier-"+idMetier.toString(), description);
		
		SiteService.getInstance().updateMetier(met);
				
		resp.setCharacterEncoding("UTF8");
		resp.sendRedirect("adm-modifmsg");
		
		}else{
        	System.out.println("la photo est null");	
        	
        	Metier leMetier = SiteService.getInstance().getMetier(idMetier);
            
            String urlString = leMetier.getPhotoMetier();
        	     	
        	Metier met = new Metier(idMetier,null, urlString, description);
    		
    		SiteService.getInstance().updateMetier(met);
    		resp.setCharacterEncoding("UTF8");
    		resp.sendRedirect("adm-modifmsg");
        }
		
	}

}
