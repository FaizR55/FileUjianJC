package com.ujian.laporan.service;

import java.util.List;

import com.ujian.laporan.entity.AdminUser;

public interface ModelAdminUserInterface {
	
	public List<AdminUser> getAllAdminUser();
	
	public AdminUser addAdminUser(AdminUser mahasiswa);
	public AdminUser getAdminUserById(String id);
	public void deleteAdminUser(String id);

}
