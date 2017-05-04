package hei.projet.vrd.servlets;

import java.io.IOException;
import java.net.URISyntaxException;
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
import hei.projet.vrd.entities.envoiCandidature;
import hei.projet.vrd.services.SiteService;


@WebServlet("/offre")
@MultipartConfig
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
		context.setVariable("coordonnees", SiteService.getInstance().getCoordonnees(1));
		context.setVariable("groupe", SiteService.getInstance().getGroupe(6));
		Calendar c = Calendar.getInstance();
		int year = c.get(Calendar.YEAR);
		context.setVariable("annee", year);
		templateEngine.process("consulter-offre", context, resp.getWriter());
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String nom = req.getParameter("nom");
		String prenom = req.getParameter("prenom");
		String mail = req.getParameter("mail");
		String telephone = req.getParameter("telephone");		
		Part cv = req.getPart("cv");
		String message = req.getParameter("message");
		String referenceNom = req.getParameter("offre");
		
		String nomFichier = cv.getSubmittedFileName();
		String nomFishieNoWhiteSpace = nomFichier.replaceAll("\\s", "");;
		System.out.println("nomFichier "+nomFishieNoWhiteSpace);
		
		String nomCV = referenceNom+"-"+nom+"-"+prenom+"-"+nomFishieNoWhiteSpace;
		
		System.out.println("nomCV"+nomCV);
		ImageS3Util.uploadImageToAWSS3(cv, nomCV);
		
		String gRecaptchaResponse = req.getParameter("g-recaptcha-response");
		boolean verify = VerifyRecaptcha.verify(gRecaptchaResponse);
		
		String checkMessage = message.replaceAll(" ", "");
		
		if(mail!=null && !"".equals(mail) && prenom!=null && !"".equals(prenom) && nom!=null && !"".equals(nom) && telephone!=null && !"".equals(telephone) && !"".equals(checkMessage) && verify){
			envoiMessage.main(mail, message, prenom, nom, telephone);
			System.out.println("youpi");
		}
		
		try {
			envoiCandidature.main(nom, prenom, mail, telephone, nomCV, message, referenceNom, referenceNom);
		} catch (URISyntaxException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		resp.sendRedirect("candidature-msg");

}
}
