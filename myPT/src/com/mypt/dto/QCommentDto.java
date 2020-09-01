package com.mypt.dto;

import java.sql.Timestamp;

public class QCommentDto {
	int qb_cnum,qb_num;
	String qb_cnick, qb_ccontent;
	Timestamp qb_cdate;
	public int getQb_cnum() {
		return qb_cnum;
	}
	public void setQb_cnum(int qb_cnum) {
		this.qb_cnum = qb_cnum;
	}
	public int getQb_num() {
		return qb_num;
	}
	public void setQb_num(int qb_num) {
		this.qb_num = qb_num;
	}
	public String getQb_cnick() {
		return qb_cnick;
	}
	public void setQb_cnick(String qb_cnick) {
		this.qb_cnick = qb_cnick;
	}
	public String getQb_ccontent() {
		return qb_ccontent;
	}
	public void setQb_ccontent(String qb_ccontent) {
		this.qb_ccontent = qb_ccontent;
	}
	public Timestamp getQb_cdate() {
		return qb_cdate;
	}
	public void setQb_cdate(Timestamp qb_cdate) {
		this.qb_cdate = qb_cdate;
	}
	
	

}
