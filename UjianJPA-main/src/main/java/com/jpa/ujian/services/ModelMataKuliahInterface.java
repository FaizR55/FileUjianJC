package com.jpa.ujian.services;

import java.util.List;


import com.jpa.ujian.entity.MataKuliah;

public interface ModelMataKuliahInterface {

	public List<MataKuliah> getAllMataKuliah();
	public MataKuliah getMatakuliahByName(String name);

	public MataKuliah addMatakuliah(MataKuliah matakuliah);
	public MataKuliah getMatakuliahById(String id);
	public void deleteMatakuliah(String id);
	
	
}
