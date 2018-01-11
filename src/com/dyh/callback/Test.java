package com.dyh.callback;

import java.util.Queue;

public class Test {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		B b = new B();
		A a = new A(b);
		a.askQuestion("1+1=?");
	}

}
