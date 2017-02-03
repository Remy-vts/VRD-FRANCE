package hei.devweb.projet.servlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import hei.devweb.projet.services.BlogService;

/**
 * Servlet implementation class AjoutServlet
 */
@WebServlet("/deleteArticle")
public class DeleteArticleServlet extends AbstractGenericServlet {

	private static final long serialVersionUID = 1L;
    
	/**
	 * @see HttpServlet#doGet(HttpServletRequest req, HttpServletResponse resp)
	 */
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		Integer idArticle = Integer.parseInt(req.getParameter("art"));
		BlogService.getInstance().deleteArticle(idArticle);
		resp.sendRedirect("liste");
	}

}