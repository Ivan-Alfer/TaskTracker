package by.home.service;

import org.springframework.security.core.userdetails.UserDetailsService;

import by.home.entity.User;
import by.home.service.exception.ServiceException;

public interface UserService extends UserDetailsService{

	void registrationUser(User user) throws ServiceException;
	
	User getUser(String email) throws ServiceException;
}
