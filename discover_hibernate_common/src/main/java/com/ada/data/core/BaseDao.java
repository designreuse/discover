package com.ada.data.core;

import java.io.Serializable;
import java.util.List;

import org.hibernate.Criteria;

import com.ada.data.page.Filter;
import com.ada.data.page.Order;
import com.ada.data.page.Page;
import com.ada.data.page.Pageable;

public interface BaseDao<T, ID extends Serializable> {

	/**
	 * 根据条件查询数据，返回分页结果
	 * 
	 * @param pageable 分页条件
	 * @return
	 */
	Page<T> page(Pageable pageable);

	/**
	 * 分页方法<p></p>
	 * 请采用{@link com.ada.data.core.BaseDao#page(Pageable)}
	 * @param pageable
	 * @return
	 */
	@Deprecated
	Pagination<T> findByPage(Pageable pageable);

	List<T> list(Integer first, Integer count, List<Filter> filters, List<Order> orders);

	T add(T t);

	T delete(T t);

	T update(T t);

	T merge(T t);

	T findOne(Finder finder);

	@Deprecated
	Pagination<T> find(Finder finder, int pageNo, int pageSize);

	<X> Pagination<X> findSql(Finder finder, int pageNo, int pageSize, Class<X> otoclass);

	List<T> find(Finder finder);

	Pagination<T> findByCriteria(Criteria crit, int pageNo, int pageSize);

	List<T> find(String hql, Object... values);


	List<T> filters(Filter ... filters);


	List<T> findByProperty(String property, Object value);

	int countQueryResult(Finder finder);

	Long countQuery(Finder finder);

	int countQuerySqlResult(Finder finder);

	<X> X hql(Finder finder);

	/**
	 * hibernate 转换成sql
	 * 
	 * @param hql
	 * @return
	 */
	String transHqlToSql(String hql);

	/**
	 * 
	 * @param sql
	 *            sql语句
	 * @param otoclass
	 *            需要转化的对象
	 * @return
	 */
	<X> List<X> listSQL(String sql, Class<X> otoclass);

	<X> List<X> listSQL(String sql, Integer stat, Integer max, Class<X> otoclass);

	/**
	 * 
	 * @param sql
	 *            sql语句
	 * @param otoclass
	 *            需要转化的对象
	 * @return
	 */
	<X> X oneSQL(String sql, Class<X> otoclass);

}