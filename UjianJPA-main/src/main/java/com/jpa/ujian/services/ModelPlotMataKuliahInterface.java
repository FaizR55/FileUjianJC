package com.jpa.ujian.services;

import java.util.List;

import com.jpa.ujian.entity.Pertanyaan;
import com.jpa.ujian.entity.PlotMataKuliah;


public interface ModelPlotMataKuliahInterface {

	public List<PlotMataKuliah> getAllPlotMataKuliah();
	public PlotMataKuliah addPlotMataKuliah(PlotMataKuliah plotmatakuliah);
	public PlotMataKuliah getPlotMataKuliahById(String id);
	public void deletePlotMataKuliah(String id);
	public PlotMataKuliah cariPlotMataKuliah(String id);
}
