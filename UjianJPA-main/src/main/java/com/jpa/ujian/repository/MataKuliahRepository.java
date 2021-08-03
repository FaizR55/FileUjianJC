package com.jpa.ujian.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;


import com.jpa.ujian.entity.MataKuliah;

public interface MataKuliahRepository extends CrudRepository<MataKuliah, Long>{

	
	public MataKuliah findByNamaMatakuliah(String nama);
	
	public MataKuliah findByIdMatakuliah(Long id);
	
}
