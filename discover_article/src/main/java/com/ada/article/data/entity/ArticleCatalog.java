package com.ada.article.data.entity;

import com.ada.data.entity.CatalogEntity;

import javax.persistence.*;
import java.util.List;

/**
 * 文章分类
 * 
 * @author 年高
 *
 */
@Entity
@Table(name = "article_catalog")
public class ArticleCatalog extends CatalogEntity {

	/**
	 * 父节点
	 */
	@JoinColumn(name = "pid")
	@ManyToOne
	private ArticleCatalog parent;

	/**
	 * 数量
	 */
	private Long nums;

	@OneToMany(mappedBy = "parent", fetch = FetchType.LAZY)
	private List<ArticleCatalog> childrens;

	@Override
	public Integer getParentId() {
		if (parent != null) {
			return parent.getId();
		}
		return null;
	}

	public ArticleCatalog getParent() {
		return parent;
	}

	public void setParent(ArticleCatalog parent) {
		this.parent = parent;
	}

	public List<ArticleCatalog> getChildrens() {
		return childrens;
	}

	public void setChildrens(List<ArticleCatalog> childrens) {
		this.childrens = childrens;
	}

	public Long getNums() {
		return nums;
	}

	public void setNums(Long nums) {
		this.nums = nums;
	}

}
