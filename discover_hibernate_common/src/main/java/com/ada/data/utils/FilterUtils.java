package com.ada.data.utils;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;

import com.ada.data.page.Condition;
import org.apache.commons.lang3.StringUtils;

import com.ada.data.page.Filter;
import com.ada.data.page.Search;
import com.ada.data.page.Filter.Operator;

public class FilterUtils {

	public static List<Filter> getFilters(Object search) {
		List<Filter> filters = new ArrayList<Filter>();
		if (search == null) {
			return filters;
		}

		Field[] fields = search.getClass().getDeclaredFields();
		for (Field field : fields) {
			Search item = field.getAnnotation(Search.class);
			if (item != null) {
				field.setAccessible(true);
				Filter filter;
				try {
					Object object = field.get(search);
					if (object == null) {
						continue;
					}
					if (object instanceof String) {
						String oString = (String) object;
						if (StringUtils.isBlank(oString)) {
							continue;
						}
					}


					if (item.operator() == Operator.like) {
						filter = new Filter(item.name(), item.operator(), "%" + object + "%");
						filter.setPrefix(item.prefix());
					} else {
						filter = new Filter(item.name(), item.operator(), object);
						filter.setPrefix(item.prefix());
					}

					if (item.condition()== Condition.AND){
						filter.setCondition("and");
					}else {
						filter.setCondition("or");
					}
					filters.add(filter);
				} catch (IllegalArgumentException e) {
					e.printStackTrace();
				} catch (IllegalAccessException e) {
					e.printStackTrace();
				}
			}
		}
		return filters;
	}
}
