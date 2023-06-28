package com.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.Entity.StudentEntity;
import com.Repository.StudentRepository;

@Controller
public class SessionController {

	@Autowired
	StudentRepository studentRepo;

	@GetMapping("/signup")
	public String signup() {
		return "Signup";
	}

	@PostMapping("/savestudent")
	public String saveStudent(StudentEntity student) {
		studentRepo.save(student);
		return "redirect:/login";
	}

	@GetMapping("/login")
	public String login() {
		return "Login";
	}

	@PostMapping("/authenticate")
	public String authenticate(StudentEntity student,Model model) {

		StudentEntity studentDb = studentRepo.findByEmail(student.getEmail());
		if (studentDb == null) {
			model.addAttribute("error","Invalid Credentials");
			return "Login";
		} else if (!studentDb.getPassword().equals(student.getPassword())) {
			model.addAttribute("error","Invalid Credentials");
			return "Login";
		} else {
			return "redirect:/home";
		}
	}

}
