package com.Observer.jv;

//Concrete Observer: Mobile App Display
public class MobileAppDisplay implements StockDisplay {
	private String appId;

	public MobileAppDisplay( String appId ) {
		this.appId = appId;
	}

	@Override
	public void update(String stockSymbol, double price) {
		System.out.println("Mobile App [" + appId + "]: " + stockSymbol + " price updated to $" + price);
	}
}