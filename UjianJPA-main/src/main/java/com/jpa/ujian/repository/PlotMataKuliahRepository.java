package com.jpa.ujian.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

import com.jpa.ujian.entity.Dosen;
import com.jpa.ujian.entity.PlotMataKuliah;

public interface PlotMataKuliahRepository extends CrudRepository<PlotMataKuliah, Long> {

	public PlotMataKuliah findByIdPlotMataKuliah(Long id);
}
