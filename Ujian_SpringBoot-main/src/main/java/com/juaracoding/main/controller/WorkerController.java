package com.juaracoding.main.controller;

import java.util.List;
import java.util.NoSuchElementException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.juaracoding.main.model.Worker;
import com.juaracoding.main.model.WorkerRowMapper;


@RestController
@RequestMapping("/worker")
public class WorkerController {
	
	@Autowired
	JdbcTemplate jdbc;

	public List<Worker> getWorker() {

		String sql = "Select * from worker";

		List<Worker> worker = jdbc.query(sql, new WorkerRowMapper());

		return worker;

	}
	
	public int insertWorker(Worker worker) {
		return jdbc.update("insert into worker(worker_id,first_name,last_name,salary,joining_date,department) values ('" + worker.getWorker_id() + "','"
				+ worker.getFirst_name() + "','" + worker.getLast_name() + "'," + worker.getSalary() + ",'" + worker.getJoining_date() + "','" + worker.getDepartment() + "')");

	}

	public int updateWorker(String worker_id, Worker worker) {

		return jdbc.update("UPDATE worker SET `first_name`='" + worker.getFirst_name() + "',`last_name`='" + worker.getLast_name()
				+ "',`salary`=" + worker.getSalary() + ",`joining_date`='" + worker.getJoining_date() + "',`department`='" + worker.getDepartment() + "' WHERE worker_id = '" + worker.getWorker_id() + "'");

	}

	public int deleteWorker(String worker_id) {
		return jdbc.update("DELETE FROM `worker`  WHERE `worker_id` = '" + worker_id + "';");
		
	
	}
	
	public List<Worker> getHighest() { //function untuk panggil procedure getHighest
		String sql = "call 'getHighest' ";
		List<Worker> high = jdbc.query(sql, new WorkerRowMapper());
		return high;
	}
	
	public List<Worker> getSama() { //function untuk panggil procedure getSama
		String sql = "call 'getSama' ";
		List<Worker> sama = jdbc.query(sql, new WorkerRowMapper());
		return sama;
	}
	
	public List<Worker> getJumlah() { //function untuk panggil procedure getJumlah
		String sql = "call 'getJumlah' ";
		List<Worker> jumlah = jdbc.query(sql, new WorkerRowMapper());
		return jumlah;
	}
	
	 @GetMapping("/") //get
	    public List<Worker> list() {
	        return getWorker();
	    }
	 
	 @PostMapping("/") //insert
	    public String add(@RequestBody Worker worker) {
		 

			if (this.insertWorker(worker) == 1) {
				return "Insert data berhasil";
			} else {
				return "Insert data gagal";
			}
	    }
	 
	 @DeleteMapping("/{worker_id}") //delete
	    public void delete(@PathVariable String worker_id) {
		 	deleteWorker(worker_id);
	 }
	 
	 @PutMapping("/{worker_id}") //update
	    public ResponseEntity<?> update(@RequestBody Worker worker, @PathVariable String worker_id) {
		 try {
	            updateWorker(worker_id, worker);
	            return new ResponseEntity<>(HttpStatus.OK);
	        } catch (NoSuchElementException e) {
	            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
	        }
		 
	 }
	 
	 @GetMapping("/high") //memanggil function getHighest
	    public List<Worker> high() {
	        return getHighest();
	    }
	 
	 @GetMapping("/sama") //memanggil function getSama
	    public List<Worker> sama() {
	        return getSama();
	    }
	 
	 @GetMapping("/info") //memanggil function getJumlah
	    public List<Worker> jumlah() {
	        return getJumlah();
	    }

}
