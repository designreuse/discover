package com.ada.data.page;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import com.ada.data.page.Filter.Operator;
import com.ada.data.page.Order.Direction;

/**
 * 搜索条件
 * 
 * @author ada
 *
 */

@Target({ ElementType.FIELD })
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface Search {

	/**
	 * 表达式操作符
	 * 
	 * @return
	 */
	Operator operator() default Operator.eq;

	/**
	 * bean对象属性
	 * 
	 * @return
	 */
	String name() default "";

	/**
	 * 表达式前缀
	 */
	String prefix() default "";

	/**
	 * 计算条件，且和或，默认为且
	 */
	Condition condition() default Condition.AND;

}
