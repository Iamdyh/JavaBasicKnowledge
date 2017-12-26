package com.dyh.reflection;

import java.lang.reflect.Method;

/**
 * 测试类4
 * @author dyh
 * 
 * 获取成员方法并调用： 
 *  
 * 1.批量的： 
 *      public Method[] getMethods():获取所有"公有方法"；（包含了父类的方法也包含Object类） 
 *      public Method[] getDeclaredMethods():获取所有的成员方法，包括私有的(不包括继承的) 
 * 2.获取单个的： 
 *      public Method getMethod(String name,Class<?>... parameterTypes): 
 *                  参数： 
 *                      name : 方法名； 
 *                      Class ... : 形参的Class类型对象 
 *      public Method getDeclaredMethod(String name,Class<?>... parameterTypes) 
 *  
 *   调用方法： 
 *      Method --> public Object invoke(Object obj,Object... args): 
 *                  参数说明： 
 *                  obj : 要调用方法的对象； 
 *                  args:调用方式时所传递的实参； 
 
 *
 */

public class MethodTest {

	public static void main(String[] args) throws Exception {
		//1、获取Class对象
		Class class1 = Class.forName("com.dyh.reflection.Student");
		
		//2、获取方法
		System.out.println("-------------------获取所有公有方法-----------------");
		Method[] methods = class1.getMethods();
		for (Method method : methods) {
			System.out.println(method);
		}
		
		System.out.println("-------------------获取所有方法--------------------");
		methods = class1.getDeclaredMethods();
		for (Method method : methods) {
			System.out.println(method);
		}
		
		System.out.println("------------------获取公有的show1()方法------------");
		Method method  = class1.getMethod("show1", String.class); //show1表示方法的名字，String.class表示参数的类型
		System.out.println(method);
		
		//实例化一个Student对象
		Object object = class1.getConstructor().newInstance();
		method.invoke(object, "王大锤");
		
		System.out.println("------------------获取私有的show4()方法------------");
		method = class1.getDeclaredMethod("show4", int.class);
		System.out.println(method);
		method.setAccessible(true); //解除私有限定
		Object res = method.invoke(object, 20); //需要两个参数，一个是要调用的对象（获取有反射），一个是实参 
		System.out.println("返回值：" + res);
	}

}
