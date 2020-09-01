package com.mypt.dto;

import java.sql.Date;
import java.sql.Timestamp;

public class HeadCountDto {
	String h_id;
	Date h_date;
	Timestamp intime,outtime;
	public String getH_id() {
		return h_id;
	}
	public void setH_id(String h_id) {
		this.h_id = h_id;
	}
	public Date getH_date() {
		return h_date;
	}
	public void setH_date(Date h_date) {
		this.h_date = h_date;
	}
	public Timestamp getIntime() {
		return intime;
	}
	public void setIntime(Timestamp intime) {
		this.intime = intime;
	}
	public Timestamp getOuttime() {
		return outtime;
	}
	public void setOuttime(Timestamp outtime) {
		this.outtime = outtime;
	}
	
}
