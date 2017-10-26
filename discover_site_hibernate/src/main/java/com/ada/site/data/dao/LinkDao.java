package com.ada.site.data.dao;


import  com.ada.data.core.BaseDao;
import  com.ada.data.core.Updater;
import  com.ada.site.data.entity.Link;

/**
* Created by imake on 2017年07月25日11:33:24.
*/
public interface LinkDao extends BaseDao<Link,Long>{

	public Link findById(Long id);

	public Link save(Link bean);

	public Link updateByUpdater(Updater<Link> updater);

	public Link deleteById(Long id);
}