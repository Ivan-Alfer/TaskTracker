package by.home.dao.impl;


import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.springframework.stereotype.Component;

import by.home.dao.UserDAO;
import by.home.dao.exception.DaoException;
import by.home.entity.User;

@Component
public class UserDAOImpl implements UserDAO {

	protected Session session;

	public UserDAOImpl() {
		session = HibernateUtil.getSessionFactory().openSession();
	}



	@Override
	public void registrationUser(User user) throws DaoException {
		try {
			session.beginTransaction();
			session.save(user);
		} catch (Exception e) {
			throw new DaoException("Database server not responding. Entity not added");
		} finally {
			session.getTransaction().commit();
		}
	}



	@Override
	public User getUserByEmail(String email) throws DaoException {
	

			session.beginTransaction();
			
			
			List<User> users = new ArrayList<User>();
			users = session.createQuery("from User where email = :email", User.class).setParameter("email", email).list();
			if (users.size() > 0) {
				return users.get(0);
			} else {
				return null;
			}
			
		/*	CriteriaBuilder builder = session.getCriteriaBuilder();
			Root<Department> root = query.from(Department.class);
			
			user = session.createCriteria(User.class).add(Restrictions.eq("email", email))
			Query query = session.createQuery("from User where email = :email");
			query.setParameter("email", email);
			query.getResultList()
			
		} catch (Exception e) {
			throw new DaoException("Database server not responding. Uset not found");
		} finally {
			session.getTransaction().commit();
		}
		return user;*/
	}
}
