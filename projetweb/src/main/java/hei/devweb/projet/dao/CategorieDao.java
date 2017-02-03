package hei.devweb.projet.dao;

import java.util.List;

import hei.devweb.projet.entities.Categorie;

public interface CategorieDao {

	public List<Categorie> listCategories();

	public Categorie getCategorie(Integer id);
	
	public Categorie addCategorie(String nom, String description);
	
}
