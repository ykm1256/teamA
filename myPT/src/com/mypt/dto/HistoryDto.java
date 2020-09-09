package com.mypt.dto;

public class HistoryDto {
	private String hid;
	private String paydate;
	private int price;
	private int hcount;
	private String t_id;

	

	// 월, 트레이너이름, 수입 추가, 회원수 (윤)
	private int month;
	private int income;
	private int usercnt;
	private String t_name;

	public int getMonth() {
		return month;
	}

	public void setMonth(int month) {
		this.month = month;
	}

	public String getT_name() {
		return t_name;
	}

	public void setT_name(String t_name) {
		this.t_name = t_name;
	}

	public int getIncome() {
		return income;
	}

	public void setIncome(int income) {
		this.income = income;
	}

	public int getUsercnt() {
		return usercnt;
	}

	public void setUsercnt(int usercnt) {
		this.usercnt = usercnt;
	}

	public String getHid() {
		return hid;
	}

	public void setHid(String hid) {
		this.hid = hid;
	}

	public String getPaydate() {
		return paydate;
	}

	public void setPaydate(String paydate) {
		this.paydate = paydate;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	public int getHcount() {
		return hcount;
	}

	public void setHcount(int hcount) {
		this.hcount = hcount;
	}
	
	public String getT_id() {
		return t_id;
	}

	public void setT_id(String t_id) {
		this.t_id = t_id;
	}

}
