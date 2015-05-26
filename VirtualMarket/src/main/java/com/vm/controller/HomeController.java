package com.vm.controller;

import java.util.Locale;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.vm.model.User;
import com.vm.service.UserService;

@Controller
public class HomeController {
	
	private UserService userService;
    
    @Autowired(required=true)
    @Qualifier(value="userService")
    public void setUserService(UserService ps){
        
    	this.userService = ps;
    }
    
	@RequestMapping(value = "/home", method = RequestMethod.GET)
	public String home(Locale locale, Model model) {
		
		model.addAttribute("serverTime", "Welcome Gaust User!" );
		model.addAttribute("logdata", new User());
		
		return "home";
	}
	
	@RequestMapping(value = "/login", method = RequestMethod.POST)
	public String logerUser(@ModelAttribute("logdata") User u, Model model) {
		
		User record = this.userService.loginUser(u.getUser_name(), u.getPassword());
		
		if(record != null) {
		if(record.getUser_name() != null) {
			
			model.addAttribute("userrec", record);
			return "success";
		}else {
			
			model.addAttribute("userrec", "Access failed.");
			return "home";
		}}else {
			
			return "/home";
		}
	}
	
	@RequestMapping(value = "/index", method = RequestMethod.GET)
	public String redirectToHome(Locale locale, Model model) {
		
		model.addAttribute("serverTime", "Welcome Gaust User!" );
		System.out.println("Ok surya...");
		return "home";
	}
	
}
