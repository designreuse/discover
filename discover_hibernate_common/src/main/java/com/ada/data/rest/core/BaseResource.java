package com.ada.data.rest.core;

import com.ada.data.core.Pagination;
import com.ada.data.rest.domain.AbstractPageVo;

/**
 * 资源转换服务
 * 
 * @author ada
 *
 * @param <R>
 *            目标
 * @param <S>
 *            源对象
 * @param <PVo>
 *            目标分页对象
 */
public abstract class BaseResource<R, S, PVo extends AbstractPageVo<R>> {

	public abstract Conver<R, S> getConver();

	public PVo page(Pagination<S> pager) {
		PVo result = getPageVo();

		ConverUtils.coverpage(result, pager, getConver());

		return result;

	}

	public abstract PVo getPageVo();
}
