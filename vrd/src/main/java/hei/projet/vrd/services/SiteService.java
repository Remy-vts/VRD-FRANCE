package hei.projet.vrd.services;

import java.io.IOException;
import java.util.List;
import javax.servlet.http.Part;
import hei.projet.vrd.dao.impl.AccueilDaoImpl;
import hei.projet.vrd.dao.impl.ChantierDaoImpl;
import hei.projet.vrd.dao.impl.ChiffresDaoImpl;
import hei.projet.vrd.dao.impl.CoordonneesDaoImpl;
import hei.projet.vrd.dao.impl.DirigeantDaoImpl;
import hei.projet.vrd.dao.impl.EngagementsDaoImpl;
import hei.projet.vrd.dao.impl.GroupeDaoImpl;
import hei.projet.vrd.dao.impl.MetierDaoImpl;
import hei.projet.vrd.dao.impl.OffreDaoImpl;
import hei.projet.vrd.dao.impl.PresseDaoImpl;
import hei.projet.vrd.entities.Accueil;
import hei.projet.vrd.entities.Chantier;
import hei.projet.vrd.entities.Chiffres;
import hei.projet.vrd.entities.Coordonnees;
import hei.projet.vrd.entities.Dirigeant;
import hei.projet.vrd.entities.Engagements;
import hei.projet.vrd.entities.Groupe;
import hei.projet.vrd.entities.Metier;
import hei.projet.vrd.entities.Offre;
import hei.projet.vrd.entities.Presse;


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
	private PresseDaoImpl presseDao = new PresseDaoImpl();
	private DirigeantDaoImpl dirigeantDao = new DirigeantDaoImpl();
	private EngagementsDaoImpl engagementsDao = new EngagementsDaoImpl();
	private GroupeDaoImpl groupeDao = new GroupeDaoImpl();
	private MetierDaoImpl metierDao = new MetierDaoImpl();
	private OffreDaoImpl offreDao = new OffreDaoImpl();
	private CoordonneesDaoImpl coordonneesDao = new CoordonneesDaoImpl();
	private ChiffresDaoImpl chiffreDao = new ChiffresDaoImpl();
	private AccueilDaoImpl accueilDao = new AccueilDaoImpl();
	
	public List<Dirigeant> listDirigeant(){
		return dirigeantDao.listDirigeant();
	}
	
	public Dirigeant getDirigeant(Integer id){
		return dirigeantDao.getDirigeant(id);
	}
	
	public void updateDirigeant(Dirigeant dir){
		dirigeantDao.updateDirigeant(dir);
	}
	
	public Dirigeant addDirigeant(Dirigeant dirigeant){
		return dirigeantDao.addDirigeant(dirigeant);
	}

	public void deleteDirigeant(Integer id){
		dirigeantDao.deleteDirigeant(id);
	}
	
	public List<Engagements> listEngagements(){
		return engagementsDao.listEngagements();
	}
	
	public Engagements getEngagements(Integer id){
		return engagementsDao.getEngagements(id);
	}
	
	public void updateEngagements(Integer idengagements, String description){
		engagementsDao.updateEngagements(idengagements, description);
	}
	
	public List<Groupe> listGroupe(){
		return groupeDao.listGroupe();
	}
	
	public Groupe getGroupe(Integer id){
		return groupeDao.getGroupe(id);
	}
	
	public void updateGroupe(Integer id, String description){
		groupeDao.updateGroupe(id, description);
	}
	
	public List<Chantier>  listChantier(){
		return chantierDao.listChantier();
	}
	
	public List<Chantier>  listChantierAccueil(){
		return chantierDao.listChantierAccueil();
	}

	public Chantier getChantier(Integer id){
		return chantierDao.getChantier(id);
	}
	
	public void updateChantier(Integer id, String titre, String ville, Integer code_postal, String maitre_ouvrage, String client, String description, String photo){
		chantierDao.updateChantier(id, titre, ville, code_postal,  maitre_ouvrage, client, description, photo);
	}
			
	public Chantier addChantier(Chantier chantier, Part picture) throws IOException{
								
		return chantierDao.addChantier(chantier, "https://s3.eu-west-2.amazonaws.com/vrdfrance/"+picture.getSubmittedFileName());
	}

	public void deleteChantier(Integer id){
		chantierDao.deleteChantier(id);
	}
	
	public List<Presse>  listPresse(){
		return presseDao.listPresse();
	}

	public Presse getPresse(Integer id){
		return presseDao.getPresse(id);
	}
	
	public void updatePresse(Integer ID_presse, String nom_media, String lien, String titre, String description, String chemin){
		presseDao.updatePresse(ID_presse, nom_media, lien, titre, description, chemin);
	}
	
	public Presse addPresse(Presse presse, Part picture) throws IOException{
		return presseDao.addPresse(presse, "https://s3.eu-west-2.amazonaws.com/vrdfrance/"+picture.getSubmittedFileName());
	}

	public void deletePresse(Integer id){
		presseDao.deletePresse(id);
	}
	
	public List<Metier>  listMetier(){
		return metierDao.listMetier();
	}

	public Metier getMetier(Integer idMetier){
		return metierDao.getMetier(idMetier);
	}
	
	public void deleteMetier(Integer id){
		metierDao.deleteMetier(id);
	}
	
	public Metier addMetier(Metier metier){
		return metierDao.addMetier(metier);
	}
	
	public void updateMetier(Integer idMetier, String descriptif, String photo){
		metierDao.updateMetier(idMetier, descriptif, photo);
	}
	
	public List<Offre>  listOffre(){
		return offreDao.listOffre();
	}

	public Offre getOffre(Integer id){
		return offreDao.getOffre(id);
	}
	
	public void updateOffre(Integer idOffre, String referenceOffre, String titreOffre, String missionOffre){
		offreDao.updateOffre(idOffre, referenceOffre, titreOffre, missionOffre);
	}
	
	public Offre addOffre(Offre offre){
		return offreDao.addOffre(offre);
	}
	
	public void deleteOffre(Integer id){
		offreDao.deleteOffre(id);
	}
	
	public Coordonnees getCoordonnees(Integer id){
		return coordonneesDao.getCoordonnees(id);
	}
	
	public void updateCoordonnees(String mail, String telephone){
		coordonneesDao.updateCoordonnees(mail, telephone);
	}
	
	public List<Chiffres> listChiffres(){
		return chiffreDao.listChiffres();
	}
	
	public Chiffres getChiffres(Integer id){
		return chiffreDao.getChiffres(id);
	}
	
	public void updateChiffres(Integer id,  String titre, Integer chiffre){
		chiffreDao.updateChiffres(id, titre, chiffre);
	}
	
	public List<Accueil>  listPhoto(){
		return accueilDao.listPhoto();
	}
		
	public Accueil getPhoto(Integer id){
		return accueilDao.getPhoto(id);
	}
	
	public void updatePhoto(Integer id, String photo1, String photo2, String photo3, String photo4, String photo5, String photo6, String photo7, String photo8){
		accueilDao.updatePhoto(id, photo1, photo2, photo3, photo4, photo5, photo6, photo7, photo8);
	}
			
	public Accueil addPhoto(Accueil accueil, Part picture1, Part picture2, Part picture3, Part picture4, Part picture5, Part picture6, Part picture7, Part picture8) throws IOException{
								
		return accueilDao.addPhoto(
				accueil, 
				"https://s3.eu-west-2.amazonaws.com/vrdfrance/"+picture1.getSubmittedFileName(),
				"https://s3.eu-west-2.amazonaws.com/vrdfrance/"+picture2.getSubmittedFileName(),
				"https://s3.eu-west-2.amazonaws.com/vrdfrance/"+picture3.getSubmittedFileName(),
				"https://s3.eu-west-2.amazonaws.com/vrdfrance/"+picture4.getSubmittedFileName(),
				"https://s3.eu-west-2.amazonaws.com/vrdfrance/"+picture5.getSubmittedFileName(),
				"https://s3.eu-west-2.amazonaws.com/vrdfrance/"+picture6.getSubmittedFileName(),
				"https://s3.eu-west-2.amazonaws.com/vrdfrance/"+picture7.getSubmittedFileName(),
				"https://s3.eu-west-2.amazonaws.com/vrdfrance/"+picture8.getSubmittedFileName());
	}

	
}
