package hei.projet.vrd.servlets;

import java.io.IOException;
import java.util.Calendar;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.thymeleaf.TemplateEngine;
import org.thymeleaf.context.WebContext;
import hei.projet.vrd.services.SiteService;
import hei.projet.vrd.entities.envoiMessage;


@WebServlet("/contact")
public class contactServlet extends AbstractGenericServlet {
	private static final long serialVersionUID = 1L;
	private boolean error;
	/**
	 * @see HttpServlet#doGet(HttpServletRequest req, HttpServletResponse resp)
	 */
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		resp.setCharacterEncoding("UTF-8");
		Integer id = 1;

		TemplateEngine templateEngine =this.createTemplateEngine(req);
		
		WebContext context = new WebContext(req, resp, req.getServletContext());
		if(error){
			context.setVariable("envoiError", "Les champs saisis sont incorrects, l'envoi n'a pas pu etre effectué");
		}
		context.setVariable("coordonnees", SiteService.getInstance().getCoordonnees(id));
		Calendar c = Calendar.getInstance();
		int year = c.get(Calendar.YEAR);
		context.setVariable("annee", year);
		templateEngine.process("contact", context, resp.getWriter());
	}
	
	    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	        // reads form fields
	        String email = request.getParameter("mail");
	        String message = request.getParameter("msg");
	        String prenom = request.getParameter("prenom");
	        String nom = request.getParameter("nom");
	        String telephone = request.getParameter("telephone");
	        			
			email = email.replace(" ", "");
			prenom = prenom.replace(" ", "");
	        nom = nom.replace(" ", "");
	        telephone = telephone.replace(" ", "");
	        String checkMessage = message.replaceAll(" ", "");
	        
				envoiMessage.main(email, message, prenom, nom, telephone);
				
				response.sendRedirect("msg-ok");
			
			}
			
	    }
	      
}
