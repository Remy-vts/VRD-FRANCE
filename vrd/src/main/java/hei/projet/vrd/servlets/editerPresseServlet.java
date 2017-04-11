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
import hei.projet.vrd.entities.ImageS3Util;
import hei.projet.vrd.entities.Presse;
import hei.projet.vrd.services.SiteService;

@WebServlet("/adm-presse")
@MultipartConfig
public class editerPresseServlet extends AbstractGenericServlet {
	private static final long serialVersionUID = 1L;
      
	/**
	 * @see HttpServlet#doGet(HttpServletRequest req, HttpServletResponse resp)
	 */
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		resp.setCharacterEncoding("UTF-8");
		
		TemplateEngine templateEngine =this.createTemplateEngine(req);
		
		WebContext context = new WebContext(req, resp, req.getServletContext());
		context.setVariable("presses", SiteService.getInstance().listPresse());
		templateEngine.process("editer-presse", context, resp.getWriter());
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String titre = req.getParameter("titre");
		String media = req.getParameter("media");
		String lien = req.getParameter("lien");
		String content = req.getParameter("content");
		Part photo = req.getPart("photo");
		
		Calendar cal = Calendar.getInstance();
		cal.add(Calendar.DATE, 1);
		SimpleDateFormat format1 = new SimpleDateFormat("dd/MM/YYYY hh:mm:ss");
		String date = format1.format(cal.getTime());
		
		Presse newPresse = new Presse(
				null,
				media,
				date,
				lien,
				titre,
				content,
				null
				);
		
		SiteService.getInstance().addPresse(newPresse, req.getPart("photo"));
				
		List <Presse> listPresse = SiteService.getInstance().listPresse();
		int taille = listPresse.size();	
		Presse lArticle = listPresse.get(taille-1);
				
		String id = lArticle.getID_presse().toString();
		System.out.println("id : "+id);
		String chemin = "https://s3.eu-west-2.amazonaws.com/vrdfrance/presse-"+id;
		ImageS3Util.uploadImageToAWSS3(photo, "presse-"+id);
		
		SiteService.getInstance().updatePresse(lArticle.getID_presse(), media, lien, titre, content, chemin);
		
		resp.setCharacterEncoding("UTF8");
		resp.sendRedirect("adm-addmsg");
		
	}

}
