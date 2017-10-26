package com.ada.user.data.service.impl;

import com.ada.data.core.Finder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ada.data.core.Updater;
import com.ada.user.data.dao.MenuDao;
import com.ada.user.data.entity.Menu;
import com.ada.user.data.service.MenuService;

import com.ada.data.page.Filter;
import com.ada.data.page.Order;
import com.ada.data.page.Page;
import com.ada.data.page.Pageable;
import java.util.List;
import java.util.LinkedList;
import com.ada.data.utils.FilterUtils;


/**
* Created by imake on 2017年07月21日14:37:30.
*/
@Service
@Transactional
public class MenuServiceImpl implements MenuService {

	private MenuDao dao;


	@Override
	public List<Menu> findChildMenu(Integer id) {
		Finder finder = Finder.create("from Menu t where t.parent.id=" + id);
		finder.append(" and t.catalog =0 ");
		finder.append(" order by t.sortNum asc");
		finder.setCacheable(true);
		List ms = dao.find(finder);
		return ms;
	}

	@Override
	public List<Menu> findChild(Integer id) {
		Finder finder = Finder.create("from Menu t where t.parent.id=" + id);
		finder.append(" order by t.sortNum asc");
		finder.setCacheable(true);
		List ms = dao.find(finder);
		return ms;
	}


	@Override
	public List<Menu> childs(Integer id) {
		List<Menu> ms = null;
		Menu menu = dao.findById(id);
		if (menu != null) {
			Finder finder = Finder.create("from Menu t where t.lft >=:lft and t.rgt<=:rgt ");
			finder.append(" order by t.lft asc");
			finder.setParam("lft", menu.getLft());
			finder.setParam("rgt", menu.getRgt());
			finder.setCacheable(false);
			ms = dao.find(finder);
		}

		return ms;
	}

	@Override
	@Transactional(readOnly = true)
	public Menu findById(Integer id) {
		return dao.findById(id);
	}

	@Override
	public List<Menu> findByTops(Integer pid) {
		LinkedList<Menu> result = new LinkedList<Menu>();
		Menu catalog = dao.findById(pid);
	    if(catalog != null){
			while ( catalog != null && catalog.getParent() != null ) {
				result.addFirst(catalog);
				catalog = dao.findById(catalog.getParentId());
			}
			result.addFirst(catalog);
	    }
		return result;
	}

	@Override
    @Transactional
	public Menu save(Menu bean) {
		dao.save(bean);
		return bean;
	}

	@Override
    @Transactional
	public Menu update(Menu bean) {
		Updater<Menu> updater = new Updater<Menu>(bean);
		return dao.updateByUpdater(updater);
	}

	@Override
    @Transactional
	public Menu deleteById(Integer id) {
		Menu bean = dao.findById(id);
        dao.deleteById(id);
		return bean;
	}

	@Override
    @Transactional	
	public Menu[] deleteByIds(Integer[] ids) {
		Menu[] beans = new Menu[ids.length];
		for (int i = 0,len = ids.length; i < len; i++) {
			beans[i] = deleteById(ids[i]);
		}
		return beans;
	}


	@Autowired
	public void setDao(MenuDao dao) {
		this.dao = dao;
	}

	@Override
    public Page<Menu> page(Pageable pageable){
         return dao.page(pageable);
    }


    @Override
	public Page<Menu> page(Pageable pageable, Object search) {
		List<Filter> filters=	FilterUtils.getFilters(search);
		if (filters!=null) {
			pageable.getFilters().addAll(filters);
		}
		return dao.page(pageable);
	}

    @Override
    public List<Menu> list(int first, Integer size, List<Filter> filters, List<Order> orders) {
        return dao.list(first,size,filters,orders);}

}