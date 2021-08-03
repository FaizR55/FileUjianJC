package com.jpa.ujian.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jpa.ujian.entity.Pertanyaan;
import com.jpa.ujian.repository.PertanyaanRepository;

@Service
public class ModelPertanyaan implements ModelPertanyaanInterface {

	
	@Autowired
	PertanyaanRepository pertanyaanRepo;
	
	@Override
	public List <Pertanyaan> getAllPertanyaan(){
		return (List<Pertanyaan>) this.pertanyaanRepo.findAll();
	}
	
//	@Override
//	public Pertanyaan getPertanyaanByName(String nama) {
//		return this.pertanyaanRepo.findByNamaPertanyaan(nama);
//	}
	
	
	@Override
	public Pertanyaan addPertanyaan(Pertanyaan pertanyaan) {
		// TODO Auto-generated method stub
		
		return  this.pertanyaanRepo.save(pertanyaan);
	
	}
	
	
//	@Override
//	public Pertanyaan getPertanyaanById(String id) {
//		// TODO Auto-generated method stub
//		
//		return 	((Pertanyaan)this.pertanyaanRepo.findById(Long.parseLong(id)));
//		
//		
//	}

	@Override
	public void deletePertanyaan(String id) {
		// TODO Auto-generated method stub
		this.pertanyaanRepo.deleteById(Long.parseLong(id));
		
	}
	
	@Override
	public Pertanyaan cariPertanyaan(String id) {
		// TODO Auto-generated method stub
		return this.pertanyaanRepo.findById(Long.parseLong(id)).get();
	}
	
}
