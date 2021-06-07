package javacamp.northwind.business.concretes;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javacamp.northwind.business.abstracts.UserService;
import javacamp.northwind.core.dataAccess.UserDao;
import javacamp.northwind.core.entities.User;
import javacamp.northwind.core.utilities.results.DataResult;
import javacamp.northwind.core.utilities.results.Result;
import javacamp.northwind.core.utilities.results.SuccessDataResult;
import javacamp.northwind.core.utilities.results.SuccessResult;

@Service
public class UserManager implements UserService{

	private UserDao userDao;
	
	@Autowired
	public UserManager(UserDao userDao) {
		super();
		this.userDao = userDao;
	}

	@Override
	public Result add(User user) {
		this.userDao.save(user);
		return new SuccessResult("Kullanici eklendi.");
	}

	@Override
	public DataResult<User> findByEmail(String email) {
		return new SuccessDataResult<User>(this.userDao.findByEmail(email), "Kullanici bulundu.");
	}

}
