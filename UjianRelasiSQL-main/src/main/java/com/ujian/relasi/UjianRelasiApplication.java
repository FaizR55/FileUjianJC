package com.ujian.relasi;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.ujian.relasi.entity.Dosen;
import com.ujian.relasi.entity.Mahasiswa;
import com.ujian.relasi.entity.MataKuliah;
import com.ujian.relasi.entity.Pertanyaan;
import com.ujian.relasi.entity.Soal;
import com.ujian.relasi.repo.DosenRepo;
import com.ujian.relasi.repo.MahasiswaRepo;
import com.ujian.relasi.repo.MataKuliahRepo;
import com.ujian.relasi.repo.SoalRepo;

@SpringBootApplication
public class UjianRelasiApplication implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(UjianRelasiApplication.class, args);
	}
	
	@Autowired
	DosenRepo dosenRepo;
	
	@Autowired
	MahasiswaRepo mahasiswaRepo;
	
	@Autowired
	MataKuliahRepo matakuliahRepo;
	
	@Autowired
	SoalRepo soalRepo;
	
	@Override
	public void run(String... args) throws Exception{
		
		/*Mahasiswa mahasiswa = new Mahasiswa();
		mahasiswa.setNim("12345");
		mahasiswa.setPassword("test");
		mahasiswa.setNama_mahasiswa("Faiz");
		mahasiswa.setJenis_kelamin("L");
		
		Dosen dosen = new Dosen();
		dosen.setNama_dosen("Dewa");
		dosen.setUsername("dewa");
		dosen.setPassword("testing");
		
		MataKuliah matakuliah = new MataKuliah();
		matakuliah.setNama_mata_kuliah("Programming");

		List<MataKuliah>lstMataKuliah = new ArrayList<MataKuliah>();
		lstMataKuliah.add(matakuliah);
		
		List<Dosen>lstDosen = new ArrayList<Dosen>();
		lstDosen.add(dosen);
		
		mahasiswa.setLstDosen(lstDosen);
		mahasiswa.setLstMatakuliah(lstMataKuliah);
		
		this.mahasiswaRepo.save(mahasiswa);*/
		
		Soal soal = new Soal();
		soal.setNama_soal("Soal mtk");
		soal.setStatus("ok");
		
		Pertanyaan pertanyaan1 = new Pertanyaan();
		pertanyaan1.setPertanyaan("pertanyaan1");
		pertanyaan1.setJawaban1("jawaban1");
		pertanyaan1.setJawaban2("jawaban2");
		pertanyaan1.setJawaban3("jawaban3");
		pertanyaan1.setJawaban4("jawaban4");
		pertanyaan1.setJawaban_benar("jawaban2");
		pertanyaan1.setGambar("gambar1");

		Pertanyaan pertanyaan2 = new Pertanyaan();
		pertanyaan2.setPertanyaan("pertanyaan2");
		pertanyaan2.setJawaban1("jawaban1");
		pertanyaan2.setJawaban2("jawaban2");
		pertanyaan2.setJawaban3("jawaban3");
		pertanyaan2.setJawaban4("jawaban4");
		pertanyaan2.setJawaban_benar("jawaban1");
		pertanyaan2.setGambar("gambar2");
		
		List<Pertanyaan> lstPertanyaan = new ArrayList<Pertanyaan>();
		lstPertanyaan.add(pertanyaan1);
		lstPertanyaan.add(pertanyaan2);
		
		soal.setLstPertanyaan(lstPertanyaan);
		
		this.soalRepo.save(soal);
		
	}

}
