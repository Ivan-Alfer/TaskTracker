package by.home.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import by.home.dao.TaskDAO;
import by.home.dao.exception.DaoException;
import by.home.entity.Task;
import by.home.service.TaskService;
import by.home.service.exception.ServiceException;

@Component
public class TaskServiceImpl implements TaskService {

	@Autowired
	TaskDAO taskDao;

	@Override
	public List<Task> getProjectTasks(Integer projectId) throws ServiceException {
		List<Task> tasks = null;
		try {
			taskDao.getProjectTasks(projectId);
		} catch (DaoException e) {
			throw new ServiceException();
		}
		return tasks;
	}

	@Override
	public void addNewTask(Task task) throws ServiceException {
		try {
			taskDao.addNewTask(task);
		} catch (DaoException e) {
			throw new ServiceException();
		}
	}

}
