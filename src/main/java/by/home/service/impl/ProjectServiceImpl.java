package by.home.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import by.home.dao.ProjectDAO;
import by.home.dao.exception.DaoException;
import by.home.entity.Project;
import by.home.service.ProjectService;
import by.home.service.exception.ServiceException;

@Component
public class ProjectServiceImpl implements ProjectService{

	@Autowired
	ProjectDAO projectDao;
	
	@Override
	public void addNewProject(Project project) throws ServiceException {
		try {
			projectDao.addNewProject(project);
		} catch (DaoException e) {
			throw new ServiceException();
		}
		
	}

	@Override
	public List<Project> getProjects(Integer userId) throws ServiceException {
		List<Project> projects; 
		try {
			projects = projectDao.getProjects(userId);
		} catch (DaoException e) {
			throw new ServiceException();
		}
		return projects;
	}

}
