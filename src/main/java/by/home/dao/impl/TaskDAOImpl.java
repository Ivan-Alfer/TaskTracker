package by.home.dao.impl;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.springframework.stereotype.Component;

import by.home.dao.TaskDAO;
import by.home.dao.exception.DaoException;
import by.home.entity.Task;

@Component
public class TaskDAOImpl implements TaskDAO{
	
	protected Session session;

	public TaskDAOImpl() {
		session = HibernateUtil.getSessionFactory().openSession();
	}

	@Override
	public List<Task> getProjectTasks(Integer projectId) throws DaoException {
		List<Task> tasks = new ArrayList<Task>();
		try {
			session = HibernateUtil.getSessionFactory().openSession();
			tasks = session.createQuery("from Task where project_id = :id", Task.class).setParameter("id", projectId).list();
		} catch (Exception e) {
			e.printStackTrace();
			e.getMessage();
			throw new DaoException("Database server not responding");
		}
		return tasks;
	}

	@Override
	public void addNewTask(Task task) throws DaoException {
		try {
			session.beginTransaction();
			session.save(task);
		} catch (Exception e) {
			throw new DaoException("Database server not responding. Entity not added");
		}finally{
			session.getTransaction().commit();
		}
	}

}
