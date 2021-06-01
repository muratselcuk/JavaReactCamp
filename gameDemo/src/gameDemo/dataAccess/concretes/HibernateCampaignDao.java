package gameDemo.dataAccess.concretes;

import gameDemo.dataAccess.abstracts.CampaignDao;
import gameDemo.entities.concretes.Campaign;
import gameDemo.entities.concretes.Game;

public class HibernateCampaignDao implements CampaignDao {

	@Override
	public void add(Campaign campaign, Game game) {
		
		System.out.println("Hibernate ile kampanya tanımlandı. Oyun: "+ game.getName()+" Kampanya "+ campaign.getName()); 
		
	}

	@Override
	public void delete(Campaign campaign, Game game) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void update(Campaign campaing, Game game) {
		// TODO Auto-generated method stub
		
	}
	

}
