package com.jpa.ujian.services;

import java.util.List;


import com.jpa.ujian.entity.Soal;

public interface ModelSoalInterface {

	public List<Soal> getAllSoal();
//	public Soal getSoalByName(String name);
	
	public Soal addSoal(Soal soal);
	public Soal getSoalById(String id);
	public void deleteSoal(String id);
	
	
}
