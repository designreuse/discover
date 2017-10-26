package com.ada.quartz.data.factory;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Component;

@Component
public class ObjectFactory implements ApplicationContextAware {

	
	private static BeanFactory factory;
	public static BeanFactory get(){
		if (factory==null) {
			factory=new ClassPathXmlApplicationContext("applicationContext.xml");
		}
		return factory;
	}

	@Override
	public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
		factory=applicationContext;
	}
}
