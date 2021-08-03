package com.ujian.laporan.repository;

import org.springframework.data.repository.CrudRepository;

import com.ujian.laporan.entity.AdminUser;

public interface AdminUserRepository extends CrudRepository<AdminUser, Long> {
	public AdminUser findByUsername(String username);
}
