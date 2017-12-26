package com.dyh.reflection;

import java.io.FileReader;
import java.lang.reflect.Method;
import java.util.Properties;

/**
 * 测试类7 
 * @author dyh
 *
 * 通过反射运行配置文件内容：
 *	  我们利用反射和配置文件，可以使：应用程序更新时，对源码无需进行任何修改，
 *    我们只需要将新类发送给客户端，并修改配置文件即可。 
 */

public class ProperitiesTest {

	public static void main(String[] args) throws Exception{
		//1、通过反射获取Class对象
		Class class1 = Class.forName(getValue("className")); 
		//2、获取show()方法
		Method method = class1.getMethod(getValue("methodName")); //因为show()方法是无参函数，所以parameterTypes可以不写
		//3、调用show()方法
		method.invoke(class1.getConstructor().newInstance());
	}

	public static String getValue(String key) throws Exception{
		Properties pro = new Properties(); //获取配置文件的对象
		FileReader in = new FileReader("resources/pro.txt"); //获取输入流
		pro.load(in); //将流加载到配置文件对象中
		in.close();
		return pro.getProperty(key);  //返回根据key获取的value值
	}
}
