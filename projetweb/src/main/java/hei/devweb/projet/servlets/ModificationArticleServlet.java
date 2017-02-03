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
 * Servlet implementation class ModificationServlet
 */
@WebServlet("/modification")
public class ModificationArticleServlet extends AbstractGenericServlet {
	private static final long serialVersionUID = 1L;
      
	/**
	 * @see HttpServlet#doGet(HttpServletRequest req, HttpServletResponse resp)
	 */
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		Integer idArticle = Integer.parseInt(req.getParameter("art"));
		resp.setCharacterEncoding("UTF8");
		TemplateEngine templateEngine = this.createTemplateEngine(req);
		
		WebContext context = new WebContext(req, resp, req.getServletContext());
		context.setVariable("article", BlogService.getInstance().getArticle(idArticle));
		
		templateEngine.process("modification", context, resp.getWriter());
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		Integer idArticle = Integer.parseInt(req.getParameter("id"));
		Float prix = Float.parseFloat(req.getParameter("prix"));
		String marque = req.getParameter("marque");
		String lien = req.getParameter("lien");
		
		BlogService.getInstance().updateArticle(idArticle, prix, marque, lien);
		resp.setCharacterEncoding("UTF8");
		resp.sendRedirect("liste");
	}


}
