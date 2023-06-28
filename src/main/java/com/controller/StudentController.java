package com.controller;



import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class StudentController {

	@GetMapping("/home")
	public String home(){ 
		
		return "Home";	
	}
	
	@GetMapping("/logout")
	public String logout() {
		
		return "redirect:/login";
		
	}











}
