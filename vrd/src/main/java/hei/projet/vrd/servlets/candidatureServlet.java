package hei.projet.vrd.servlets;

import java.io.IOException;
import java.net.URISyntaxException;
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
import hei.projet.vrd.entities.envoiCandidature;

@WebServlet("/candidature-s")
@MultipartConfig
public class candidatureServlet extends AbstractGenericServlet {
	private static final long serialVersionUID = 1L;
      
	/**
	 * @see HttpServlet#doGet(HttpServletRequest req, HttpServletResponse resp)
	 */
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		resp.setCharacterEncoding("UTF-8");
		
		TemplateEngine templateEngine =this.createTemplateEngine(req);
		
		WebContext context = new WebContext(req, resp, req.getServletContext());
			
		templateEngine.process("candidature-s", context, resp.getWriter());
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String nom = req.getParameter("nom");
		String prenom = req.getParameter("prenom");
		String mail = req.getParameter("mail");
		String telephone = req.getParameter("telephone");		
		Part cv = req.getPart("cv");
		String message = req.getParameter("message");
		
		String nomFichier = cv.getSubmittedFileName();
		String nomFishieNoWhiteSpace = nomFichier.replaceAll("\\s", "");;
		System.out.println("nomFichier "+nomFishieNoWhiteSpace);
		
		String nomCV = "Candidature Spontanée-"+nom+"-"+prenom+"-"+nomFishieNoWhiteSpace;
		
		System.out.println("nomCV"+nomCV);
		ImageS3Util.uploadImageToAWSS3(cv, nomCV);
		
		
		try {
			envoiCandidature.main(nom, prenom, mail, telephone, nomCV, message, null, "Candidature Spontanée");
		} catch (URISyntaxException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		resp.sendRedirect("candidature-msg");
		
		
	}

}


