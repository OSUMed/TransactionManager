package com.codercampus.Assignment11.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.codercampus.Assignment11.repository.TransactionRepository;
import com.codercampus.Assignment11.services.TransactionService;

@Controller
public class TransactionController {
	
	@Autowired
	TransactionService transactionService;
	
	@Autowired
	TransactionRepository transactionRepo;
	

	
	@GetMapping("/transactions")
	public String getAllTransactions() {
		
		return "transactions";
	}
	
	@GetMapping("/transactions/{transaction_id}")
	public String getTransactionId(@PathVariable Long transaction_id) {
		System.out.println("Transaction id is: " + transaction_id);
		return "transactions";
	}
}
