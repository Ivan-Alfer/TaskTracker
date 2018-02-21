package by.home.dao;

import by.home.dao.exception.DaoException;
import by.home.entity.User;

public interface UserDAO {

	void registrationUser(User user) throws DaoException;
	
	User getUserByEmail(String email) throws DaoException;
}
