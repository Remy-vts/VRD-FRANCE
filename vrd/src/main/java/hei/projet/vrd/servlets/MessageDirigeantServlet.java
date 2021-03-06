package hei.projet.vrd.servlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import hei.projet.vrd.entities.Groupe;
import hei.projet.vrd.services.SiteService;

@WebServlet("/adm-msgdir")
public class MessageDirigeantServlet extends AbstractGenericServlet {
	
	public boolean error2; 
	
	private static final long serialVersionUID = 1L;
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String mot = req.getParameter("mot-dirigeant");
		
		if(mot.length()<3000){
			error2=false;
			Groupe gr = new Groupe(4, mot);
			SiteService.getInstance().updateGroupe(gr);
			resp.setCharacterEncoding("UTF8");
			resp.sendRedirect("adm-modifmsg");
		}else{
			error2=true;
			System.out.println("ok");
			resp.sendRedirect("adm-accueil");
		}
	}

}
