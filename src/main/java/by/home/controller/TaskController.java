package by.home.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import by.home.entity.Task;
import by.home.service.TaskService;
import by.home.service.exception.ServiceException;

@Controller
public class TaskController {

	@Autowired
	TaskService taskService;
	
	
	@RequestMapping(value = "/projects/task", method = RequestMethod.GET)
	public ModelAndView goToTaskPage(HttpServletRequest request) {
		List<Task> tasks = null;
		String strProjectId = request.getParameter("id");
		int projectId = Integer.valueOf(strProjectId);
		try {
			tasks = taskService.getProjectTasks(projectId);
		} catch (ServiceException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		ModelAndView mav = new ModelAndView("tasks","tasks", tasks);
		return mav;
	}
}
