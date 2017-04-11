package hei.projet.vrd.servlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.thymeleaf.TemplateEngine;
import org.thymeleaf.context.WebContext;

import hei.projet.vrd.services.SiteService;

@WebServlet("/adm-mpresse")
public class modificationPresseServlet extends AbstractGenericServlet {
	private static final long serialVersionUID = 1L;
      
	/**
	 * @see HttpServlet#doGet(HttpServletRequest req, HttpServletResponse resp)
	 */
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		Integer id = Integer.parseInt(req.getParameter("p"));
		resp.setCharacterEncoding("UTF-8");
		TemplateEngine templateEngine =this.createTemplateEngine(req);
		WebContext context = new WebContext(req, resp, req.getServletContext());
		context.setVariable("presse", SiteService.getInstance().getPresse(id));
		templateEngine.process("modification-presse", context, resp.getWriter());
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		Integer idPresse = Integer.parseInt(req.getParameter("id"));
		String media = req.getParameter("media");
		String lien = req.getParameter("lien");
		String titre = req.getParameter("titre");
		String description = req.getParameter("content");
		
		SiteService.getInstance().updatePresse(idPresse, media,lien, titre, description);
		resp.setCharacterEncoding("UTF8");
		resp.sendRedirect("adm-modifmsg");
	}
	
	

}
