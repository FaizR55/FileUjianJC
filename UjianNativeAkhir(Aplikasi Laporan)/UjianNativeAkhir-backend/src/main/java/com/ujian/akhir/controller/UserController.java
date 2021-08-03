package com.ujian.akhir.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ujian.akhir.entity.User;
import com.ujian.akhir.repository.UserRepository;

@RestController
@RequestMapping("/user")
public class UserController {
	
	@Autowired
	UserRepository userRepo;
	
	@GetMapping("")
	public List<User> getAll() {
		return userRepo.findAll();
	}
	
	@PostMapping("/register/")
	public String addUser(@RequestBody User user) {
		userRepo.save(user);
		return "Insert Berhasil";
	}
	
	@PostMapping("/register/{id}")
	public String updateUser(@PathVariable String id, @RequestBody User user) {
		user.setIdUser(Long.parseLong(id));
		userRepo.save(user);
		return "Update Berhasil";
	}
	
	@DeleteMapping("/deleteUser/{id}")
	public String deleteUser(@PathVariable String id) {
		userRepo.deleteById(Long.parseLong(id));
		return "Delete Berhasil";
	}
	
	@GetMapping("/searchby/{type}/{value}")
    public List<User> getSearchBy(@PathVariable("type")String type, @PathVariable("value")String value) {
        return userRepo.findBySearchBy(type, value);
    }

}
