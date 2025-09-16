package com.paypal.transaction_service.controller;

import com.paypal.transaction_service.entity.Transaction;
import com.paypal.transaction_service.service.TransactionService;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/transactions")
public class TransactionController {

    private final TransactionService service;

    public TransactionController(TransactionService service) {
        this.service = service;
    }

    @PostMapping("/create")
    public ResponseEntity<?> createTransaction(@Valid @RequestBody Transaction transaction) {
        service.createTransaction(transaction);
        return ResponseEntity.ok("Transaction created successfully");
    }

    @GetMapping("/all")
    public ResponseEntity<?> getAllTransactions() {
        return ResponseEntity.ok(service.getAllTransactions());
    }
}
