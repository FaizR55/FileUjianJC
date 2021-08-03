package com.jpa.ujian.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.jpa.ujian.repository.MahasiswaRepository;

@Controller
public class HomePage {
	
	@GetMapping("/")
	public String viewHomePage(Model model) {
		return "index";
	}
	
}
