package gameDemo.business.abstracts;

import gameDemo.entities.concretes.Campaign;
import gameDemo.entities.concretes.Game;

public interface CampaignService {
	
	void add(Campaign campaign, Game game);
	void update(Campaign campaign, Game game);
	void delete(Campaign campaign, Game game);

}
