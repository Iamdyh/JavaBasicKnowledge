package com.dyh.callback;

public class A implements Callback{
	
	//对象b
	private B b;
	
	/*
	 * A的构造函数中为B对象赋值
	 */
	public A(B b) {
		this.b = b;
	}

	/*
	 * A对象通过此方法告诉B对象要做什么
	 */
	public void askQuestion(final String question) {
		//这里用一个线程，表示异步调用
		new Thread(new Runnable() {
			
			@Override
			public void run() {
				// TODO Auto-generated method stub
				//A类中调用b的方法
				b.resolveQuestion(A.this, question);
			}
		}).start();
		//A对象继续做自己的事
		doSomething();
	}
	
	public void doSomething() {
		
	}

	/*
	 * A的回调方法，B对象知道答案后调用此方法告诉A(non-Javadoc)
	 * @see com.dyh.callback.Callback#tellAnswer(java.lang.String)
	 */
	@Override
	public void tellAnswer(String answer) {
		// TODO Auto-generated method stub
		System.out.println("Answer is " + answer);
		
	}

}
