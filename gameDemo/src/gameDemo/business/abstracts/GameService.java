package gameDemo.business.abstracts;

import java.util.List;

import gameDemo.entities.concretes.Game;

public interface GameService {

	void add(Game game);
	List<Game> getAll();
}
