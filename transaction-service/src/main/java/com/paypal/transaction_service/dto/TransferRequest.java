package com.paypal.transaction_service.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.Size;

import java.math.BigDecimal;

public class TransferRequest {

    @NotBlank(message = "Sender name cannot be blank")
    @Size(max = 100, message = "Sender name cannot exceed 100 characters")
    private String senderName;

    @NotBlank(message = "Receiver name cannot be blank")
    @Size(max = 100, message = "Receiver name cannot exceed 100 characters")
    private String receiverName;

    @NotNull(message = "Amount cannot be null")
    @Positive(message = "Amount must be positive")
    private BigDecimal amount;

    // Default constructor for Jackson
    public TransferRequest() {}

    public TransferRequest(String senderName, String receiverName, BigDecimal amount) {
        this.senderName = senderName;
        this.receiverName = receiverName;
        this.amount = amount;
    }

    // getter and setters
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

    public BigDecimal getAmount() {
        return amount;
    }

    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }

    @Override
    public String toString() {
        return "TransferRequest{" +
                "senderName='" + senderName + '\'' +
                ", receiverName='" + receiverName + '\'' +
                ", amount=" + amount +
                '}';
    }
}
