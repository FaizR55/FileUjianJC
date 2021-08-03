package com.service.ujian.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.service.ujian.entity.Service;

public interface ServiceRepository extends JpaRepository<Service, Long>{
	
	@Query(value = "select * from service where nama LIKE %?1%",nativeQuery=true)
	List<Service> findByNama(String nama);
	
}
