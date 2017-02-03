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
 * Servlet implementation class CategorieServlet
 */
@WebServlet("/categorie")
public class CategorieServlet extends AbstractGenericServlet {
	private static final long serialVersionUID = 1L;
      
	/**
	 * @see HttpServlet#doGet(HttpServletRequest req, HttpServletResponse resp)
	 */
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setCharacterEncoding("UTF8");
		Integer idCategorie = Integer.parseInt(req.getParameter("c"));
		TemplateEngine templateEngine = this.createTemplateEngine(req);
		
		WebContext context = new WebContext(req, resp, req.getServletContext());
		context.setVariable("articles", BlogService.getInstance().listArticlesParCategorie(idCategorie));
		
		templateEngine.process("categorie", context, resp.getWriter());
	}

}
