package hei.projet.vrd.servlets;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Calendar;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.thymeleaf.TemplateEngine;
import org.thymeleaf.context.WebContext;

import hei.projet.vrd.entities.Offre;
import hei.projet.vrd.services.SiteService;

@WebServlet("/adm-carrieres")
public class editCarrieresServlet extends AbstractGenericServlet {
	private static final long serialVersionUID = 1L;
      
	/**
	 * @see HttpServlet#doGet(HttpServletRequest req, HttpServletResponse resp)
	 */
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		resp.setCharacterEncoding("UTF-8");
		TemplateEngine templateEngine =this.createTemplateEngine(req);
		WebContext context = new WebContext(req, resp, req.getServletContext());
		context.setVariable("coordonnees", SiteService.getInstance().getCoordonnees(1));
		context.setVariable("carrieres", SiteService.getInstance().listOffre());
		templateEngine.process("edit-carrieres", context, resp.getWriter());
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String ref = req.getParameter("ref");
		String poste = req.getParameter("poste");
		String mission = req.getParameter("desc-poste");
		
		Calendar cal = Calendar.getInstance();
		cal.add(Calendar.DATE, 1);
		SimpleDateFormat format1 = new SimpleDateFormat("dd/MM/YYYY");
		String date = format1.format(cal.getTime());
		
		Offre newOffre = new Offre(
				null,
				ref,
				date,
				poste,
				mission
				);
		
		SiteService.getInstance().addOffre(newOffre);
		resp.setCharacterEncoding("UTF8");
		resp.sendRedirect("adm-addmsg");
	}

}
