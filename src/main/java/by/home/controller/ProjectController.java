package by.home.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttribute;
import org.springframework.web.servlet.ModelAndView;

import by.home.entity.Project;
import by.home.entity.User;
import by.home.service.ProjectService;
import by.home.service.exception.ServiceException;

@Controller

public class ProjectController {

	@Autowired
	ProjectService projectService;
	
	@ModelAttribute("userDetails") 
	public User createUser(){
		return new User();
	}
	
	
	@RequestMapping(value = "/projects", method = RequestMethod.GET)
	public ModelAndView goToProjectsPage(@SessionAttribute("userDetails") User userDetails, HttpServletRequest req) {
		List<Project> projects = null;
		//User user = (User)SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		try {
			projects = projectService.getProjects(userDetails.getId());
		} catch (ServiceException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		ModelAndView mav = new ModelAndView("projects","projects", projects);
		return mav;
	}

	@RequestMapping(value = "/projects/new", method = RequestMethod.GET)
	public ModelAndView goToAddNewProjectPage(@SessionAttribute("userDetails") User user) {
		ModelAndView mav = new ModelAndView("newProject","project", new Project());
		return mav;
	}

	
	@RequestMapping(value = "/projects/new", method = RequestMethod.POST)
	public String addNewProject(@SessionAttribute("userDetails") User manager, @ModelAttribute("project") Project project, BindingResult result) {
		project.setManagerId(manager.getId());
		try {
			projectService.addNewProject(project);
		} catch (ServiceException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return "redirect:/projects";
	   }
}
