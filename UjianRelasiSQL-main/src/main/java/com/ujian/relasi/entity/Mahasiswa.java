package com.ujian.relasi.entity;


import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor

@Entity
@Table(name="mahasiswa")
public class Mahasiswa {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private	long id;
	
	private	String nim;
	private String password;
	private String jenis_kelamin;
	private String nama_mahasiswa;
	
    @ManyToMany(cascade= CascadeType.ALL)
    @JoinTable(
    		name = "id_plot_matakuliah", 
	        joinColumns = { @JoinColumn(name = "id_mahasiswa", referencedColumnName = "id") }, 
	        inverseJoinColumns = { @JoinColumn(name = "id_mata_kuliah",referencedColumnName = "id") })
    
    List<MataKuliah> lstMatakuliah = new ArrayList<MataKuliah>();

    @ManyToMany(cascade= CascadeType.ALL)
    @JoinTable(
    		name = "id_plot_matakuliah", 
	        joinColumns = { @JoinColumn(name = "id_mahasiswa", referencedColumnName = "id") }, 
	        inverseJoinColumns = { @JoinColumn(name = "id_dosen",referencedColumnName = "id") })
    
    List<Dosen> lstDosen = new ArrayList<Dosen>();

}
