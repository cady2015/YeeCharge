package com.yeecharge.domain;

import java.io.Serializable;
import java.sql.Timestamp;

public class CPsStatus implements Serializable {
	private int cp_id;
	private String cp_voltage;
	private String cp_current;
	private String cp_temperature;
	private int cp_status;
	private int energy_left;
	private Timestamp update_time;
	
	public int getCp_id() {
		return cp_id;
	}
	public void setCp_id(int cp_id) {
		this.cp_id = cp_id;
	}
	public String getCp_voltage() {
		return cp_voltage;
	}
	public void setCp_voltage(String cp_voltage) {
		this.cp_voltage = cp_voltage;
	}
	public String getCp_current() {
		return cp_current;
	}
	public void setCp_current(String cp_current) {
		this.cp_current = cp_current;
	}
	public String getCp_temperature() {
		return cp_temperature;
	}
	public void setCp_temperature(String cp_temperature) {
		this.cp_temperature = cp_temperature;
	}
	public int getCp_status() {
		return cp_status;
	}
	public void setCp_status(int cp_status) {
		this.cp_status = cp_status;
	}
	public int getEnergy_left() {
		return energy_left;
	}
	public void setEnergy_left(int energy_left) {
		this.energy_left = energy_left;
	}
	public Timestamp getUpdate_time() {
		return update_time;
	}
	public void setUpdate_time(Timestamp update_time) {
		this.update_time = update_time;
	}
	
}
