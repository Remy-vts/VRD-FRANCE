package hei.devweb.projet.servlets;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import hei.devweb.projet.services.BlogService;

@WebServlet("/photoarticle")
public class PhotoArticleServlet extends AbstractGenericServlet{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		Integer idArticle = Integer.parseInt(req.getParameter("id"));
		Path photoPath = BlogService.getInstance().getPhotoPath(idArticle);
	
		Files.copy(photoPath, resp.getOutputStream());
	}
}
