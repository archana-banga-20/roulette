package com.nagarro.roulettePortal.models;

public class Balance {

	private String uniqueId;
	private int amount;
	
	public Balance() {
		
	}
	public Balance(String uniqueId, int amount) {
		super();
		this.uniqueId = uniqueId;
		this.amount = amount;
	}
	public String getUniqueId() {
		return uniqueId;
	}
	public void setUniqueId(String uniqueId) {
		this.uniqueId = uniqueId;
	}
	public int getAmount() {
		return amount;
	}
	public void setAmount(int amount) {
		this.amount = amount;
	}
	
	
	
}
