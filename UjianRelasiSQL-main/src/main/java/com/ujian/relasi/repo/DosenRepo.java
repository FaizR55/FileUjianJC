package com.ujian.relasi.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ujian.relasi.entity.Dosen;

public interface DosenRepo extends JpaRepository<Dosen, Long> {

}
