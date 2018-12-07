package com.cssl.hello;

import java.util.List;

public class Hello {
	
	private int id;
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
	
	
	public Hello() {
		System.out.println("hello  无参构造函数");
	}
	public Hello(int id, String name, List<String> list) {
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
	public void init() {
		System.out.println("初始化······");
	}
	public void destroy() {
		System.out.println("销毁······");
	}
	
	
	
	
	

}
