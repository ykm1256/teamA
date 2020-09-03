package com.mypt.dto;

public class PboardDto extends BoardDto
{
	private String photo;
	private int like;
	
	public String getPhoto() {
		return photo == null ? "" : photo.trim();
	}
	public void setPhoto(String photo) {
		this.photo = photo;
	}
	public int getLike() {
		return like;
	}
	public void setLike(int like) {
		this.like = like;
	}	
	
	
}
