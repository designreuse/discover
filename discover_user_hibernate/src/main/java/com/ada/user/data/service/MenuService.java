package com.ada.user.data.service;

import com.ada.user.data.entity.Menu;
import com.ada.data.page.Filter;
import com.ada.data.page.Order;
import com.ada.data.page.Page;
import com.ada.data.page.Pageable;
import java.util.List;

/**
* Created by imake on 2017年07月21日14:37:30.
*/
public interface MenuService {

	public Menu findById(Integer id);

	public Menu save(Menu bean);

	public Menu update(Menu bean);

	public Menu deleteById(Integer id);
	
	public Menu[] deleteByIds(Integer[] ids);
	

	public Page<Menu> page(Pageable pageable);
	
	public Page<Menu> page(Pageable pageable, Object search);


	public	List<Menu> findByTops(Integer pid);
	public  List<Menu> list(int first, Integer size, List<Filter> filters, List<Order> orders);

    List<Menu> childs(Integer id);

	List<Menu> findChildMenu(Integer id);

	List<Menu> findChild(Integer id);
}