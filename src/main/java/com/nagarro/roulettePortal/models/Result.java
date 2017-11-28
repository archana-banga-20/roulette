package com.nagarro.roulettePortal.models;

public class Result {

	private Object customer;
	private int winningAmount;
	private int luckyNum;
	
	public Result() {
		
	}
	
	public Result(Object customer, int winningAmount, int luckyNum) {
		super();
		this.customer = customer;
		this.winningAmount = winningAmount;
		this.luckyNum = luckyNum;
	}

	public Object getCustomer() {
		return customer;
	}

	public void setCustomer(Object customer) {
		this.customer = customer;
	}

	public int getWinningAmount() {
		return winningAmount;
	}

	public void setWinningAmount(int winningAmount) {
		this.winningAmount = winningAmount;
	}

	public int getLuckyNum() {
		return luckyNum;
	}

	public void setLuckyNum(int luckyNum) {
		this.luckyNum = luckyNum;
	};
	
	
	
	
}
