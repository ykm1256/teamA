package com.mypt.dto;

import com.mypt.dao.PboardDao;

public class PageingDto {
	
	private int totalRecord;	
	private int numPerPage;
	private int pagePerBlock;
	private int totalPage;
	private int totalBlock;
	private int nowPage;
	private int nowBlock;
	private int startPage;
	private int pageStart;
	private int pageEnd;
	
	public PageingDto() {}
	
	public PageingDto(int nowPage) {
		PboardDao pdao=PboardDao.getInstance();
		this.totalRecord=pdao.getTotalCount();
		this.numPerPage=9;
		this.pagePerBlock=5;
		this.totalPage=(int)Math.ceil((double)totalRecord/numPerPage);
		this.totalBlock=(int)Math.ceil((double)totalPage/pagePerBlock);
		this.nowPage=nowPage;
		this.nowBlock=(int)Math.ceil((double)nowPage/pagePerBlock);
		this.startPage=(nowPage*numPerPage)-numPerPage;
		this.pageStart=(nowBlock-1)*pagePerBlock+1;
		this.pageEnd=(pageStart+pagePerBlock)<totalPage?pageStart+pagePerBlock:totalPage+1;
	}
	public PageingDto(int nowPage,String keyField,String keyWord) {
		PboardDao pdao=PboardDao.getInstance();
		this.totalRecord=pdao.getTotalCount(keyField,keyWord);
		this.numPerPage=9;
		this.pagePerBlock=5;
		this.totalPage=(int)Math.ceil((double)totalRecord/numPerPage);
		this.totalBlock=(int)Math.ceil((double)totalPage/pagePerBlock);
		this.nowPage=nowPage;
		this.nowBlock=(int)Math.ceil((double)nowPage/pagePerBlock);
		this.startPage=(nowPage*numPerPage)-numPerPage;
		this.pageStart=(nowBlock-1)*pagePerBlock+1;
		this.pageEnd=(pageStart+pagePerBlock)<totalPage?pageStart+pagePerBlock:totalPage+1;
	}

	public int getTotalRecord() {
		return totalRecord;
	}

	public void setTotalRecord(int totalRecord) {
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

	public int getTotalPage() {
		return totalPage;
	}

	public void setTotalPage(int totalPage) {
		this.totalPage = totalPage;
	}

	public int getTotalBlock() {
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

	public int getNowBlock() {
		return nowBlock;
	}

	public void setNowBlock(int nowBlock) {
		this.nowBlock = nowBlock;
	}

	public int getStartPage() {
		return startPage;
	}

	public void setStartPage(int startPage) {
		this.startPage = startPage;
	}

	public int getPageStart() {
		return pageStart;
	}

	public void setPageStart(int pageStart) {
		this.pageStart = pageStart;
	}

	public int getPageEnd() {
		return pageEnd;
	}

	public void setPageEnd(int pageEnd) {
		this.pageEnd = pageEnd;
	}
	
	
	
}
