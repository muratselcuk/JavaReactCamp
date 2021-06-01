package gameDemo.business.concretes;

import gameDemo.business.abstracts.CampaignService;
import gameDemo.dataAccess.abstracts.CampaignDao;
import gameDemo.entities.concretes.Campaign;
import gameDemo.entities.concretes.Game;

public class CampaignManager implements CampaignService{

	private CampaignDao campaignDao;
	
	public CampaignManager(CampaignDao campaignDao) {
		super();
		this.campaignDao = campaignDao;
	}

	@Override
	public void add(Campaign campaign, Game game) {
		
		this.campaignDao.add(campaign, game);
		
	}

	@Override
	public void update(Campaign campaign, Game game) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void delete(Campaign campaign, Game game) {
		// TODO Auto-generated method stub
		
	}
	
	

}
