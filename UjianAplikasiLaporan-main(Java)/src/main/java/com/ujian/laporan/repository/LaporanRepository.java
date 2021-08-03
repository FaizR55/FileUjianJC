package com.ujian.laporan.repository;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.ujian.laporan.entity.Laporan;

public interface LaporanRepository extends CrudRepository<Laporan, Long> {
	
	public Laporan findByIdLaporan(Long id);
}
