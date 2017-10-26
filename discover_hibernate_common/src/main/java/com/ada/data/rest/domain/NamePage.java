package com.ada.data.rest.domain;

import java.util.List;

/**
 * 简单返回名字+id的集合
 * 
 * @author 73552
 *
 */
public class NamePage  extends AbstractVo {


	private List<NameSimple> list;


	public List<NameSimple> getList() {
		return list;
	}

	public void setList(List<NameSimple> list) {
		this.list = list;
	}

}
