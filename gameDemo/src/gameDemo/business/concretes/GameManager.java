package gameDemo.business.concretes;

import java.util.List;

import gameDemo.business.abstracts.GameService;
import gameDemo.dataAccess.abstracts.GameDao;
import gameDemo.entities.concretes.Game;

public class GameManager implements GameService {

	private GameDao gameDao;
	
	public GameManager(GameDao gameDao) {
		super();
		this.gameDao = gameDao;
	}

	@Override
	public void add(Game game) {
		
		if (game.getCategoryId()==1) {
			System.out.println("Bu kategoride oyun eklenemiyor");
			return;
			
		}
		
		this.gameDao.add(game);
		
	}

	@Override
	public List<Game> getAll() {
		// TODO Auto-generated method stub
		return null;
	}

}
