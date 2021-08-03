package com.ujian.relasi.entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor

@Entity
@Table(name="mata_kuliah")
public class MataKuliah {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private	long id;
	
	private String nama_mata_kuliah;
	
	@ManyToMany(mappedBy="lstMatakuliah")
	private List<Mahasiswa> lstMahasiswa = new ArrayList<Mahasiswa>();

}
