package com.singleton;

public class Singleton {

	private static Singleton instances;

	//Should not create Instance directly Becz object will be create
	private Singleton() {
	}

	public static Singleton getInstances() {
		if (instances == null) {
			instances = new Singleton();
		}
		return instances;
	}

	public void getdata() {
		System.out.println("Singleton");
	}

}

class MySingleton {
	public static void main(String[] args) {
		Singleton obj = Singleton.getInstances();
		obj.getdata();
	}
}
