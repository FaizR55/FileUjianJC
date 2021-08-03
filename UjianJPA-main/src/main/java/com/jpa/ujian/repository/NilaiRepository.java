package com.jpa.ujian.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

import com.jpa.ujian.entity.Nilai;

public interface NilaiRepository extends CrudRepository<Nilai, Long> {

}
