package by.home.service;

import java.util.List;

import by.home.entity.Project;
import by.home.service.exception.ServiceException;

public interface ProjectService {

	void addNewProject(Project project) throws ServiceException;
	
	List<Project> getProjects(Integer userId) throws ServiceException;
}
