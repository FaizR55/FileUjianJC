package com.ujian.laporan;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.ujian.laporan.entity.Laporan;
import com.ujian.laporan.repository.LaporanRepository;

@SpringBootApplication
public class UjianLaporanApplication implements CommandLineRunner{
	
	@Autowired
	LaporanRepository laporanRepo;

	public static void main(String[] args) {
		SpringApplication.run(UjianLaporanApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		// TODO Auto-generated method stub
//		Laporan laporan = new Laporan();
//		laporan.setNama("test");
//		laporan.setAlamat("jalan tester");
//
//		this.laporanRepo.save(laporan);
	}

}
