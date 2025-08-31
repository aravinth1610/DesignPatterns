package com.Observer.jv;

//Concrete Observer: Web Dashboard Display
public class WebDashboardDisplay implements StockDisplay {
	private String dashboardId;

	public WebDashboardDisplay( String dashboardId ) {
		this.dashboardId = dashboardId;
	}

	@Override
	public void update(String stockSymbol, double price) {
		System.out.println("Web Dashboard [" + dashboardId + "]: " + stockSymbol + " price updated to $" + price);
	}
}
