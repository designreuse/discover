package com.ada.data.rest.domain;

import java.util.List;

/**
 * 简单返回名字+id的集合
 * 
 * @author 73552
 *
 */
public class NameIntPage extends AbstractVo {


	private List<NameIntSimple> list;


	public List<NameIntSimple> getList() {
		return list;
	}

	public void setList(List<NameIntSimple> list) {
		this.list = list;
	}

}
