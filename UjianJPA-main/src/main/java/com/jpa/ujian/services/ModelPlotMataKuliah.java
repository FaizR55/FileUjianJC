package com.jpa.ujian.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jpa.ujian.entity.Pertanyaan;
import com.jpa.ujian.entity.PlotMataKuliah;

import com.jpa.ujian.repository.PlotMataKuliahRepository;

@Service
public class ModelPlotMataKuliah implements ModelPlotMataKuliahInterface {

	@Autowired
	PlotMataKuliahRepository plotMataKuliahRepo;
	
	@Override
	public List <PlotMataKuliah> getAllPlotMataKuliah(){
		return (List<PlotMataKuliah>) this.plotMataKuliahRepo.findAll();
	}
	
	@Override
	public PlotMataKuliah addPlotMataKuliah(PlotMataKuliah plotmatakuliah) {
		// TODO Auto-generated method stub
		return  this.plotMataKuliahRepo.save(plotmatakuliah);
	}
	
	
	@Override
	public PlotMataKuliah getPlotMataKuliahById(String id) {
		// TODO Auto-generated method stub
		return 	((PlotMataKuliah)this.plotMataKuliahRepo.findByIdPlotMataKuliah(Long.parseLong(id)));
	}

	@Override
	public void deletePlotMataKuliah(String id) {
		// TODO Auto-generated method stub
		this.plotMataKuliahRepo.deleteById(Long.parseLong(id));
	}
	
	@Override
	public PlotMataKuliah cariPlotMataKuliah(String id) {
		// TODO Auto-generated method stub
		return this.plotMataKuliahRepo.findByIdPlotMataKuliah(Long.parseLong(id));
	}
	
}
