package gameDemo.dataAccess.abstracts;


import java.util.List;

import gameDemo.entities.concretes.Game;

public interface GameDao {

	void add(Game game);
	void update(Game game);
	void delete(Game game);
	Game get(int id);
	List<Game> getAll();
	
}
