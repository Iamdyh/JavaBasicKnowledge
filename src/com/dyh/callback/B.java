package com.dyh.callback;

public class B {

	public void resolveQuestion(Callback callback, String question) {
		System.out.println("A的问题：" + question);
		//模拟解决问题的过程
		try {
			Thread.sleep(2000);
		} catch (Exception e) {
			// TODO: handle exception
		}
		String reString = "2";
		//B类中调用A的回调方法
		callback.tellAnswer(reString);
	}

}
