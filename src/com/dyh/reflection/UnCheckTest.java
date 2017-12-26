package com.dyh.reflection;

import java.lang.reflect.Method;
import java.util.ArrayList;

/**
 * 测试类8
 * @author dyh
 *
 * 通过反射越过泛型检查
 * 泛型用在编译期，编译过后泛型擦除（消失掉）。所以是可以通过反射越过泛型检查的
 */

public class UnCheckTest {

	//例如：有一个String泛型的集合，怎样能向这个集合中添加一个Integer类型的值？ 
	public static void main(String[] args) throws Exception{
		ArrayList<String> strList = new ArrayList<>();
		strList.add("aaa");
		strList.add("bbb");
		
		//获取ArrayList的Class对象，反向的调用add()方法，添加数据  
		Class class1 = strList.getClass(); //得到 strList 对象的字节码对象  
		//获取add()方法
		Method method = class1.getMethod("add", Object.class);
		//调用add()方法
		method.invoke(strList, 100);
		
		for (Object obj : strList) {
			System.out.println(obj);
		}
		
	}

}
