package hei.projet.vrd.dao;

import java.util.List;

import hei.projet.vrd.entities.Chiffres;


public interface ChiffresDao {

	public List<Chiffres>  listChiffres();
	
	public void updateChiffres(Integer id, String titre, Integer chiffre);

}