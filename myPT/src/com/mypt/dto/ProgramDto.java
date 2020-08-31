package com.mypt.dto;

import java.sql.Date;

public class ProgramDto {
	private String p_id;
	private Date p_date;
	private String p_mention;
	private String p_part;
	
	public String getP_id() {
		return p_id;
	}
	public void setP_id(String p_id) {
		this.p_id = p_id;
	}
	public Date getP_date() {
		return p_date;
	}
	public void setP_date(Date p_date) {
		this.p_date = p_date;
	}
	public String getP_mention() {
		return p_mention;
	}
	public void setP_mention(String p_mention) {
		this.p_mention = p_mention;
	}
	public String getP_part() {
		return p_part;
	}
	public void setP_part(String p_part) {
		this.p_part = p_part;
	}
	
	
}
