package com.juaracoding.service.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.juaracoding.service.entity.DataUser;

public interface DataUserRepository extends JpaRepository<DataUser, Long>{
	
	@Query(value = "SELECT *\n"
			+ "from user\n"
			+ "Where (CASE "
			+ "WHEN 'username'=:type THEN name LIKE %:value% "
			+ "WHEN 'phone'=:type THEN phone LIKE %:value% "
			+ "WHEN 'address'=:type THEN address LIKE %:value% "
			+ "WHEN 'email'=:type THEN email LIKE %:value% "
			+ "END)",nativeQuery=true)
	List<DataUser> findBySearchBy(@Param("type")String type,@Param("value")String value);

	@Query(value="SELECT * from user where username=?1 and phone=?2",nativeQuery = true)
	DataUser findByLogin(String username, String phone);
	
	DataUser findByName(String name); 
}
