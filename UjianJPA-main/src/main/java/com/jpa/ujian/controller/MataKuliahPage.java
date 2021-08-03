package com.jpa.ujian.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.jpa.ujian.services.ModelMataKuliah;
import com.jpa.ujian.entity.MataKuliah;


@Controller
public class MataKuliahPage {

	@Autowired
	ModelMataKuliah modelMataKuliah;
	
	
	@GetMapping("/matakuliah/view")
	public String viewIndexMataKuliah(Model model) {
		
		model.addAttribute("listMataKuliah",modelMataKuliah.getAllMataKuliah());
		model.addAttribute("active",3);
		return "view_matakuliah";
	}
	
	
	@GetMapping("/matakuliah/add")
	public String viewAddMataKuliah (Model model) {
		
		model.addAttribute("matakuliah",new MataKuliah ());
		
		return "add_matakuliah";
	}
	
	
	@PostMapping("/matakuliah/view")
	  public String addMataKuliah(@ModelAttribute MataKuliah matakuliah, Model model) {
		
		// buat penampung data mahasiswa di halaman htmlnya
		this.modelMataKuliah.addMatakuliah(matakuliah);
		model.addAttribute("listMataKuliah", modelMataKuliah.getAllMataKuliah());
		
		
		return "view_matakuliah";
	}
	
	
	
	@GetMapping("/matakuliah/update/{id}")
	public String viewUpdateMataKuliah(@PathVariable String id, Model model) {
		
		MataKuliah matakuliah = modelMataKuliah.getMatakuliahById(id);
		// buat penampung data mahasiswa di halaman htmlnya
		model.addAttribute("matakuliah",matakuliah);
		
		return "add_matakuliah";
	}
	
	@GetMapping("/matakuliah/delete/{id}")
	public String deleteMataKuliah(@PathVariable String id, Model model) {
		
		this.modelMataKuliah.deleteMatakuliah(id);
		model.addAttribute("listMataKuliah",modelMataKuliah.getAllMataKuliah());
		
		
		return "view_matakuliah";
	}
	
}
