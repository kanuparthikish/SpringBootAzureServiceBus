package com.kishore.servicebus.vo;

import java.io.Serializable;

public class StockPortFolio implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	private String stockSymbol=null;
	private String stockName=null;
	private Double  week_52_low=null;
	private Double  week_52_high=null;
	private Double  todayClosingPrice=null;
	private String category=null;
	
	public String getCategory() {
		return category;
	}
	public void setCategory(String category) {
		this.category = category;
	}
	public String getStockSymbol() {
		return stockSymbol;
	}
	public void setStockSymbol(String stockSymbol) {
		this.stockSymbol = stockSymbol;
	}
	public String getStockName() {
		return stockName;
	}
	public void setStockName(String stockName) {
		this.stockName = stockName;
	}
	public Double getWeek_52_low() {
		return week_52_low;
	}
	public void setWeek_52_low(Double week_52_low) {
		this.week_52_low = week_52_low;
	}
	public Double getWeek_52_high() {
		return week_52_high;
	}
	public void setWeek_52_high(Double week_52_high) {
		this.week_52_high = week_52_high;
	}
	public Double getTodayClosingPrice() {
		return todayClosingPrice;
	}
	public void setTodayClosingPrice(Double todayClosingPrice) {
		this.todayClosingPrice = todayClosingPrice;
	}


}
