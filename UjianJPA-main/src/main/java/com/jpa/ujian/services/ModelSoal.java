package com.jpa.ujian.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jpa.ujian.entity.Soal;
import com.jpa.ujian.repository.SoalRepository;

@Service
public class ModelSoal implements ModelSoalInterface {

	
	@Autowired
	SoalRepository soalRepo;
	
	@Override
	public List <Soal> getAllSoal(){
		return (List<Soal>) this.soalRepo.findAll();
	}
	
//	@Override
//	public Soal getSoalByName(String nama) {
//		return this.SoalRepo.findByNamaSoal(nama);
//	}
	
	
	@Override
	public Soal addSoal(Soal soal) {
		// TODO Auto-generated method stub
		
		return  this.soalRepo.save(soal);
	
	}
	
	
	@Override
	public Soal getSoalById(String id) {
		// TODO Auto-generated method stub
		
		return this.soalRepo.findById(Long.parseLong(id)).get();
		
		
	}

	@Override
	public void deleteSoal(String id) {
		// TODO Auto-generated method stub
		this.soalRepo.deleteById(Long.parseLong(id));
		
	}
	
}
