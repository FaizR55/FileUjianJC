package com.ujian.relasi.entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor

@Entity
@Table(name="soal")
public class Soal {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private	long id;
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private	long id_plot_mk;
	
	private String nama_soal;
	private String status;
	
	@OneToMany(cascade=CascadeType.ALL)
	@JoinColumn(name="id_soal", referencedColumnName = "id")
	List<Pertanyaan> lstPertanyaan = new ArrayList<Pertanyaan>();

}
