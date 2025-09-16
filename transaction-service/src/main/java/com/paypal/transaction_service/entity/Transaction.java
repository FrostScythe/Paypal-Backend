package com.paypal.transaction_service.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.Positive;

import java.time.LocalDateTime;

@Entity
@Table(name="transaction")
public class Transaction {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name="sender_name", nullable=false)
    private String senderName;

    @Column(name="receiver_name", nullable=false)
    private String receiverName;

    @Column(nullable = false)
    @Positive(message = "Amount must be positive")
    private Double amount;

    @Column(nullable = false)
    private LocalDateTime timestamp;

    @Column(nullable = false)
    private String status;

    //Default constructor
    public Transaction(){}

    public Transaction(Long id, String senderName, String receiverName, @Positive(message = "Amount must be positive") Double amount, LocalDateTime timestamp, String status) {
        this.id = id;
        this.senderName = senderName;
        this.receiverName = receiverName;
        this.amount = amount;
        this.timestamp = timestamp;
        this.status = status;
    }

    // getter and setter

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getSenderName() {
        return senderName;
    }

    public void setSenderName(String senderName) {
        this.senderName = senderName;
    }

    public String getReceiverName() {
        return receiverName;
    }

    public void setReceiverName(String receiverName) {
        this.receiverName = receiverName;
    }

    public Double getAmount() {
        return amount;
    }

    public void setAmount(Double amount) {
        this.amount = amount;
    }

    public LocalDateTime getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(LocalDateTime timestamp) {
        this.timestamp = timestamp;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    //lifecycle callback to set default values before persisting
    @PrePersist
    public void prePersist() {
        if (timestamp == null) {
            timestamp = LocalDateTime.now();
        }
    }
}