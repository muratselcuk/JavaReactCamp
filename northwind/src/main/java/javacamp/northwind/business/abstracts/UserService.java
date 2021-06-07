package javacamp.northwind.business.abstracts;

import javacamp.northwind.core.entities.User;
import javacamp.northwind.core.utilities.results.DataResult;
import javacamp.northwind.core.utilities.results.Result;

public interface UserService {

	Result add(User user);
	DataResult<User> findByEmail(String email);
}
