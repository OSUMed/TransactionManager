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
	
	TransactionService transactionService;
	
	// Constructor injection for TransactionService
    public TransactionController(TransactionService transactionService) {
        this.transactionService = transactionService;
    }
	
	// Handler method to retrieve and display all transactions
	@GetMapping("/transactions")
	public String getAllTransactions(ModelMap model) {
		// Retrieve all transactions from the service
		List<Transaction> transactions = transactionService.findAll();
		
		// Add the transactions to the model for view rendering
		model.put("transactions", transactions);
		
		// Return the view name for transactions
		return "transactions";
	}
	
	// Handler method to retrieve and display a specific transaction by ID
	@GetMapping("/transactions/{transaction_id}")
	public String getTransactionId(@PathVariable Long transaction_id, ModelMap model) {
		// Retrieve the transaction by ID from the service
		Transaction transaction = transactionService.getById(transaction_id);
		
		// Add the transaction to the model for view rendering
		model.put("transaction", transaction);
		
		// Return the view name for a single transaction
		return "transaction";
	}
}
