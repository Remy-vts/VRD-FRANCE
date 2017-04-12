package hei.projet.vrd.servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.thymeleaf.TemplateEngine;
import org.thymeleaf.context.WebContext;

import hei.projet.vrd.entities.Dirigeant;
import hei.projet.vrd.entities.Metier;
import hei.projet.vrd.services.SiteService;

@WebServlet("/adm-dir")
public class editDirigeantServlet extends AbstractGenericServlet {
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
		templateEngine.process("adm-dirigeant", context, resp.getWriter());
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String nom = req.getParameter("dirigeantnom");
		String fonction = req.getParameter("dirigeantfonction");
		String presentation = req.getParameter("dirigeantpresentation");
		String photo = req.getParameter("dirigeantphoto");
		
		Dirigeant newDirigeant = new Dirigeant(
				null,
				nom,
				fonction,
				presentation,
				photo
				);
		
		SiteService.getInstance().addDirigeant(newDirigeant);
		resp.setCharacterEncoding("UTF8");
		resp.sendRedirect("adm-addmsg");
	}

}
