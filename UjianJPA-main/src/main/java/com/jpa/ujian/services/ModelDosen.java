package com.jpa.ujian.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jpa.ujian.entity.Dosen;
import com.jpa.ujian.entity.Mahasiswa;
import com.jpa.ujian.repository.DosenRepository;

@Service
public class ModelDosen implements ModelDosenInterface {

	@Autowired
	DosenRepository dosenRepo;
	
	@Override
	public List <Dosen> getAllDosen(){
		return (List<Dosen>) this.dosenRepo.findAll();
	}
	
	@Override
	public Dosen getDosenByName(String nama) {
		return this.dosenRepo.findByNamaDosen(nama);
	}
	
	
	@Override
	public Dosen addDosen(Dosen dosen) {
		// TODO Auto-generated method stub
		
		return  this.dosenRepo.save(dosen);
	
	}
	
	
	@Override
	public Dosen getDosenById(String id) {
		// TODO Auto-generated method stub
		
		return 	((Dosen)this.dosenRepo.findByIdDosen(Long.parseLong(id)));
		
		
	}

	@Override
	public void deleteDosen(String id) {
		// TODO Auto-generated method stub
		this.dosenRepo.deleteById(Long.parseLong(id));
		
	}
	
}
