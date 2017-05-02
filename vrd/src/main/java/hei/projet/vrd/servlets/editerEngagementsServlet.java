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

@WebServlet("/adm-engagement")
public class editerEngagementsServlet extends AbstractGenericServlet {
	private static final long serialVersionUID = 1L;
      
	/**
	 * @see HttpServlet#doGet(HttpServletRequest req, HttpServletResponse resp)
	 */
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		resp.setCharacterEncoding("UTF-8");
		Integer id = Integer.parseInt(req.getParameter("e"));
		TemplateEngine templateEngine =this.createTemplateEngine(req);
		WebContext context = new WebContext(req, resp, req.getServletContext());
		context.setVariable("editerEngagement", SiteService.getInstance().getEngagements(id));
		context.setVariable("coordonnees", SiteService.getInstance().getCoordonnees(1));
		templateEngine.process("editer-engagement", context, resp.getWriter());
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		Integer idEngagement = Integer.parseInt(req.getParameter("id"));
		String description = req.getParameter("presentation");
		
		SiteService.getInstance().updateEngagements(idEngagement, description);
		resp.setCharacterEncoding("UTF8");
		resp.sendRedirect("adm-modifmsg");
	}

}
