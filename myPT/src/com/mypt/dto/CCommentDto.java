package com.mypt.dto;

import java.sql.Timestamp;

public class CCommentDto {
	int cb_cnum,cb_num;
	String cb_cnick, cb_ccontent;
	Timestamp cb_cdate;
	public int getcb_cnum() {
		return cb_cnum;
	}
	public void setcb_cnum(int cb_cnum) {
		this.cb_cnum = cb_cnum;
	}
	public int getcb_num() {
		return cb_num;
	}
	public void setcb_num(int cb_num) {
		this.cb_num = cb_num;
	}
	public String getcb_cnick() {
		return cb_cnick;
	}
	public void setcb_cnick(String cb_cnick) {
		this.cb_cnick = cb_cnick;
	}
	public String getcb_ccontent() {
		return cb_ccontent;
	}
	public void setcb_ccontent(String cb_ccontent) {
		this.cb_ccontent = cb_ccontent;
	}
	public Timestamp getcb_cdate() {
		return cb_cdate;
	}
	public void setcb_cdate(Timestamp cb_cdate) {
		this.cb_cdate = cb_cdate;
	}
	
	

}
