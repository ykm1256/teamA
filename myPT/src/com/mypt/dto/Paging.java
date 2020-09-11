package com.mypt.dto;

import com.mypt.dao.CommentDao;

public class Paging 
{
	private int totalRecord;//총게시물수
	private int numPerPage, count;//페이지당 레코드 개수
	private int pagePerBlock;//블럭당 페이지 개수
	private int totalPage;//총 페이지 개수
	private int totalBlock;//총 블럭 개수
	private int nowPage;//현재 페이지. 
	private int nowBlock;//현재 블럭
	private int startNum; //시작할 글 번호
	
	public Paging() 
	{
		count= numPerPage = 20;
		pagePerBlock = 5;	
		
		totalPage= 0;
		totalBlock= 0;
		
		nowPage= 1;		
		nowBlock= 1; //nowpage필요함		
		startNum= 1;

	}

	public Paging(int numPerPage, int pagePerBlock) 
	{
		count= this.numPerPage = numPerPage;
		this.pagePerBlock = pagePerBlock;
	}

	
	public int getTotalRecord() 
	{					
		return totalRecord;
	}

	public void setTotalRecord(int totalRecord) 
	{
		this.totalRecord = totalRecord;
		
	}

	public int getNumPerPage() {
		return numPerPage;
	}

	public void setNumPerPage(int numPerPage) {
		this.numPerPage = numPerPage;
	}

	public int getPagePerBlock() {
		return pagePerBlock;
	}

	public void setPagePerBlock(int pagePerBlock) {
		this.pagePerBlock = pagePerBlock;
	}

	public int getTotalPage() 
	{		
		
		return totalPage;
	}

	public void setTotalPage(int totalPage) {
		this.totalPage = totalPage;
	}

	public int getTotalBlock() 
	{
		
		return totalBlock;
	}

	public void setTotalBlock(int totalBlock) {
		this.totalBlock = totalBlock;
	}

	public int getNowPage() {
		return nowPage;
	}

	public void setNowPage(int nowPage) {
		this.nowPage = nowPage;
	}

	public int getNowBlock() 
	{
				
		return nowBlock;
	}

	public void setNowBlock(int nowBlock) {
		this.nowBlock = nowBlock;
	}

	
	public int getStartNum() 
	{	
		return startNum;
	}

	public void setStartNum(int startNum) {
		this.startNum = startNum;
	}

		


	
	
	
}
