package com.service.ujian.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.service.ujian.entity.Service;
import com.service.ujian.repository.ServiceRepository;

@RestController
@RequestMapping("/service")
public class ServiceController {
	@Autowired
	ServiceRepository serviceRepo;
	
	@GetMapping("/")
	public List<Service> getAll(){
		return serviceRepo.findAll();
	}
	
	@GetMapping("/{nama}")
	public List<Service> getAllByNama(@PathVariable String nama) {
		System.out.println(nama);
		return serviceRepo.findByNama(nama);
	}
	
	@PostMapping("/addService")
	public String addService(@RequestBody Service service) {
		serviceRepo.save(service);
		return "Insert Berhasil";
	}
	
	@DeleteMapping("/deleteService/{id}")
	public String deleteService(@PathVariable String id) {
		serviceRepo.deleteById(Long.parseLong(id));
		return "Delete Berhasil";
	}
	
	@PutMapping("/updateService/{id}")
	public String updateBuku(@PathVariable String id, @RequestBody Service service) {
		service.setId(Long.parseLong(id));
		serviceRepo.save(service);
		return "Update Berhasil";
	}
}
