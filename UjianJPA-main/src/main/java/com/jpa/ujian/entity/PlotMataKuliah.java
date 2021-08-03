package com.jpa.ujian.entity;

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
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name="plotMataKuliah")
public class PlotMataKuliah {

	@Id
	@GeneratedValue (strategy = GenerationType.IDENTITY)
	private long idPlotMataKuliah;
	@OneToMany (cascade = CascadeType.ALL)
	@JoinColumn (name = "MataKuliah", referencedColumnName = "idPlotMataKuliah")
	List <MataKuliah> lstMataKuliah = new ArrayList <MataKuliah>();
	@OneToMany (cascade = CascadeType.ALL)
	@JoinColumn (name = "Dosen", referencedColumnName = "idPlotMataKuliah")
	List <Dosen> lstDosen = new ArrayList <Dosen>();
	@OneToMany (cascade = CascadeType.ALL)
	@JoinColumn (name = "Mahasiswa", referencedColumnName = "idPlotMataKuliah")
	private List <Mahasiswa> lstMahasiswa = new ArrayList <Mahasiswa>();
	
	@OneToMany (cascade = CascadeType.ALL)
	@JoinColumn (name = "Soal", referencedColumnName = "idPlotMataKuliah")
	private List <Soal> lstSoal = new ArrayList <Soal>();
	
	
}
