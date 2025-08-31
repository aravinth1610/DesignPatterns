package com.Observer.jv;

//Subject interface
public interface StockMarket {
	void registerDisplay(StockDisplay display);

	void removeDisplay(StockDisplay display);

	void notifyDisplays();

	void setStockPrice(String string, double d);
}