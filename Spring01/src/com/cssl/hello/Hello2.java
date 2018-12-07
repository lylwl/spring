package com.cssl.hello;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;
@Component("hlloe")//组件
//@Scope("prototype")
public class Hello2 {
	@Value("1000") //spEL
	private int id=1000;
	//@Value("#{UD.GET()}")
	private String name;
	
	private List<String> list;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		System.out.println("我曾经给老朱注入值");
		this.name = name;
	}
	public List<String> getList() {
		return list;
	}
	public void setList(List<String> list) {
		this.list = list;
	}
	
	
	public Hello2() {
		System.out.println("hello  无参构造函数");
	}
	public Hello2(int id, String name, List<String> list) {
		System.out.println("hello  有参----构造函数");
		this.id = id;
		this.name = name;
		this.list = list;
	}
	@Override
	public String toString() {
		return "Hello [id=" + id + ", name=" + name + ", list=" + list + "]";
	}
	
	
	//定义方法
	//初始化方法 无返回值 无参数
	@PostConstruct
	public void init() {
		System.out.println("初始化····ddddddddddddddd··");
	}
	
	@PreDestroy
	public void destroy() {
		System.out.println("销毁···ddddddddddddddddddd···");
	}
	
	
	public void print() {
		System.out.println("我是老朱，叫我宝宝");
	}
	
	
	
	

}
