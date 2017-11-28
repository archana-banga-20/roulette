package com.nagarro.adminPortal.Game;

import java.util.ArrayList;

public class randNo {

	public static void main(String[] args) {
		/*String s ="ABC";
		System.out.println(s.substring(3));*/
		ArrayList<String> arr= new ArrayList<>();
		int dc=0;
		for(int i = 0;i<7;i++){
			int r = 0 +(int)(Math.random()*9);
				int num=digitRan(r);
				arr.add(String.valueOf(num));
				dc+=arr.get(i).length();
				System.out.println("num "+ num);
		}
	
		System.out.println(arr);
		//System.out.println(a);
		int min = rand(arr, dc, 0, 0, "",10000);
		int random  = (min%37);
		System.out.println(random);
		
	}
	
	
	static int digitRan(int ran){
		int r1 = 0;
		for(int i = 0; i<ran;i++){
			r1*=10;
			r1 += (0 +(int)(Math.random()*9));
		}
		return r1;
	}
	
	
	static int rand(ArrayList<String> arr,int dc,int ev,int odd,String s,int min){
		if(arr.size()==0){
			System.out.println(s+",");
			System.out.println("even "+ev);
			System.out.println("odd "+odd);
			int d = Math.abs(ev-odd);
			System.out.println("randN "+d);
			if(d<min)
				min=d;
			
			return d;
		}
		
		
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
			min = rand(newArr,dc,ev,odd,s+s1,min);
		}
		return min;
	}

}
