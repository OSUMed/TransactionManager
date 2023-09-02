package com.codercampus.Assignment11.services;

import java.util.List;

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
}
