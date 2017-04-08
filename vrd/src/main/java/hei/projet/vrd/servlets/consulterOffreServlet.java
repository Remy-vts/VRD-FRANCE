package hei.projet.vrd.servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

import org.thymeleaf.TemplateEngine;
import org.thymeleaf.context.WebContext;
import org.thymeleaf.templatemode.TemplateMode;
import org.thymeleaf.templateresolver.ServletContextTemplateResolver;

import hei.projet.vrd.entities.ImageS3Util;
import hei.projet.vrd.entities.envoiCandidature;
import hei.projet.vrd.services.SiteService;


@WebServlet("/offre")
public class consulterOffreServlet extends AbstractGenericServlet {
	private static final long serialVersionUID = 1L;
      
	/**
	 * @see HttpServlet#doGet(HttpServletRequest req, HttpServletResponse resp)
	 */
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		resp.setCharacterEncoding("UTF-8");
		Integer id = Integer.parseInt(req.getParameter("o"));
		TemplateEngine templateEngine =this.createTemplateEngine(req);
		
		WebContext context = new WebContext(req, resp, req.getServletContext());
		context.setVariable("offre", SiteService.getInstance().getOffre(id));
			
		templateEngine.process("consulter-offre", context, resp.getWriter());
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String candidature = req.getParameter("offre");
		String nom = req.getParameter("nom");
		String prenom = req.getParameter("prenom");
		String mail = req.getParameter("mail");
		String telephone = req.getParameter("telephone");		
		Part cv = req.getPart("cv");
		Part lm = req.getPart("lm");
		
		String nomCV = "-candidature-"+nom+"-"+prenom+"-"+cv.getSubmittedFileName();
		System.out.println(nomCV);
		ImageS3Util.uploadImageToAWSS3(cv, nomCV);
		
		String nomLM = "-candidature-"+nom+"-"+prenom+"-"+lm.getSubmittedFileName();
		System.out.println(nomLM);
		ImageS3Util.uploadImageToAWSS3(lm, nomLM);
		
		envoiCandidature.main(nom, prenom, mail, telephone, nomCV, nomLM, reference, titreOffre);
		
		resp.sendRedirect("candidature-msg");

}
}