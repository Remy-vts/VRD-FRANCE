package hei.projet.vrd.dao;

import java.util.List;

import hei.projet.vrd.entities.Engagements;

public interface EngagementsDao {
	
	public List<Engagements> listEngagements();
	
	public Engagements getEngagements(Integer id);
	
	public void updateEngagements(Integer idengagements, String description);

}
