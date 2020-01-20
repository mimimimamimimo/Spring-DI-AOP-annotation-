package com.springbook.ioc.injection;

import java.util.List;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

public class CollectionBeanClient {
	
	public static void main(String args[]) {
		AbstractApplicationContext factory=new GenericXmlApplicationContext("context.xml");
		CollectionBean bean=(CollectionBean) factory.getBean("collectionBean");
		List<String> addresslist=bean.getAddressList();
		
		for(String str:addresslist) {
			System.out.println(str.toString());
		}
		factory.close();
	}
}
