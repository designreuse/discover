package com.ada.album.data.service;

import com.ada.album.data.entity.Album;
import com.ada.data.page.Filter;
import com.ada.data.page.Order;
import com.ada.data.page.Page;
import com.ada.data.page.Pageable;
import java.util.List;

/**
* Created by imake on 2017年08月15日10:04:54.
*/
public interface AlbumService {

	Album findById(Long id);

	Album save(Album bean);

	Album update(Album bean);

	Album deleteById(Long id);
	
	Album[] deleteByIds(Long[] ids);
	
	Page<Album> page(Pageable pageable);
	
	Page<Album> page(Pageable pageable, Object search);


	List<Album> list(int first, Integer size, List<Filter> filters, List<Order> orders);

}