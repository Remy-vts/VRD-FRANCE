package hei.projet.vrd.servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import hei.projet.vrd.entities.Chiffres;
import hei.projet.vrd.services.SiteService;

@WebServlet("/adm-ch3")
public class ModifierChiffreTroisServlet extends AbstractGenericServlet {
	private static final long serialVersionUID = 1L;
	
	private boolean error;
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String titre = req.getParameter("titre3");
		Integer chiffre = Integer.parseInt(req.getParameter("chiffre3"));
		
		if(titre.length()<50 && chiffre<1000000){
			SiteService.getInstance().updateChiffres(new Chiffres(3, titre, chiffre));
			error = false;
		}else{
			error = true;
		}
		resp.setCharacterEncoding("UTF8");
		resp.sendRedirect("adm-accueil");
	}

}
