package com.ujian.akhir.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ujian.akhir.entity.Laporan;

public interface LaporanRepository extends JpaRepository<Laporan, Long> {
	
	public Laporan findByIdLaporan(Long id);

}
