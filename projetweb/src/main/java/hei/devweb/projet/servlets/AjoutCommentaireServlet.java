package hei.devweb.projet.servlets;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Calendar;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import hei.devweb.projet.entities.Article;
import hei.devweb.projet.entities.Commentaire;
import hei.devweb.projet.services.BlogService;

/**
 * Servlet implementation class ConsultationArticleServlet
 */
@WebServlet("/addCommentaire")
public class AjoutCommentaireServlet extends AbstractGenericServlet {
	
	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String nom = req.getParameter("nom");
		String commentaire = req.getParameter("commentaire");
		
		Calendar cal = Calendar.getInstance();
		cal.add(Calendar.DATE, 1);
		SimpleDateFormat format1 = new SimpleDateFormat("dd/MM/YYYY hh:mm:ss");
		String date = format1.format(cal.getTime());
		
		Integer idArticle = Integer.parseInt(req.getParameter("id"));
		Article article = BlogService.getInstance().getArticle(idArticle);
		
		Commentaire newCommentaire = new Commentaire(
				null,
				date,
				commentaire,
				nom,
				article);
		BlogService.getInstance().addCommentaire(newCommentaire);
		resp.setCharacterEncoding("UTF8");
		resp.sendRedirect("consultation?article="+idArticle);
	}
	
}
