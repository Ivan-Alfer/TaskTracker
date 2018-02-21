package by.home.service.impl;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

import by.home.dao.UserDAO;
import by.home.dao.exception.DaoException;
import by.home.entity.User;
import by.home.service.UserService;
import by.home.service.exception.ServiceException;

@Component
public class UserServiceImpl implements UserService{

	@Autowired
	private UserDAO userDao;
	
	@Override
	public void registrationUser(User user) throws ServiceException  {
		try {
			userDao.registrationUser(user);
		} catch (DaoException e) {
			throw new ServiceException("Something happend in DAO");
		}
		
	}

	
	
	@Override
	public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
		User activeUser = null;
		try {
			activeUser = userDao.getUserByEmail(email);
		} catch (DaoException e) {
			e.printStackTrace();
		}
		String role = activeUser.getUserRole().getRole();
		String password = activeUser.getPassword();
		GrantedAuthority authority = new SimpleGrantedAuthority(role);
		UserDetails userDetails = (UserDetails) new org.springframework.security.core.userdetails.User(email, password, Arrays.asList(authority));
		
		return userDetails;
	}



	@Override
	public User getUser(String email) throws ServiceException {
		User user = null;
		try {
			user = userDao.getUserByEmail(email);
		} catch (DaoException e) {
			throw new ServiceException("Something happend in DAO");
		}
		return user;
	}



}
