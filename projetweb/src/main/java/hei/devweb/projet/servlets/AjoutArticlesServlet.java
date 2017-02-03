package hei.devweb.projet.servlets;

import java.io.IOException;
import java.text.SimpleDateFormat;
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

import hei.devweb.projet.entities.Article;
import hei.devweb.projet.entities.Categorie;
import hei.devweb.projet.services.BlogService;

/**
 * Servlet implementation class AjoutServlet
 */
@WebServlet("/ajout")
@MultipartConfig
public class AjoutArticlesServlet extends AbstractGenericServlet {
	private static final long serialVersionUID = 1L;
      
	/**
	 * @see HttpServlet#doGet(HttpServletRequest req, HttpServletResponse resp)
	 */
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		TemplateEngine templateEngine = this.createTemplateEngine(req);
		
		WebContext context = new WebContext(req, resp, req.getServletContext());
		context.setVariable("categories", BlogService.getInstance().listCategories());
		
		templateEngine.process("ajout", context, resp.getWriter());
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String marque = req.getParameter("marque");
		Float prix = Float.parseFloat(req.getParameter("prix"));
		String lien = req.getParameter("lien");
		String site = req.getParameter("site");
		
		Calendar cal = Calendar.getInstance();
		cal.add(Calendar.DATE, 1);
		SimpleDateFormat format1 = new SimpleDateFormat("dd/MM/YYYY hh:mm:ss");
		String date = format1.format(cal.getTime());
			
		Part photoArticle = req.getPart("photo");
		
		Integer idCategorie = Integer.parseInt(req.getParameter("categorie"));
		Categorie categorie = BlogService.getInstance().getCategorie(idCategorie);
		
		Article newArticle = new Article(
				null,
				date,
				marque, 
				prix,
				site,
				lien,
				categorie);
		BlogService.getInstance().addArticle(newArticle, photoArticle);
		resp.setCharacterEncoding("UTF8");
		resp.sendRedirect("liste");
		}

}
