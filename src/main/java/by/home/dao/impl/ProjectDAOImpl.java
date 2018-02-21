package by.home.dao.impl;

import java.util.ArrayList;
import java.util.List;


import org.hibernate.Session;
import org.springframework.stereotype.Component;

import by.home.dao.ProjectDAO;
import by.home.dao.exception.DaoException;
import by.home.entity.Project;

@Component
public class ProjectDAOImpl implements ProjectDAO{

	protected Session session;

	public ProjectDAOImpl() {
		session = HibernateUtil.getSessionFactory().openSession();
	}
	
	
	@Override
	public void addNewProject(Project project) throws DaoException{
		try {
			session.beginTransaction();
			session.save(project);
		} catch (Exception e) {
			throw new DaoException("Database server not responding. Entity not added");
		}finally{
			session.getTransaction().commit();
		}
	}


	@Override
	public List<Project> getProjects(Integer userId) throws DaoException {
		List<Project> projects = new ArrayList<Project>();
		try {
			session = HibernateUtil.getSessionFactory().openSession();
			projects = session.createQuery("from Project where manager_id = :id", Project.class).setParameter("id", userId).list();
		} catch (Exception e) {
			e.printStackTrace();
			e.getMessage();
			throw new DaoException("Database server not responding");
		}
		return projects;
	}

	

}
