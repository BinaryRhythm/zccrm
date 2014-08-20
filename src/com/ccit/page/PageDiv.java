package com.ccit.page;

import java.io.Serializable;
import java.util.List;

public class PageDiv<T extends Serializable>{

	private Integer pageSize;   // 每页多少条
	private Integer pageNo;     // 当前多少页
	private Integer totalCount; // 数据表总共多少记录
	private Integer totalPage; // 数据表总共多少页
	
	public List<T> list;   //当前页的记录列表
	public PageDiv(){}
	public PageDiv(Integer pageSize,Integer pageNo,Integer totalCount,List<T> list){
		this.pageNo = pageNo;
		this.pageSize = pageSize;
		this.totalCount = totalCount;
		this.list = list;
		this.totalPage = (totalCount+pageSize-1)/pageSize;
		
	}
	public Integer getPageSize() {
		return pageSize;
	}
	public void setPageSize(Integer pageSize) {
		this.pageSize = pageSize;
	}
	public Integer getPageNo() {
		return pageNo;
	}
	public void setPageNo(Integer pageNo) {
		this.pageNo = pageNo;
	}
	public Integer getTotalCount() {
		return totalCount;
	}
	public void setTotalCount(Integer totalCount) {
		this.totalCount = totalCount;
	}
	public Integer getTotalPage() {
		return totalPage;
	}
	public void setTotalPage(Integer totalPage) {
		this.totalPage = totalPage;
	}
	public List<T> getList() {
		return list;
	}
	public void setList(List<T> list) {
		this.list = list;
	}
	
	
	
}
