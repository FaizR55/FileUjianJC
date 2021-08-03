package com.ujian.laporan.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ujian.laporan.entity.Laporan;
import com.ujian.laporan.repository.LaporanRepository;

@Service
public class ModelLaporan implements ModelLaporanInterface {
	
	@Autowired
	LaporanRepository laporanRepo;
	
	@Override
	public List<Laporan> getAllLaporan() {
		// TODO Auto-generated method stub
		return (List<Laporan>) this.laporanRepo.findAll();
	}
	
	@Override
	public Laporan addLaporan(Laporan laporan) {
		// TODO Auto-generated method stub
		return  this.laporanRepo.save(laporan);
	
	}

	@Override
	public Laporan getLaporanById(String id) {
		// TODO Auto-generated method stub
		return 	((Laporan)this.laporanRepo.findByIdLaporan(Long.parseLong(id)));
		
	}

	@Override
	public void deleteLaporan(String id) {
		// TODO Auto-generated method stub
		this.laporanRepo.deleteById(Long.parseLong(id));
		
	}

	public void save(Laporan updateStatus) {
		// TODO Auto-generated method stub
		this.laporanRepo.save(updateStatus);
	}
}
