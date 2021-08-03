package com.ujian.relasi.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ujian.relasi.entity.Mahasiswa;

public interface MahasiswaRepo extends JpaRepository<Mahasiswa, Long> {

}
