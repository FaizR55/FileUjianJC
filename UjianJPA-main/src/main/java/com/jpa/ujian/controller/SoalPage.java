package com.jpa.ujian.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.jpa.ujian.entity.Dosen;
import com.jpa.ujian.entity.Soal;
import com.jpa.ujian.services.ModelDosen;
import com.jpa.ujian.services.ModelPertanyaan;
import com.jpa.ujian.services.ModelSoal;

@Controller
public class SoalPage {

	
	@Autowired
	ModelSoal modelSoal;
	
	@Autowired
	ModelPertanyaan modelPertanyaan;
	
	@GetMapping("/soal/view")
	public String viewIndexSoal(Model model) {
		
		model.addAttribute("listSoal",modelSoal.getAllSoal());
		model.addAttribute("active",5);
		
		return "view_soal";
	}
	
	
	@GetMapping("/soal/add")
	public String viewAddSoal (Model model) {
		
		model.addAttribute("soal",new Soal ());
		model.addAttribute("listPertanyaan", modelPertanyaan.getAllPertanyaan());
		
		return "add_soal";
	}
	
	
	@PostMapping("/soal/view")
	  public String addSoal(@ModelAttribute Soal soal, Model model) {
		
		// buat penampung data mahasiswa di halaman htmlnya
		this.modelSoal.addSoal(soal);
		model.addAttribute("listSoal", modelSoal.getAllSoal());
		
		
		return "view_soal";
	}
	
	
	
	@GetMapping("/soal/update/{id}")
	public String viewUpdateSoal(@PathVariable String id, Model model) {
		
		Soal soal = modelSoal.getSoalById(id);
		model.addAttribute("soal",soal);
		
		return "add_soal";
	}
	
	@GetMapping("/soal/delete/{id}")
	public String deleteSoal(@PathVariable String id, Model model) {
		
		this.modelSoal.deleteSoal(id);
		model.addAttribute("listSoal",modelSoal.getAllSoal());
		
		
		return "view_soal";
	}
	
	
}
