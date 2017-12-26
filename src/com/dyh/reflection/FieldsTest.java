package com.dyh.reflection;

import java.lang.reflect.Field;

/**
 * 测试类3 
 * @author dyh
 *
 *获取成员变量并调用： 
 *  		1.批量的 
 *      		1).Field[] getFields():获取所有的"公有字段" 
 *      		2).Field[] getDeclaredFields():获取所有字段，包括：私有、受保护、默认、公有； 
 * 		2.获取单个的： 
 *      		1).public Field getField(String fieldName):获取某个"公有的"字段； 
 *      		2).public Field getDeclaredField(String fieldName):获取某个字段(可以是私有的) 
 *  		设置字段的值： 
 *      		Field --> public void set(Object obj,Object value): 
 *                  参数说明： 
 *                  1.obj:要设置的字段所在的对象； 
 *                  2.value:要为字段设置的值； 
 *
 */

public class FieldsTest {

	public static void main(String[] args) throws Exception {
		//1、获取Class对象
		Class class1 = Class.forName("com.dyh.reflection.Student");
		
		//2、获取字段
		System.out.println("----------------获取所有的公有字段---------------");
		Field[] fieldArray = class1.getFields();
		for (Field field : fieldArray) {
			System.out.println(field);
		}
		
		System.out.println("----------------获取所有的字段------------------");
		fieldArray = class1.getDeclaredFields();
		for (Field field : fieldArray) {
			System.out.println(field);
		}
		
		System.out.println("----------------获取公有字段，并调用-------------");
		Field f = class1.getField("name");
		System.out.println(f);
		//获取一个对象,class1.getConstructor()--->得到公有、无参的类对象
		Object obj = class1.getConstructor().newInstance(); //产生Student对象--》Student stu = new Student();  
		
		//为字段设置值
		f.set(obj, "王大锤"); //为Student对象中的name属性赋值--》stu.name = "王大锤" 
		
		//验证
		Student student = (Student)obj;
		System.out.println("验证姓名：" + student.name);
		
		System.out.println("---------------获取私有字段，并调用--------------");
		f = class1.getDeclaredField("phoneNum");
		System.out.println(f);
		f.setAccessible(true); //暴力反射，解除私有限定
		f.set(obj, "12345678901");
		System.out.println("验证电话：" + student);
 		
	}

}
