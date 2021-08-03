package com.jpa.ujian;

import java.util.ArrayList;
import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.jpa.ujian.entity.Dosen;
import com.jpa.ujian.entity.Mahasiswa;
import com.jpa.ujian.entity.MataKuliah;
import com.jpa.ujian.entity.Nilai;
import com.jpa.ujian.entity.Pertanyaan;
import com.jpa.ujian.entity.PlotMataKuliah;
import com.jpa.ujian.entity.Soal;
import com.jpa.ujian.repository.DosenRepository;
import com.jpa.ujian.repository.MahasiswaRepository;
import com.jpa.ujian.repository.MataKuliahRepository;
import com.jpa.ujian.repository.NilaiRepository;
import com.jpa.ujian.repository.PertanyaanRepository;
import com.jpa.ujian.repository.PlotMataKuliahRepository;
import com.jpa.ujian.repository.SoalRepository;

@SpringBootApplication
public class UjianJpaApplication implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(UjianJpaApplication.class, args);
	}

	
	@Autowired
	PlotMataKuliahRepository plotMK;
	
//	@Autowired
//	private SoalRepository soalRepo;
	
	public void run (String...args) throws Exception {
		
/*
		
		PlotMataKuliah plotMK = new PlotMataKuliah();
		
		Mahasiswa mahasiswa = new Mahasiswa();
		mahasiswa.setNamaMahasiswa("Wicak");
		mahasiswa.setJenisKelamin("Pria");
		mahasiswa.setNim("12345");
		mahasiswa.setPassword("rahasia");
		
		plotMK.setMahasiswa(mahasiswa);
		
		Dosen dosen = new Dosen();
		dosen.setNamaDosen("Joko");
		dosen.setUsername("Jokooo");
		dosen.setPassword("opoo");
		
		plotMK.setDosen(dosen);
		
		MataKuliah matakuliah = new MataKuliah();
		matakuliah.setNamaMatakuliah("Psikologi");
		
		plotMK.setMatakuliah(matakuliah);
		
		List<Soal> lstSoal = new ArrayList<Soal>();
		
		Soal soal1 = new Soal();
		soal1.setNamaSoal("Skakmat Aqil");
		soal1.setStatus(1);
		
		Nilai nilai = new Nilai();
		nilai.setNilai("80");
		soal1.setNilai(nilai);
		
		Pertanyaan pertanyaan1 = new Pertanyaan();
		pertanyaan1.setPertanyaan("Siapa Dewa Kipas");
		pertanyaan1.setJawaban1("Sidiq");
		pertanyaan1.setJawaban2("Dadang");
		pertanyaan1.setJawaban3("Jouzu");
		pertanyaan1.setJawaban4("Tidak ada yang benar");
		pertanyaan1.setJawabanBenar("2");
		pertanyaan1.setStatusGambar("https://akcdn.detik.net.id/community/media/visual/2021/03/19/dadang-subur-dewa-kipas-1_169.jpeg");
		
		List<Pertanyaan> lstPertanyaan = new ArrayList<Pertanyaan>();
		lstPertanyaan.add(pertanyaan1);
		soal1.setLstPertanyaan(lstPertanyaan);
		
		
		lstSoal.add(soal1);
		
		plotMK.setLstSoal(lstSoal);
		this.plotMK.save(plotMK);*/
		
		
		
//		Soal soalx = this.soalRepo.findByNamaSoal("Soal Percintaan");
//		System.out.println(soalx.getNamaSoal());
	}
}
