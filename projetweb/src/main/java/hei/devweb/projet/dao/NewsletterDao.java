package hei.devweb.projet.dao;

import java.util.List;

import hei.devweb.projet.entities.Newsletter;

public interface NewsletterDao {
	
	public List<Newsletter> listNewsletters();

	public Newsletter getNewsletter(Integer id);

	public Newsletter addNewsletter(String mail);
	
}
