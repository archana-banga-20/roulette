package com.nagarro.roulettePortal.controllers;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.nagarro.adminPortal.Game.Game;
import com.nagarro.roulettePortal.models.BettingOptions;
import com.nagarro.roulettePortal.models.Result;
import com.nagarro.roulettePortal.models.Balance;

@CrossOrigin("*")
@RestController
public class Roulette {

	private static final String GET_CUSTOMER_URL="https://casinoadmin.herokuapp.com/customer";
	private static final String BLOCK_AMOUNT_URL="https://casinoadmin.herokuapp.com/blockAmount";
	private static final String BALANCE_UPDATE_URL="https://casinoadmin.herokuapp.com/updateBalance";
	
	/**
	 * Post Request from roulette application to get customer record
	 * @param obj
	 * @return
	 */
	@PostMapping("/getcustomer")
	public Object getBlockedAmount(@RequestBody Object obj) {
		RestTemplate rest = new RestTemplate();
		System.out.println(obj);
		Object result = rest.postForObject(GET_CUSTOMER_URL, obj, Object.class);
		return result;
	}
	

	/**Post Request from roulette appliaction to starrt game using betting options and the customer id 
	 * @param bettingOptions
	 * @return return wining amount, lucky number and customer updted balance
	 */
	@PostMapping("/startGame")
	public Result startGame(@RequestBody BettingOptions bettingOptions) {
	
		RestTemplate rest = new RestTemplate();
		int betAmount = Game.getBlockedAmount(bettingOptions);
		
		Balance blockBalance = new Balance();
		blockBalance.setUniqueId(bettingOptions.getUniqueId());
		blockBalance.setAmount(betAmount);
		
		Object customer = rest.postForObject(BLOCK_AMOUNT_URL, blockBalance, Object.class);
		
		int[] winningAmount = Game.calculateWiningAmount(bettingOptions);
		
					
		Balance winningBalance = new Balance();
		winningBalance.setUniqueId(bettingOptions.getUniqueId());
		winningBalance.setAmount(winningAmount[0]);
		
		Object updated_Customer =  rest.postForObject(BALANCE_UPDATE_URL,winningBalance, Object.class);
		
		Result finalResult = new Result();
		finalResult.setCustomer(updated_Customer);
		finalResult.setWinningAmount(winningAmount[0]);
		finalResult.setLuckyNum(winningAmount[1]);
		return finalResult;
	}
		
}
