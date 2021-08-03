package com.ujian.akhir.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ujian.akhir.entity.Laporan;
import com.ujian.akhir.repository.LaporanRepository;

@RestController
@RequestMapping("/laporan")
public class LaporanController {
	
	@Autowired
	LaporanRepository laporanRepo;
	
	@GetMapping("/")
	public List<Laporan> getAll() {
		return laporanRepo.findAll();
	}
	
	@PostMapping("/addLaporan/")
	public String addLaporan(@RequestBody Laporan laporan) {
		laporanRepo.save(laporan);
		return "Berhasil Insert Laporan";
	}
	
	@PostMapping("/updateLaporan/{id}")
	public String updateLaporan(@PathVariable String id, @RequestBody Laporan laporan) {
		laporan.setIdLaporan(Long.parseLong(id));
		laporanRepo.save(laporan);
		return "Update Berhasil";
	}
	
	@DeleteMapping("/deleteLaporan/{id}")
	public String deleteLaporan(@PathVariable String id) {
		laporanRepo.deleteById(Long.parseLong(id));
		return "Delete Berhasil";
	}

}
