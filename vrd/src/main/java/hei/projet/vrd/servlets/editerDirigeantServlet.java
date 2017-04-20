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
import hei.projet.vrd.entities.Dirigeant;
import hei.projet.vrd.entities.ImageS3Util;
import hei.projet.vrd.services.SiteService;

@WebServlet("/adm-mdir")
@MultipartConfig
public class editerDirigeantServlet extends AbstractGenericServlet {
	private static final long serialVersionUID = 1L;
      
	/**
	 * @see HttpServlet#doGet(HttpServletRequest req, HttpServletResponse resp)
	 */
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		resp.setCharacterEncoding("UTF-8");
		Integer id = Integer.parseInt(req.getParameter("dir"));
		TemplateEngine templateEngine =this.createTemplateEngine(req);
		
		WebContext context = new WebContext(req, resp, req.getServletContext());
		context.setVariable("dirigeant", SiteService.getInstance().getDirigeant(id));
		
		templateEngine.process("adm-mdirigeant", context, resp.getWriter());
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		Integer id = Integer.parseInt(req.getParameter("iddir"));
		String fonction = req.getParameter("fonctiondir");
		String presentation = req.getParameter("presentationdir");
		Part photo = req.getPart("photodir");
		String nom = req.getParameter("name");
		
		
		
		LocalDate localDate = LocalDate.now();
		String date =DateTimeFormatter.ofPattern("yyy/MM/dd").format(localDate);
        System.out.println(date);	
        System.out.println(nom);	
        
        
        
		String chemin = "https://s3.eu-west-2.amazonaws.com/vrdfrance/dirigeant-"+date+"-"+id;
		ImageS3Util.uploadImageToAWSS3(photo, "dirigeant-"+date+"-"+id);
		
		Dirigeant dir = new Dirigeant (id, nom, fonction, presentation, chemin);
		
		SiteService.getInstance().updateDirigeant(dir);
				
		resp.setCharacterEncoding("UTF8");
		resp.sendRedirect("adm-modifmsg");
	}

}
