package gameDemo.dataAccess.concretes;


import gameDemo.dataAccess.abstracts.GamerDao;
import gameDemo.entities.concretes.Campaign;
import gameDemo.entities.concretes.Game;
import gameDemo.entities.concretes.Gamer;

public class HibernateGamerDao implements GamerDao{

	@Override
	public void register(Gamer gamer) {
		
		System.out.println("Hibernate ile Kayıt olundu: "+ gamer.getFirstName());
		
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
		
		System.out.println("Hibernate ile satın alındı oyuncu: "+ gamer.getFirstName()+" Oyun: "+game.getName()+" Kampanya: "+ campaign.getName());
		
	}


}
