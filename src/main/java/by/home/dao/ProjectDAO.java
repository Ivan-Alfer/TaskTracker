package by.home.dao;

import java.util.List;

import by.home.dao.exception.DaoException;
import by.home.entity.Project;

public interface ProjectDAO {
	
	void addNewProject(Project project) throws DaoException;

	List<Project> getProjects(Integer userId) throws DaoException;
}
