package by.home.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;

import by.home.entity.User;
import by.home.service.UserService;
import by.home.service.exception.ServiceException;
import by.home.validator.SignUpValidator;

@Controller
@SessionAttributes("userDetails")
public class UserController {

	@Autowired
	UserService userService;
	
	@Autowired
	private SignUpValidator signUpValidator;
	
	@ModelAttribute("userDetails") 
	public User createUser(){
		return new User();
	}
	
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public ModelAndView printHello() {
	      ModelAndView mav = new ModelAndView();
	      mav.setViewName("login");
	      return mav;
	   }
	
	@RequestMapping(value = "/login", method = RequestMethod.POST)
	public String login(@ModelAttribute("userDetails") User userDetails, ModelMap model, Authentication authentication) {
/*		
		UserDetails user = userService.loadUserByUsername(userDetails.getEmail());
		UserDetails userw = (UserDetails) authentication.getPrincipal();*/
		try {
			model.addAttribute("userDetails", userService.getUser(authentication.getName()));
		} catch (ServiceException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
 		return "redirect : projects";
 	}
	
	
	@RequestMapping(value = "/registration", method = RequestMethod.GET)
	public ModelAndView showRegistrationPage() {
	      ModelAndView mav = new ModelAndView("registration", "user", new User());
	      return mav;
	   }
	
	@RequestMapping(value = "/registration", method = RequestMethod.POST)
	public String registerUser(@ModelAttribute("userDetails") User userDetails, BindingResult result) {
		signUpValidator.validate(userDetails, result);
		if (result.hasErrors()) {
			return "registration";
		}
		try {
			userService.registrationUser(userDetails);
		} catch (ServiceException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return  "redirect: projects";
	   }
	  

}
