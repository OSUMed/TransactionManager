package com.codercampus.Assignment11.services;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.codercampus.Assignment11.domain.Transaction;
import com.codercampus.Assignment11.repository.TransactionRepository;

@Service
public class TransactionService {
	@Autowired
	TransactionRepository transactionRepo;
	
	/**
	 * Retrieves all transactions from the repository and returns them in ascending order based on their date.
	 *
	 * @return A list of transactions sorted in ascending order by date.
	 */
	public List<Transaction> findAll() {
	    // Retrieve all transactions from the repository
	    List<Transaction> allTransactions = transactionRepo.findAll();

	    // Sort transactions in ascending order based on their date using Java Streams
	    List<Transaction> sortedTransactions = allTransactions.stream()
	            .sorted(Comparator.comparing(Transaction::getDate))
	            .collect(Collectors.toList());

	    // Return the sorted list of transactions
	    return sortedTransactions;
	}

	
	/**
	 * Retrieves a transaction by its ID from the list of all transactions.
	 *
	 * @param transaction_id The ID of the transaction to retrieve.
	 * @return The transaction with the specified ID, or null if not found.
	 */
	public Transaction getById(Long transaction_id) {
		List<Transaction> allTransactions = transactionRepo.findAll();
		
		// Find Id that matches parameter, then return that singular value:
		return allTransactions
			.stream()
			.filter(transaction -> transaction.getId().equals(transaction_id))
			.findFirst().orElse(null);		
	}
}
