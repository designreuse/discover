package com.ada.data.rest.core;

/**
 * 数据转换接口
 * 
 * @author ada
 *
 * @param <R> 结果类
 * @param <S> 需要转换的类
 */
public interface Conver<R, S> {

	R conver(S source);
}
