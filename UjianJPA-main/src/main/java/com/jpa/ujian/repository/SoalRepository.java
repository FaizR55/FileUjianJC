package com.jpa.ujian.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

import com.jpa.ujian.entity.Soal;

public interface SoalRepository extends CrudRepository<Soal, Long> {

	
//	public Soal findByNamaSoal(String nama);
}
