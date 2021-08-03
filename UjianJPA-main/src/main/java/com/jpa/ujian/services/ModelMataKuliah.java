package com.jpa.ujian.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jpa.ujian.entity.Dosen;
import com.jpa.ujian.entity.MataKuliah;
import com.jpa.ujian.repository.DosenRepository;
import com.jpa.ujian.repository.MataKuliahRepository;

@Service
public class ModelMataKuliah implements ModelMataKuliahInterface{

	@Autowired
	MataKuliahRepository mataKuliahRepo;
	
	@Override
	public List <MataKuliah> getAllMataKuliah(){
		return (List<MataKuliah>) this.mataKuliahRepo.findAll();
	}
	
	@Override
	public MataKuliah getMatakuliahByName(String nama) {
		return this.mataKuliahRepo.findByNamaMatakuliah(nama);
	}
	
	
	@Override
	public MataKuliah addMatakuliah(MataKuliah matakuliah) {
		// TODO Auto-generated method stub
		
		return  this.mataKuliahRepo.save(matakuliah);
	
	}
	
	
	@Override
	public MataKuliah getMatakuliahById(String id) {
		// TODO Auto-generated method stub
		
		return 	((MataKuliah)this.mataKuliahRepo.findByIdMatakuliah(Long.parseLong(id)));
		
		
	}

	@Override
	public void deleteMatakuliah(String id) {
		// TODO Auto-generated method stub
		this.mataKuliahRepo.deleteById(Long.parseLong(id));
		
	}
	
	
}
