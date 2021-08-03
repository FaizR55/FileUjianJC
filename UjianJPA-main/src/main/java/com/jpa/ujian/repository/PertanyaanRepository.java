package com.jpa.ujian.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

import com.jpa.ujian.entity.Dosen;
import com.jpa.ujian.entity.Pertanyaan;

public interface PertanyaanRepository extends CrudRepository<Pertanyaan, Long>{

//	public Dosen findByNamaDosen(String nama);
//	public Pertanyaan findByIdPertanyaan(Long id);
}
