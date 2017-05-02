package hei.projet.vrd.servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.thymeleaf.TemplateEngine;
import org.thymeleaf.context.WebContext;

import hei.projet.vrd.services.SiteService;




@WebServlet("/qui-sommes-nous")
public class quiSommesNousServlet extends AbstractGenericServlet {
	private static final long serialVersionUID = 1L;
      
	/**
	 * @see HttpServlet#doGet(HttpServletRequest req, HttpServletResponse resp)
	 */
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		resp.setCharacterEncoding("UTF-8");
		
		TemplateEngine templateEngine =this.createTemplateEngine(req);
		
		WebContext context = new WebContext(req, resp, req.getServletContext());
		
		context.setVariable("dirigeants", SiteService.getInstance().listDirigeant());
		
		context.setVariable("actualites", SiteService.getInstance().listGroupe());
		context.setVariable("coordonnees", SiteService.getInstance().getCoordonnees(1));
		templateEngine.process("qui-sommes-nous", context, resp.getWriter());
	}

}
