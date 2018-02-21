package by.home.service;

import java.util.List;

import by.home.entity.Task;
import by.home.service.exception.ServiceException;

public interface TaskService {
	
	List<Task> getProjectTasks(Integer projectId) throws ServiceException;

	void addNewTask(Task task) throws ServiceException;
}
