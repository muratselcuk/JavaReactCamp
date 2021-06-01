package gameDemo.business.concretes;

import gameDemo.adapters.service.GamerVerifyService;
import gameDemo.business.abstracts.GamerService;
import gameDemo.dataAccess.abstracts.GamerDao;
import gameDemo.entities.concretes.Campaign;
import gameDemo.entities.concretes.Game;
import gameDemo.entities.concretes.Gamer;

public class GamerManager implements GamerService {
	
	private GamerDao gamerDao;
	private GamerVerifyService gamerVerifyService;

	public GamerManager(GamerDao gamerDao, GamerVerifyService gamerVerifyService) {
		super();
		this.gamerDao = gamerDao;
		this.gamerVerifyService = gamerVerifyService;
	}

	@Override
	public void register(Gamer gamer) {
	
		if (gamerVerifyService.chekIfRealPerson(gamer)) {
			this.gamerDao.register(gamer);
		}
		else 
		{ System.out.println("Geçerli bir kişi değil");
		
		}
			
	}

	@Override
	public void update(Gamer gamer) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void delete(Gamer gamer) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void buyGame(Gamer gamer, Game game, Campaign campaign) {

		this.gamerDao.buyGame(gamer, game, campaign);
	}

}
