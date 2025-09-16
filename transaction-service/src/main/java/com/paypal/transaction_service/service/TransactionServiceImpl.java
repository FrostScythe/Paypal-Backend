package com.paypal.transaction_service.service;

import com.paypal.transaction_service.dto.TransferRequest;
import com.paypal.transaction_service.entity.Transaction;
import com.paypal.transaction_service.repository.TransactionRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.List;

@Service
@Transactional
public class TransactionServiceImpl implements TransactionService {

    private static final Logger logger = LoggerFactory.getLogger(TransactionServiceImpl.class);

    private final TransactionRepository transactionRepository;

    public TransactionServiceImpl(TransactionRepository transactionRepository) {
        this.transactionRepository = transactionRepository;
    }

    @Override
    public Transaction createTransaction(TransferRequest transferRequest) {
        logger.info("Creating transaction from {} to {} for amount {}",
                transferRequest.getSenderName(),
                transferRequest.getReceiverName(),
                transferRequest.getAmount());

        try {
            Transaction transaction = new Transaction();
            transaction.setSenderName(transferRequest.getSenderName());
            transaction.setReceiverName(transferRequest.getReceiverName());
            transaction.setAmount(transferRequest.getAmount());
            transaction.setTimestamp(LocalDateTime.now());
            transaction.setStatus("PENDING");

            Transaction savedTransaction = transactionRepository.save(transaction);

            // Simulate business logic - in real scenario, this would involve payment processing
            savedTransaction.setStatus("SUCCESS");
            savedTransaction = transactionRepository.save(savedTransaction);

            logger.info("Transaction created successfully with ID: {}", savedTransaction.getId());
            return savedTransaction;

        } catch (Exception e) {
            logger.error("Failed to create transaction: {}", e.getMessage(), e);
            throw new RuntimeException("Transaction creation failed", e);
        }
    }

    @Override
    public List<Transaction> getAllTransactions() {
        logger.info("Retrieving all transactions");
        try {
            return transactionRepository.findAll();
        } catch (Exception e) {
            logger.error("Failed to retrieve transactions: {}", e.getMessage(), e);
            throw new RuntimeException("Failed to retrieve transactions", e);
        }
    }

    @Override
    public Transaction getTransactionById(Long id) {
        logger.info("Retrieving transaction with ID: {}", id);
        try {
            return transactionRepository.findById(id).orElse(null);
        } catch (Exception e) {
            logger.error("Failed to retrieve transaction with ID {}: {}", id, e.getMessage(), e);
            throw new RuntimeException("Failed to retrieve transaction", e);
        }
    }
}