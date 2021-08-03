package com.jpa.ujian.services;

import java.util.List;


import com.jpa.ujian.entity.Pertanyaan;

public interface ModelPertanyaanInterface {

	
	public List<Pertanyaan> getAllPertanyaan();
//	public Pertanyaan getPertanyaanByName(String name);
	
	public Pertanyaan addPertanyaan(Pertanyaan pertanyaan);
//	public Pertanyaan getPertanyaanById(String id);
	public void deletePertanyaan(String id);
	
	public Pertanyaan cariPertanyaan(String id);
}
