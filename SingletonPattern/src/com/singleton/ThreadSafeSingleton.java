package com.singleton;

class MyThreadSafeSingleton {

	// This is check the current Value of the Thread
	private volatile static MyThreadSafeSingleton instances;

	// Should not create Instance directly Becz object will be create
	private MyThreadSafeSingleton() {
	}

	public static MyThreadSafeSingleton getInstances() {
		if (instances == null) {
			synchronized (MyThreadSafeSingleton.class) {
				if (instances == null) {
					instances = new MyThreadSafeSingleton();
				}
			}
		}
		return instances;
	}

	public void getdata() {
		System.out.println("Singleton");
	}

}

public class ThreadSafeSingleton {
	public static void main(String[] args) {

		Runnable task = () -> {
                    MyThreadSafeSingleton obj = MyThreadSafeSingleton.getInstances();
                    obj.getdata();
                };

		Thread thread1 = new Thread(task);
		Thread thread2 = new Thread(task);

		thread1.start();
		thread2.start();

	}
}
