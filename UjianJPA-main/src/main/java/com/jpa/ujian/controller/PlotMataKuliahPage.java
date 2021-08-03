package com.jpa.ujian.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.jpa.ujian.entity.PlotMataKuliah;
import com.jpa.ujian.entity.Soal;
import com.jpa.ujian.services.ModelDosen;
import com.jpa.ujian.services.ModelMahasiswa;
import com.jpa.ujian.services.ModelMataKuliah;
import com.jpa.ujian.services.ModelPertanyaan;
import com.jpa.ujian.services.ModelPlotMataKuliah;
import com.jpa.ujian.services.ModelSoal;

@Controller
public class PlotMataKuliahPage {

	
	@Autowired
	ModelSoal modelSoal;
	
	@Autowired
	ModelMahasiswa modelMahasiswa;
	
	@Autowired
	ModelDosen modelDosen;
	
	@Autowired
	ModelMataKuliah modelMataKuliah;
	
	@Autowired
	ModelPlotMataKuliah modelPlotMataKuliah;
	
	
	@GetMapping("/plotmatakuliah/view")
	public String viewIndexPlotMataKuliah(Model model) {
		
		model.addAttribute("listPlotMataKuliah",modelPlotMataKuliah.getAllPlotMataKuliah());
		model.addAttribute("listMahasiswa", modelMahasiswa.getAllMahasiswa());
		model.addAttribute("listDosen", modelDosen.getAllDosen());
		model.addAttribute("listMataKuliah", modelMataKuliah.getAllMataKuliah());
		model.addAttribute("listSoal", modelSoal.getAllSoal());
		model.addAttribute("active",6);
		
		return "view_plotmatakuliah";
	}
	
	
	@GetMapping("/plotmatakuliah/add")
	public String viewAddPlotMataKuliah (Model model) {
		
		model.addAttribute("plotmatakuliah",new PlotMataKuliah ());
		model.addAttribute("listMahasiswa", modelMahasiswa.getAllMahasiswa());
		model.addAttribute("listDosen", modelDosen.getAllDosen());
		model.addAttribute("listMataKuliah", modelMataKuliah.getAllMataKuliah());
		model.addAttribute("listSoal", modelSoal.getAllSoal());
		
		return "add_plotmatakuliah";
	}
	
	
	@PostMapping("/plotmatakuliah/view")
	  public String addPlotMataKuliah(@ModelAttribute PlotMataKuliah plotmatakuliah, Model model) {
		
		// buat penampung data mahasiswa di halaman htmlnya
		this.modelPlotMataKuliah.addPlotMataKuliah(plotmatakuliah);
		model.addAttribute("listPlotMataKuliah", modelPlotMataKuliah.getAllPlotMataKuliah());
		
		return "view_plotmatakuliah";
	}
	
}
