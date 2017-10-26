package com.ada.data.rest.domain;

import java.util.List;

public class AbstractPageVo<T> extends AbstractVo {

	/**
	 * 数据集合
	 */
	private List<T> list;

	/**
	 * 第几页
	 */
	private int page;

	/**
	 * 分页大小
	 */
	private int size;

	/**
	 * 总量
	 */
	private int total;

	/**
	 * 总共有多少页
	 */
	private int totalPage;

	public List<T> getList() {
		return list;
	}

	public int getPage() {
		return page;
	}

	public int getSize() {
		return size;
	}

	public int getTotal() {
		return total;
	}

	public int getTotalPage() {
		return totalPage;
	}

	public void setList(List<T> list) {
		this.list = list;
	}

	public void setPage(int page) {
		this.page = page;
	}

	public void setSize(int size) {
		this.size = size;
	}

	public void setTotal(int total) {
		this.total = total;
	}

	public void setTotalPage(int totalPage) {
		this.totalPage = totalPage;
	}

	@Override
	public String toString() {
		return "PageVo [page=" + page + ", size=" + size + ", total=" + total + ", totalPage=" + totalPage
				+ ", toString()=" + super.toString() + "]";
	}

}
