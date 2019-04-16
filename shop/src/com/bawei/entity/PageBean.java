package com.bawei.entity;

import java.util.List;

public class PageBean<T> {
	private List<T> list;		//保存当前数数据对象
	private int pageNum;		//页号
	private int pageSize;		//页大小
	private int recordCount;	//总记录条数
	private int pageCount;		//总页数
	private int startIndex;		//起始下标
	
	public List<T> getList() {
		return list;
	}
	public void setList(List<T> list) {
		this.list = list;
	}
	public int getPageNum() {
		return pageNum;
	}
	public void setPageNum(int pageNum) {
		this.pageNum = pageNum;
	}
	public int getPageSize() {
		return pageSize;
	}
	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}
	public int getRecordCount() {
		return recordCount;
	}
	public void setRecordCount(int recordCount) {
		this.recordCount = recordCount;
	}
	public int getPageCount() {
		pageCount = ( recordCount/pageSize ) + ( recordCount%pageSize==0?0:1 );
		return pageCount;
	}
	public void setPageCount(int pageCount) {
		this.pageCount = pageCount;
	}
	public int getStartIndex() {
		startIndex = (pageNum-1)*pageSize;
		return startIndex;
	}
	public void setStartIndex(int startIndex) {
		this.startIndex = startIndex;
	}
}
