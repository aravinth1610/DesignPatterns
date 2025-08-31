package com.Observer.jv;

public class Main {

	public static void main() {
		StockDisplay mobile = new MobileAppDisplay("MB1");
		StockDisplay web = new MobileAppDisplay("WB1");
		
		StockMarket market = new StockMarketImpl();
		
		market.registerDisplay(web);
		market.registerDisplay(mobile);

		// Update stock price
		market.setStockPrice("AAPL", 150.75);
		
		
		
	}
	
}
