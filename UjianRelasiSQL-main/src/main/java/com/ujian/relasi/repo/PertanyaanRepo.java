package com.ujian.relasi.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ujian.relasi.entity.Pertanyaan;

public interface PertanyaanRepo extends JpaRepository<Pertanyaan, Long> {

}
