package com.mypt.dto;

import java.sql.Timestamp;

public class PCommentDto {
	int pb_cnum,pb_num;
	String pb_cnick, pb_ccontent;
	Timestamp pb_cdate;
	public int getpb_cnum() {
		return pb_cnum;
	}
	public void setpb_cnum(int pb_cnum) {
		this.pb_cnum = pb_cnum;
	}
	public int getpb_num() {
		return pb_num;
	}
	public void setpb_num(int pb_num) {
		this.pb_num = pb_num;
	}
	public String getpb_cnick() {
		return pb_cnick;
	}
	public void setpb_cnick(String pb_cnick) {
		this.pb_cnick = pb_cnick;
	}
	public String getpb_ccontent() {
		return pb_ccontent;
	}
	public void setpb_ccontent(String pb_ccontent) {
		this.pb_ccontent = pb_ccontent;
	}
	public Timestamp getpb_cdate() {
		return pb_cdate;
	}
	public void setpb_cdate(Timestamp pb_cdate) {
		this.pb_cdate = pb_cdate;
	}
	
	

}
