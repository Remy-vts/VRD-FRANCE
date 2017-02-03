package hei.devweb.projet.servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.thymeleaf.TemplateEngine;
import org.thymeleaf.context.WebContext;

import hei.devweb.projet.services.BlogService;

/**
 * Servlet implementation class ConsultationArticleServlet
 */
@WebServlet("/consultation")
public class ConsultationArticleServlet extends AbstractGenericServlet {
	
	private static final long serialVersionUID = 1L;
      
	/**
	 * @see HttpServlet#doGet(HttpServletRequest req, HttpServletResponse resp)
	 */
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		resp.setCharacterEncoding("UTF8");
		Integer idArticle = Integer.parseInt(req.getParameter("article"));
		TemplateEngine templateEngine = this.createTemplateEngine(req);
		
		WebContext context = new WebContext(req, resp, getServletContext());
		context.setVariable("articles", BlogService.getInstance().getArticle(idArticle));
		
		templateEngine.process("consultation_article", context, resp.getWriter());
	}
	
}
