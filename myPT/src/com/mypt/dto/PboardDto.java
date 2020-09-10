package com.mypt.dto;

import java.util.ArrayList;

public class PboardDto extends BoardDto
{
	private String photo;
	private int like;
	private ArrayList<CommentDto> comments;
	
	public PboardDto() {}
	
	public PboardDto(ArrayList<CommentDto> comments) 
	{
		this.comments = comments;
	}
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

	public ArrayList<CommentDto> getComments() {
		return comments;
	}

	public void setComments(ArrayList<CommentDto> comments) {
		this.comments = comments;
	}	
	
	
	
	
}
