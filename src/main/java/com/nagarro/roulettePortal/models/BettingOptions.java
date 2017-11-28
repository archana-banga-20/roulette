package com.nagarro.roulettePortal.models;

public class BettingOptions {

	private int first12;
	private int second12;
	private int third12;
	private int zero;
	private int first18;
	private int second18;
	private int even;
	private int odd;
	private String uniqueId;
	
	public BettingOptions() {
		
	}
	
	public BettingOptions(int first12, int second12, int third12, int zero, int first18, int second18, int even,
			int odd,String uniqueId) {
		super();
		this.first12 = first12;
		this.second12 = second12;
		this.third12 = third12;
		this.zero = zero;
		this.first18 = first18;
		this.second18 = second18;
		this.even = even;
		this.odd = odd;
		this.uniqueId = uniqueId;
	}
	
	
	public String getUniqueId() {
		return uniqueId;
	}

	public void setUniqueId(String uniqueId) {
		this.uniqueId = uniqueId;
	}

	public int getFirst12() {
		return first12;
	}
	public void setFirst12(int first12) {
		this.first12 = first12;
	}
	public int getSecond12() {
		return second12;
	}
	public void setSecond12(int second12) {
		this.second12 = second12;
	}
	public int getThird12() {
		return third12;
	}
	public void setThird12(int third12) {
		this.third12 = third12;
	}
	public int getZero() {
		return zero;
	}
	public void setZero(int zero) {
		this.zero = zero;
	}
	public int getFirst18() {
		return first18;
	}
	public void setFirst18(int first18) {
		this.first18 = first18;
	}
	public int getSecond18() {
		return second18;
	}
	public void setSecond18(int second18) {
		this.second18 = second18;
	}
	public int getEven() {
		return even;
	}
	public void setEven(int even) {
		this.even = even;
	}
	public int getOdd() {
		return odd;
	}
	public void setOdd(int odd) {
		this.odd = odd;
	}
	
	
	
	
}
