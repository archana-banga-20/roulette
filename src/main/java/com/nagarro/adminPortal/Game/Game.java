package com.nagarro.adminPortal.Game;

import java.util.ArrayList;

import com.nagarro.roulettePortal.models.BettingOptions;


/**
 * @author archanabanga
 * This class performs all game related operations 
 * calculates winning amount , genaerates random number 
 */
public class Game {

	
	private static final double minBetRate = 1.5;
	private static final double maxBetRate = 10;
	private static final double avgBetRate = 1.25;
	private static final int n = 7;
	
	static int mini = 0 +(int)(Math.random()*36);
	
	/**
	 * Calculates Blocked amount from an object of betting options
	 * @param BettingOptions
	 * @return total bet amount
	 */
	public static int getBlockedAmount(BettingOptions bettingOptions){
		int amount = bettingOptions.getFirst12() + bettingOptions.getSecond12() + bettingOptions.getThird12()
		+bettingOptions.getFirst18() + bettingOptions.getSecond18() + bettingOptions.getZero()
		+bettingOptions.getEven() + bettingOptions.getOdd();
		return amount;
	}
		
	
	/**
	 * Calculates winning or losing amount based on random number generated and and beeting options choosen
	 * @param bettingOptions
	 * @return bet amount and random number
	 */
	public static int[] calculateWiningAmount(BettingOptions bettingOptions){
		int randNum = generateRamdomNum(); 
		System.out.println("Inside func");
System.out.println(randNum);

System.out.println(bettingOptions.toString());
		int betAmount = 0;
		if((bettingOptions.getFirst12() > 0) && (randNum >=1 && randNum <= 12)){
			betAmount += (int) (bettingOptions.getFirst12()*minBetRate);
		}
		if((bettingOptions.getSecond12() > 0) && (randNum >=13 && randNum <= 18)){
			betAmount += (int) (bettingOptions.getSecond12()*minBetRate);
		}
		if((bettingOptions.getThird12() > 0) && (randNum >=19 && randNum <= 36)){
			betAmount += (int) (bettingOptions.getThird12()*minBetRate);			
		}
		if((bettingOptions.getZero() > 0) && (randNum == 0)){
			betAmount += (int) (bettingOptions.getZero()*maxBetRate);		
		}
		if((bettingOptions.getFirst18() > 0) && (randNum >=1 && randNum <= 18)){
			betAmount += (int) (bettingOptions.getFirst18()*avgBetRate) ;			
		}
		if((bettingOptions.getSecond18() > 0) && (randNum >=19 && randNum <= 36)){
			betAmount += (int) (bettingOptions.getSecond18()*avgBetRate);			
		}
		if((bettingOptions.getEven() > 0) && ((randNum % 2) == 0) && (randNum != 0)){
			betAmount += (int) (bettingOptions.getEven()*avgBetRate);		
		}
		if((bettingOptions.getOdd() > 0)  && ((randNum % 2) != 0)){
			betAmount += (int) (bettingOptions.getOdd()*avgBetRate);	
		}
		
		System.out.println(betAmount);
		
		int[] arr = new int[2];
		arr[0] = betAmount; arr[1] = randNum;
		return arr;
	}
	
	
	
	public static int generateRamdomNum(){		
		ArrayList<String> arr= new ArrayList<>();
		int dc=0;
		for(int i = 0;i<n;i++){
			int r = 0 +(int)(Math.random()*9);
				int num=digitRan(r);
				arr.add(String.valueOf(num));
				dc+=arr.get(i).length();
				System.out.println("num "+ num);
		}
	
		System.out.println(arr);
		//System.out.println(a);
		int min = rand(arr, dc, 0, 0, "",10000);
		/*int random  = (min%37);*/
		System.out.println(min);
		return min;
		
		
	}
	
	/**
	 * calculates random number
	 * @return random number generated
	 */
	
	static int digitRan(int ran){
		int r1 = 0;
		for(int i = 0; i<ran;i++){
			r1*=10;
			r1 += (0 +(int)(Math.random()*9));
		}
		return r1;
	}
	
	
	static int rand(ArrayList<String> arr,int dc,int ev,int odd,String s,int min){
		int d = 0;
		for(int i=0;i<arr.size();i++){
			int l = arr.get(i).length();
			
			if((dc%2)==0){
				for(int j=0;j<l;j++){
					ev+=Integer.parseInt(""+arr.get(i).charAt(j));
					if(j+1<arr.get(i).length())
					{
						j=j+1;
						odd+=Integer.parseInt(""+arr.get(i).charAt(j));
					}
				}
			}
			else{
				for(int j=0;j<l;j++){
					odd+=Integer.parseInt(""+arr.get(i).charAt(j));
					if(j+1<arr.get(i).length()){
						j=j+1;
						ev+=Integer.parseInt(""+arr.get(i).charAt(j));
					}
						
				}
			}
			
			dc=dc-l;
			ArrayList<String> newArr = new ArrayList<>();
			newArr.addAll(arr);
			
			String s1=newArr.remove(i);
			 min= rand(newArr,dc,ev,odd,s+s1,min);
			System.out.println("miniiii "+min);
			//arr = newArr;
		}
		
		if(arr.size()<=0){
			 d = Math.abs(ev-odd);
			System.out.println("randN "+d);
			return (d);
		}
		
		return (min);
	}

}