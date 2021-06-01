package gameDemo.dataAccess.abstracts;

import gameDemo.entities.concretes.Campaign;
import gameDemo.entities.concretes.Game;

public interface CampaignDao {

	void add(Campaign campaign, Game game);
	void update(Campaign campaing, Game game);
	void delete(Campaign campaign, Game game);
	
}
