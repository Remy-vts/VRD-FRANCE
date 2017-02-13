package hei.projet.vrd.services;

import java.io.IOException;
import java.net.URISyntaxException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

import hei.projet.vrd.dao.ChantierDao;
import hei.projet.vrd.dao.impl.ChantierDaoImpl;
import hei.projet.vrd.entities.Chantier;


public class ChantierLibrary {
	private static final String PICTURE_MAIN_DIRECTORY = "D:/Documents/HEI/ITI 2016-2017/Dev Web/Projet Dev Web - KRESTYANINOV/data";

	private static class ChantierLibraryHolder{
		private final static ChantierLibrary instance = new ChantierLibrary();
	}
	
	public static ChantierLibrary getInstance(){
		return ChantierLibraryHolder.instance;
	}
	
	private ChantierDao ChantierDao = new ChantierDaoImpl();
	
	
	private ChantierLibrary(){
		
	}
	

	public List<Chantier> listArticle() {
		return ChantierDao.listChantier();
	}

	public Chantier getChantier(Integer id) {
		return ChantierDao.getChantier(id);
	}

	public void updateChantier(Integer id, String ville, int code_postal, String date_chantier, String maitre_ouvrage, String client, String titre, String description, String url_photo) throws IOException
	{
		ChantierDao.updateChantier(id, ville, code_postal, date_chantier, maitre_ouvrage, client, titre, description, url_photo);
		
	}
	
	public Path getPhotoPath(Integer id){
		String photoPathString = ChantierDao.getPhotoPath(id);
		if(photoPathString==null){
			return getDefaultPhotoPath();
		}else{
			Path photoPath = Paths.get(ChantierDao.getPhotoPath(id));
			if(Files.exists(photoPath)){
				return photoPath;
			}else{
				return getDefaultPhotoPath();
			}
		}
		
	}
	
	private Path getDefaultPhotoPath(){
		try{
			return Paths.get(this.getClass().getClassLoader().getResource("photo-no-article.jpg").toURI());
		} catch(URISyntaxException e){
			return null;
		}
	}
	
	
	
	

}

