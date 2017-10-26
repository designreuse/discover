package com.ada.data.entity;



import com.ada.common.hibernate.HibernateTree;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

/**
 * 分类基础类
 * 
 * @author 年高
 *
 */
@MappedSuperclass
public  abstract class CatalogEntity implements HibernateTree<Integer>, Serializable {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;

	/**
	 * 名称
	 */
	private java.lang.String name;

	
	/**
	 * 排序号
	 */
	private Integer sortNum;

	/**
	 * 编码
	 */
	@Column(length = 50)
	private String code;


	/**
	 * ids
	 */
	private java.lang.String ids;

	/**
	 * 左节点
	 */
	private java.lang.Integer lft;

	/**
	 * 右节点
	 */
	private java.lang.Integer rgt;

	/**
	 * 等级
	 */
	private Integer levelInfo;
	

	/**
	 * 添加时间
	 */
	private Date addDate;

	/**
	 * 最新修改时间
	 */
	private Date lastDate;
	
	public CatalogEntity(){
		addDate=new Date();
		lastDate=new Date();
	}
	
	public Date getAddDate() {
		return addDate;
	}

	public void setAddDate(Date addDate) {
		this.addDate = addDate;
	}

	public Date getLastDate() {
		return lastDate;
	}

	public void setLastDate(Date lastDate) {
		this.lastDate = lastDate;
	}

	@Override
	public Integer getId() {
		return id;
	}

	public java.lang.String getIds() {
		return ids;
	}

	@Override
	public java.lang.Integer getLft() {
		return lft;
	}

	/**
	 * @see HibernateTree#getLftName()
	 */
	@Override
	public String getLftName() {
		return DEF_LEFT_NAME;
	}

	public java.lang.String getName() {
		return name;
	}



	/**
	 * @see HibernateTree#getParentName()
	 */
	@Override
	public String getParentName() {
		return DEF_PARENT_NAME;
	}

	@Override
	public java.lang.Integer getRgt() {
		return rgt;
	}

	/**
	 * @see HibernateTree#getRgtName()
	 */
	@Override
	public String getRgtName() {
		return DEF_RIGHT_NAME;
	}


	@Override
	public String getTreeCondition() {
		return null;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public void setIds(java.lang.String ids) {
		this.ids = ids;
	}


	@Override
	public void setLft(java.lang.Integer lft) {
		this.lft = lft;
	}

	public void setName(java.lang.String name) {
		this.name = name;
	}


	@Override
	public void setRgt(java.lang.Integer rgt) {
		this.rgt = rgt;
	}


	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		return result;
	}

	public Integer getSortNum() {
		return sortNum;
	}

	public void setSortNum(Integer sortNum) {
		this.sortNum = sortNum;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		CatalogEntity other = (CatalogEntity) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public Integer getLevelInfo() {
		return levelInfo;
	}

	public void setLevelInfo(Integer levelInfo) {
		this.levelInfo = levelInfo;
	}
}
