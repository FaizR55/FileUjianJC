package com.ujian.laporan.service;

import java.util.List;

import com.ujian.laporan.entity.Laporan;

public interface ModelLaporanInterface {
	
	public List<Laporan> getAllLaporan();
	public Laporan addLaporan(Laporan laporan);
	public Laporan getLaporanById(String id);
	public void deleteLaporan(String id);
	
}
