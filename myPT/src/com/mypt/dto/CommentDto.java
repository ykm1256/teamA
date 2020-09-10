package com.mypt.dto;

import java.sql.Timestamp;

public class CommentDto {
	int boardNum, c_num;
	String c_nick, c_content;
	Timestamp c_date;
	
	public int getBoardNum() {
		return boardNum;
	}
	public void setBoardNum(int boardNum) {
		this.boardNum = boardNum;
	}
	public int getC_num() {
		return c_num;
	}
	public void setC_num(int c_num) {
		this.c_num = c_num;
	}
	public String getC_nick() {
		return c_nick;
	}
	public void setC_nick(String c_nick) {
		this.c_nick = c_nick;
	}
	public String getC_content() {
		return c_content;
	}
	public void setC_content(String c_content) {
		this.c_content = c_content;
	}
	public Timestamp getC_date() {
		return c_date;
	}
	public void setC_date(Timestamp c_date) {
		this.c_date = c_date;
	}
	

	
	

}
