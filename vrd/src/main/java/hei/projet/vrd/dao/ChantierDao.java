package hei.projet.vrd.dao;

import java.util.List;

import hei.projet.vrd.entities.Element;


public interface ElementDao {

	public List<Element>  listElement();

	public Element getElement(Integer id);
	
	public void updateElement(Integer id, String url, String titre, String description);
	
	public Element addElement(Element element, String photoPath);

	public void deleteElement(Integer id);
	
}