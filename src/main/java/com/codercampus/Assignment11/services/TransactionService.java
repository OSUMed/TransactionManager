package com.codercampus.Assignment11.services;

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
	
	public List<Transaction> findAll(){
		List<Transaction> allTransactions = transactionRepo.findAll();
		return allTransactions;
	}

	public Transaction getById(Long transaction_id) {
		List<Transaction> allTransactions = transactionRepo.findAll();
		List<Transaction> transaction_id_matches = allTransactions
			.stream()
			.filter(transaction -> transaction.getId().equals(transaction_id))
			.collect(Collectors.toList());
			
			
		return transaction_id_matches.get(0);
	}
}
