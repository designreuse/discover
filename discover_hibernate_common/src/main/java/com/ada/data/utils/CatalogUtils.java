package com.ada.data.utils;

import com.ada.data.entity.CatalogEntity;

public class CatalogUtils {

	public static void  updateParent(CatalogEntity bean,CatalogEntity parent ){
		if (bean.getParentId() != null) {
			if (parent != null) {
				if (parent.getLevelInfo() != null) {
					bean.setLevelInfo(parent.getLevelInfo() + 1);
				} else {
					parent.setLevelInfo(1);
					bean.setLevelInfo(2);
				}
				if (parent.getIds() != null) {
					bean.setIds(parent.getIds() + "," + bean.getId());
				} else {
					parent.setIds(parent.getId()+"");
					bean.setIds(parent.getId() + "," + bean.getId());
				}
			} else {
				bean.setLevelInfo(1);
				bean.setIds("" + bean.getId());
			}
		} else {
			bean.setLevelInfo(1);
			bean.setIds("" + bean.getId());
		}
	}
}
