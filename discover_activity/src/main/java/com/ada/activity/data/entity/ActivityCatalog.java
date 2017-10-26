package com.ada.activity.data.entity;

import com.ada.data.entity.CatalogEntity;

import javax.persistence.*;
import java.util.List;


/**
 * 活动分类
 * 
 * @author 年高
 *
 */

@Entity
@Table(name = "activity_catalog")
public class ActivityCatalog extends CatalogEntity {
	
	/**
	 * 父分类
	 */
	@JoinColumn(name = "pid")
	@ManyToOne
	private ActivityCatalog parent;
	
	
	/**
	 * 子分类
	 */
	@OneToMany(mappedBy = "parent", fetch = FetchType.LAZY)
	private List<ActivityCatalog> childrens;


	@Override
	public Integer getParentId() {
		if (parent != null) {
			return parent.getId();
		}
		return null;
	}


	public ActivityCatalog getParent() {
		return parent;
	}


	public void setParent(ActivityCatalog parent) {
		this.parent = parent;
	}


	public List<ActivityCatalog> getChildrens() {
		return childrens;
	}


	public void setChildrens(List<ActivityCatalog> childrens) {
		this.childrens = childrens;
	}

}
