package com.yeecharge.domain;

import java.io.Serializable;
import java.sql.Timestamp;

public class CPinfo implements Serializable{
	
	private int cp_id;
	private int cp_num;
	private String cp_model;
	private String latitude;
	private String longitude;
	private Timestamp install_time;
	
	
	public int getCp_id() {
		return cp_id;
	}
	public void setCp_id(int cp_id) {
		this.cp_id = cp_id;
	}
	public int getCp_num() {
		return cp_num;
	}
	public void setCp_num(int cp_num) {
		this.cp_num = cp_num;
	}
	public String getCp_model() {
		return cp_model;
	}
	public void setCp_model(String cp_model) {
		this.cp_model = cp_model;
	}
	public String getLatitude() {
		return latitude;
	}
	public void setLatitude(String latitude) {
		this.latitude = latitude;
	}
	public String getLongitude() {
		return longitude;
	}
	public void setLongitude(String longitude) {
		this.longitude = longitude;
	}
	public Timestamp getInstall_time() {
		return install_time;
	}
	public void setInstall_time(Timestamp install_time) {
		this.install_time = install_time;
	}
	
}
