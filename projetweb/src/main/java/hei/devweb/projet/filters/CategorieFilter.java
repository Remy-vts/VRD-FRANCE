package hei.devweb.projet.filters;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;

import hei.devweb.projet.services.BlogService;

@WebFilter("/categorie")
public class CategorieFilter implements Filter{

	@Override
	public void init(FilterConfig filterConfig) throws ServletException {
	}

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		Integer idCategorie = Integer.parseInt(request.getParameter("c"));
		request.setAttribute("categories", BlogService.getInstance().getCategorie(idCategorie));
		
		chain.doFilter(request, response);	
	}

	@Override
	public void destroy() {
	}

}
