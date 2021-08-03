package com.jpa.ujian.services;

import java.util.List;

import com.jpa.ujian.entity.Dosen;
import com.jpa.ujian.entity.Mahasiswa;

public interface ModelDosenInterface {

	public List<Dosen> getAllDosen();
	public Dosen getDosenByName(String name);
	
	public Dosen addDosen(Dosen dosen);
	public Dosen getDosenById(String id);
	public void deleteDosen(String id);
	
}
