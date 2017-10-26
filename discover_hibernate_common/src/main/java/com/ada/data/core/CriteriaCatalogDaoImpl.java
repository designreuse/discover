package com.ada.data.core;

import java.io.Serializable;

import com.ada.data.entity.CatalogEntity;

@SuppressWarnings({ "rawtypes", "unchecked" })
public abstract class CriteriaCatalogDaoImpl<T, ID extends Serializable> extends CriteriaDaoImpl<T, ID>
		implements CriteriaDao<T, ID> {

	@Override
	public T add(T t) {
		getHibernateTemplate().save(t);
		if (t instanceof CatalogEntity) {
			CatalogEntity bean = (CatalogEntity) t;
			if (bean.getParentId() != null) {
				ID id = (ID) bean.getParentId();
				T pt = get(id);
				CatalogEntity parent = (CatalogEntity) pt;
				if (parent != null) {
					if (parent.getLevelInfo() != null) {
						bean.setLevelInfo(parent.getLevelInfo() + 1);
					} else {
						bean.setLevelInfo(2);
					}
					if (parent.getIds() != null) {
						bean.setIds(parent.getIds() + "," + bean.getId());

					} else {
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

		return t;
	}

}
