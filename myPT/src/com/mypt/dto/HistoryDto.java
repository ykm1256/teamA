package com.mypt.dto;

public class HistoryDto {
	private String hid;
	private String paydate;
	private int price;
	private int hcount;
	private String trainer;

	// 월, 트레이너, 수입 추가, 회원수 (윤)
	private int month;
	private int income;
	private int usercnt;

	public int getMonth() {
		return month;
	}

	public void setMonth(int month) {
		this.month = month;
	}

	public String getTrainer() {
		return trainer;
	}

	public void setTrainer(String trainer) {
		this.trainer = trainer;
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

}
