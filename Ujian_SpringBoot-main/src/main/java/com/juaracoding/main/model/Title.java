package com.juaracoding.main.model;

public class Title {
	
	public int worker_ref_id;
	public String worker_title;
	public String affected_from;
	
	public Title(int worker_ref_id, String worker_title, String affected_from) {
		super();
		this.worker_ref_id = worker_ref_id;
		this.worker_title = worker_title;
		this.affected_from = affected_from;
	}

	public int getWorker_ref_id() {
		return worker_ref_id;
	}

	public void setWorker_ref_id(int worker_ref_id) {
		this.worker_ref_id = worker_ref_id;
	}

	public String getWorker_title() {
		return worker_title;
	}

	public void setWorker_title(String worker_title) {
		this.worker_title = worker_title;
	}

	public String getAffected_from() {
		return affected_from;
	}

	public void setAffected_from(String affected_from) {
		this.affected_from = affected_from;
	}
	
	

}
