package hei.projet.vrd.services;

import java.util.List;

import hei.projet.vrd.dao.impl.ChantierDaoImpl;
import hei.projet.vrd.dao.impl.EngagementsDaoImpl;
import hei.projet.vrd.entities.Chantier;
import hei.projet.vrd.entities.Engagements;

public class SiteService {

	public static class SiteHolder{
		private static SiteService instance = new SiteService();
	}
	
	public static SiteService getInstance(){
		return SiteHolder.instance;
	}
	
	private SiteService() {
	}

	private ChantierDaoImpl chantierDao = new ChantierDaoImpl();
	private EngagementsDaoImpl engagementsDao = new EngagementsDaoImpl();
	
	public List<Engagements> listEngagements(){
		return engagementsDao.listEngagements();
	}
	
	public Engagements getEngagements(Integer id){
		return engagementsDao.getEngagements(id);
	}
	
	public void updateEngagements(Integer idengagements, String description){
		engagementsDao.updateEngagements(idengagements, description);
	}
	
	public List<Chantier>  listChantier(){
		return chantierDao.listChantier();
	}

	public Chantier getChantier(Integer id){
		return chantierDao.getChantier(id);
	}
	
	public void updateChantier(Integer id, String ville, int code_postal, String date_chantier, String maitre_ouvrage, String client, String titre, String description, String url_photo){
		chantierDao.updateChantier(id, ville, code_postal, date_chantier, maitre_ouvrage, client, titre, description, url_photo);
	}
	
	public Chantier addChantier(Chantier chantier, String photoPath){
		return chantierDao.addChantier(chantier, photoPath);
	}

	public void deleteChantier(Integer id){
		chantierDao.deleteChantier(id);
	}
}
