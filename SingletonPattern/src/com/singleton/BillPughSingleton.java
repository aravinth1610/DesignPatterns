package com.singleton;

public class BillPughSingleton {

//	Should not create Instance directly Becz object will be create
	private BillPughSingleton() {
	}

	private static class BillPughSingletonHelper {
		private static final BillPughSingleton instance = new BillPughSingleton();
	}

	public static BillPughSingleton getInstances() {
		return BillPughSingletonHelper.instance;
	}

	public void getdata() {
		System.out.println("Singleton");
	}

}

class MyBillPughSingleton {
	public static void main(String[] args) {
		BillPughSingleton obj = BillPughSingleton.getInstances();
		obj.getdata();
	}
}
