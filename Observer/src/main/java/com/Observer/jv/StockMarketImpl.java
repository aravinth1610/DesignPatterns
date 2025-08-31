package com.Observer.jv;

import java.util.ArrayList;
import java.util.List;

//Concrete Subject
public class StockMarketImpl implements StockMarket {
	private List<StockDisplay> displays = new ArrayList<>();
	private String stockSymbol;
	private double price;

	@Override
	public void registerDisplay(StockDisplay display) {
		displays.add(display);
	}

	@Override
	public void removeDisplay(StockDisplay display) {
		displays.remove(display);
	}

	@Override
	public void notifyDisplays() {
		for (StockDisplay display : displays) {
			display.update(stockSymbol, price);
		}
	}

	// Method to update stock price
	public void setStockPrice(String stockSymbol, double price) {
		this.stockSymbol = stockSymbol;
		this.price = price;
		notifyDisplays();
	}
}
