package com.jpa.ujian.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

import com.jpa.ujian.entity.Dosen;
import com.jpa.ujian.entity.Mahasiswa;

public interface DosenRepository extends CrudRepository<Dosen, Long>{

	public Dosen findByNamaDosen(String nama);
	
	public Dosen findByIdDosen(Long id);
}
