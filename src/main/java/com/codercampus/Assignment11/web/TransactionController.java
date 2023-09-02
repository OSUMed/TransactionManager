package com.codercampus.Assignment11.web;

import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.codercampus.Assignment11.domain.Transaction;
import com.codercampus.Assignment11.services.TransactionService;

@Controller
public class TransactionController {
	
	@Autowired
	TransactionService transactionService;
	

	
	@GetMapping("/transactions")
	public String getAllTransactions(ModelMap model) {
		List<Transaction> transactions = transactionService.findAll();
		model.put("transactions", transactions);
		return "transactions";
	}
	
	@GetMapping("/transactions/{transaction_id}")
	public String getTransactionId(@PathVariable Long transaction_id, ModelMap model) {
		Transaction transaction = transactionService.getById(transaction_id);
		model.put("transaction", transaction);
		return "transaction";
	}
}
