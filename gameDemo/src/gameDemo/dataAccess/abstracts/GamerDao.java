package gameDemo.dataAccess.abstracts;


import gameDemo.entities.concretes.Campaign;
import gameDemo.entities.concretes.Game;
import gameDemo.entities.concretes.Gamer;

public interface GamerDao {

	void register(Gamer gamer);
	void update(Gamer gamer);
	void delete(Gamer gamer);
	void buyGame(Gamer gamer, Game game, Campaign campaign);

}
