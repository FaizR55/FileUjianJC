package com.ujian.akhir.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.ujian.akhir.entity.User;

public interface UserRepository extends JpaRepository<User, Long> {
	
	@Query(value = "select * from user_tbl where email =:type AND password=:value",nativeQuery=true)
    List<User> findBySearchBy(@Param("type")String type, @Param("value")String value);

}
