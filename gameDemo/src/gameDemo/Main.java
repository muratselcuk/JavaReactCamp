package gameDemo;


import gameDemo.adapters.api.MernisAdapter;
import gameDemo.business.abstracts.CampaignService;
import gameDemo.business.abstracts.GameService;
import gameDemo.business.abstracts.GamerService;
import gameDemo.business.concretes.CampaignManager;
import gameDemo.business.concretes.GameManager;
import gameDemo.business.concretes.GamerManager;
import gameDemo.dataAccess.concretes.HibernateCampaignDao;
import gameDemo.dataAccess.concretes.HibernateGameDao;
import gameDemo.dataAccess.concretes.HibernateGamerDao;
import gameDemo.entities.concretes.Campaign;
import gameDemo.entities.concretes.Game;
import gameDemo.entities.concretes.Gamer;

public class Main {

	public static void main(String[] args) {

		//Test
		
		GameService gameService = new GameManager(new HibernateGameDao());
		Game game= new Game(1,2,"Fifa94","Efsane fifa versiyonu", 50);
		gameService.add(game);
		
		GamerService gamerService = new GamerManager(new HibernateGamerDao(), new MernisAdapter());
		
		Gamer gamer = new Gamer(1,"Murat", "Selçuk", 1900, "12345678901");
		gamerService.register(gamer);
		
		CampaignService campaignService = new CampaignManager(new HibernateCampaignDao());
		Campaign campaign = new Campaign(1,"Süper İndirim", 10);
		campaignService.add(campaign, game);
		
		gamerService.buyGame(gamer, game, campaign);
		
	}

}
