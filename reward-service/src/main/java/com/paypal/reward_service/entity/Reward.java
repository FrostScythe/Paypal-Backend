package com.paypal.reward_service.entity;

import jakarta.persistence.*;

import java.time.LocalDateTime;

@Entity
@Table(name= "reward")
public class Reward {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Long userId;

    private Double points;

    private LocalDateTime sendAt;

    @Column(unique = true)
    private Long transactionId;

    // Getters and Setters

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public Double getPoints() {
        return points;
    }

    public void setPoints(Double points) {
        this.points = points;
    }

    public LocalDateTime getSendAt() {
        return sendAt;
    }

    public void setSendAt(LocalDateTime sendAt) {
        this.sendAt = sendAt;
    }

    public Long getTransactionId() {
        return transactionId;
    }

    public void setTransactionId(Long transactionId) {
        this.transactionId = transactionId;
    }
}
