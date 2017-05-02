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


/**
 * Servlet implementation class ListeServlet
 */
@WebServlet("/engagements")
public class engagementsServlet extends AbstractGenericServlet {
	private static final long serialVersionUID = 1L;
      
	/**
	 * @see HttpServlet#doGet(HttpServletRequest req, HttpServletResponse resp)
	 */
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		resp.setCharacterEncoding("UTF8");
		
		Integer id = Integer.parseInt(req.getParameter("eng"));
		
		TemplateEngine templateEngine = this.createTemplateEngine(req);
		
		WebContext context = new WebContext(req, resp, getServletContext());
		context.setVariable("coordonnees", SiteService.getInstance().getCoordonnees(1));
		context.setVariable("engagements", SiteService.getInstance().getEngagements(id));
		
		Calendar c = Calendar.getInstance();
		int year = c.get(Calendar.YEAR);
		context.setVariable("annee", year);
		
		templateEngine.process("engagements", context, resp.getWriter());
	}

}