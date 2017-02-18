package hei.projet.vrd.servlets;

import java.io.IOException;
import java.security.NoSuchAlgorithmException;
import java.security.spec.InvalidKeySpecException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.thymeleaf.TemplateEngine;
import org.thymeleaf.context.WebContext;

@WebServlet("/connexion")
public class connexionServlet extends AbstractGenericServlet  {

	private static final long serialVersionUID = -1488650966375438002L;

	private Map<String, String> utilisateursAutorises;

	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setCharacterEncoding("UTF-8");
		TemplateEngine templateEngine =this.createTemplateEngine(req);
		WebContext context = new WebContext(req, resp, req.getServletContext());
		templateEngine.process("connexion", context, resp.getWriter());
	}
	
	@Override
	public void init() throws ServletException {
		utilisateursAutorises = new HashMap<>();
		utilisateursAutorises.put("root", "800021d85288c65bc1b697f8dfed4c865c367394ff823973:d084f770bf129a040c17ea3c96af91afe330de6d23ef061e");
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String identifiantSaisi = request.getParameter("identifiant");
		String motDePasseSaisi = request.getParameter("mdp");
		try {
			if(utilisateursAutorises.containsKey(identifiantSaisi) && MotDePasseUtils.validerMotDePasse(motDePasseSaisi, utilisateursAutorises.get(identifiantSaisi))) {
				request.getSession().setAttribute("utilisateurConnecte", identifiantSaisi);
			}
		} catch (NoSuchAlgorithmException | InvalidKeySpecException e) {
			e.printStackTrace();
		} 
		response.sendRedirect("admin");
	}

}