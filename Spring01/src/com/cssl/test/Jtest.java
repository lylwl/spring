package com.cssl.test;

import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.cssl.controller.UserController;
import com.cssl.hello.Hello;
import com.cssl.hello.Hello2;
import com.cssl.pojo.Users;

class Jtest {
	@Test
	void testHello() {
		// 开启spring IOC
		ClassPathXmlApplicationContext ctx = new ClassPathXmlApplicationContext("applicationContext.xml");
		// 取出bean
		Hello bean = (Hello) ctx.getBean("hello");
		Hello bean2 = (Hello) ctx.getBean("hello");
		System.out.println("rs:"+(bean==bean2));
		// Hello bean2 = ctx.getBean("hello2",Hello.class);
		System.out.println(bean);
		//关闭容器 调用销毁方法--只针对单列（系统默认就是单列）
		ctx.close();
	}
	
	@Test
	void testAll() {
		// 开启spring IOC
		ClassPathXmlApplicationContext ctx = new ClassPathXmlApplicationContext("applicationContext.xml");
		UserController bean = ctx.getBean(UserController.class);
		Users users = new Users(100,"冲哥");
		
		bean.regUser(users);
		
	}
	
	//测试注解
	@Test
	void testAno() {
		// 开启spring IOC
		ClassPathXmlApplicationContext ctx = new ClassPathXmlApplicationContext("beans.xml");
		Hello2 bean = ctx.getBean(Hello2.class);
		//System.out.println("beans:"+bean);
		//bean.print();
		Hello2 bean2 = ctx.getBean(Hello2.class);
		//System.out.println("beans:"+bean);
		System.out.println(bean==bean2);
		
		//销毁容器
		ctx.destroy();
		
		
	}
	
	
	//测试注解 整个项目
		@Test
		void testAllAno() {
			// 开启spring IOC
			ClassPathXmlApplicationContext ctx = new ClassPathXmlApplicationContext("beans.xml");
			UserController bean = ctx.getBean(UserController.class);
			Users users = new Users(100,"冲哥爱盈盈····");
			
			bean.regUser(users);
			
			
			
		}

}
