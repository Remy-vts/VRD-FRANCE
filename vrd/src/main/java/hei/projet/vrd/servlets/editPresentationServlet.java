package hei.projet.vrd.servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


import hei.projet.vrd.entities.Groupe;
import hei.projet.vrd.services.SiteService;

@WebServlet("/adm-presentation")
public class editPresentationServlet extends AbstractGenericServlet {
	private static final long serialVersionUID = 1L;
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		Integer id = Integer.parseInt(req.getParameter("idGroupe"));
		String description = req.getParameter("description");
		
		Groupe gr = new Groupe(id, description);
		
		SiteService.getInstance().updateGroupe(gr);
		resp.setCharacterEncoding("UTF8");
		resp.sendRedirect("adm-modifmsg");
	}

}
