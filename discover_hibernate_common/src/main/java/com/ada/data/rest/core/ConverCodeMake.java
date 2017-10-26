package com.ada.data.rest.core;

import java.beans.BeanInfo;
import java.beans.IntrospectionException;
import java.beans.Introspector;
import java.beans.PropertyDescriptor;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class ConverCodeMake {

	public void make(Class<?> result, Class<?> source) {
		Field[] rfields = result.getDeclaredFields();

		Field[] fields = source.getDeclaredFields();
		List<Field> f = new ArrayList<Field>();
		Collections.addAll(f, fields);

		if (rfields != null) {
			for (Field field : rfields) {
				if (contains(f, field)) {
					field.setAccessible(true);
					System.out.println(field);

				}

			}
		}

	}

	public void make2(Class<?> result, Class<?> source) {
		BeanInfo resultInfo;
		BeanInfo sourceInfo;
		List<PropertyDescriptor> ps = new ArrayList<PropertyDescriptor>();
		try {
			resultInfo = Introspector.getBeanInfo(result);
			sourceInfo = Introspector.getBeanInfo(source);
			PropertyDescriptor[] descritors = resultInfo.getPropertyDescriptors();// 获得
			PropertyDescriptor[] sdescritors = sourceInfo.getPropertyDescriptors();// 获得

			if (descritors != null) {
				for (PropertyDescriptor propertyDescriptor : descritors) {
					if (!contains(sdescritors, propertyDescriptor)) {
						if (propertyDescriptor.getName().equals("code")||propertyDescriptor.getName().equals("msg")) {
							
						}else{
							ps.add(propertyDescriptor);
						}
						continue;
					}

					if (propertyDescriptor.getWriteMethod() != null) {

						StringBuffer buffer = new StringBuffer();
						buffer.append("result." + propertyDescriptor.getWriteMethod().getName());
						buffer.append("(");
						buffer.append("source." + propertyDescriptor.getReadMethod().getName());
						buffer.append("());");
						System.out.println(buffer);
					} else {
						// System.out.println("erro:"+propertyDescriptor.getDisplayName());

					}
				}

			}

		} catch (IntrospectionException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		if (ps.size() > 0) {
			System.out.println("*********没有设置的值*****************");
			for (PropertyDescriptor propertyDescriptor : ps) {
				StringBuffer buffer = new StringBuffer();
				buffer.append("result." + propertyDescriptor.getWriteMethod().getName());
				buffer.append("(");
				buffer.append("source." + propertyDescriptor.getReadMethod().getName());
				buffer.append("());");
				System.out.println(buffer);			}

		}

	}

	public static void main(String[] args) {
		ConverCodeMake make = new ConverCodeMake();

	}


	public boolean contains(List<Field> fs, Field field) {
		boolean result = false;

		for (Field item : fs) {
			if (item.getName().equals(field.getName())) {
				result = true;
				break;
			}
		}
		return result;

	}

	public boolean contains(PropertyDescriptor[] sdescritors, Field field) {
		boolean result = false;

		for (PropertyDescriptor item : sdescritors) {
			if (item.getName().equals(field.getName())) {
				result = true;
				break;
			}
		}
		return result;

	}

	public boolean contains(PropertyDescriptor[] sdescritors, PropertyDescriptor field) {
		boolean result = false;

		for (PropertyDescriptor item : sdescritors) {
			if (item.getName().equals(field.getName())) {
				result = true;
				break;
			}
		}
		return result;

	}

	public boolean contains(PropertyDescriptor[] sdescritors, String field) {
		boolean result = false;

		for (PropertyDescriptor item : sdescritors) {
			if (item.getName().equals(field)) {
				result = true;
				break;
			}
		}
		return result;

	}

}
