package by.home.dao;

import java.util.List;

import by.home.dao.exception.DaoException;
import by.home.entity.Task;

public interface TaskDAO {

	List<Task> getProjectTasks (Integer projectId) throws DaoException;
	
	void addNewTask(Task task) throws DaoException;
}
