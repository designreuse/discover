package com.ada.data.rest.domain;

import java.util.List;

/**
 * 简单返回名字+id的集合
 * 
 * @author 73552
 *
 */
public class NamePinYinPage  extends AbstractVo {


	private List<NamePinYinSimple> list;

	public List<NamePinYinSimple> getList() {
		return list;
	}

	public void setList(List<NamePinYinSimple> list) {
		this.list = list;
	}

}
