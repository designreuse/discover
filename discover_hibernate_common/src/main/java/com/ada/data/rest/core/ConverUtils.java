package com.ada.data.rest.core;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import com.ada.data.core.Pagination;
import com.ada.data.page.Page;
import com.ada.data.rest.domain.AbstractPageVo;

public class ConverUtils {

	/**
	 * 从一个对象转换到例外一个对象
	 * 
	 * @param result
	 * @param pager
	 */
	public static <R, S> void cover(AbstractPageVo<R> result, Pagination<S> pager) {
		result.setPage(pager.getPageNo());
		result.setSize(pager.getPageSize());
		result.setTotal(pager.getTotalCount());
		result.setTotalPage(pager.getTotalPage());
	}

	public static <R, S> void cover(AbstractPageVo<R> result, Page<S> pager) {
		result.setPage(pager.getPageNumber());
		result.setSize(pager.getPageSize());
		result.setTotal((int) pager.getTotal());
		result.setTotalPage(pager.getTotalPages());
	}

	public static <R, S> AbstractPageVo<R> coverpage(AbstractPageVo<R> result, Pagination<S> pager, Conver<R, S> conver) {
		cover(result, pager);
		List<R> vos = new ArrayList<R>();
		List<S> cs = pager.getList();
		if (cs != null) {
			for (S classRoom : cs) {
				vos.add(conver.conver(classRoom));
			}
		}
		result.setList(vos);
		return result;
	}

	public static <R, S> AbstractPageVo<R> coverPage(AbstractPageVo<R> result, Page<S> pager, Conver<R, S> conver) {
		cover(result, pager);
		List<R> vos = new ArrayList<R>();
		List<S> cs = pager.getContent();
		if (cs != null) {
			for (S classRoom : cs) {
				vos.add(conver.conver(classRoom));
			}
		}
		result.setList(vos);
		return result;
	}
	
	/**
	 * 转换集合功能
	 * 
	 * @param source
	 *            转化源
	 * @param conver
	 *            转化器
	 * @return 转换后的集合
	 */
	public static <R, S> List<R> coverList(List<S> source, Conver<R, S> conver) {
		List<R> vos = new ArrayList<R>();
		if (source != null) {
			for (S item : source) {
				vos.add(conver.conver(item));
			}
		}
		return vos;
	}

	
	public static <R, S> List<R> coverCollect(Collection<S> source, Conver<R, S> conver) {
		List<R> vos = new ArrayList<R>();
		if (source != null) {
			for (S item : source) {
				vos.add(conver.conver(item));
			}
		}
		return vos;
	}

}
