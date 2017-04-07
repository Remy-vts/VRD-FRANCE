package hei.projet.vrd.servlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import hei.projet.vrd.services.SiteService;

/**
 * Servlet implementation class AjoutServlet
 */
@WebServlet("/deleteDirigeant")
public class deleteDirigeant extends AbstractGenericServlet {

	private static final long serialVersionUID = 1L;
    
	/**
	 * @see HttpServlet#doGet(HttpServletRequest req, HttpServletResponse resp)
	 */
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		Integer id = Integer.parseInt(req.getParameter("d"));
		SiteService.getInstance().deleteDirigeant(id);
		resp.sendRedirect("adm-dir");
	}

}