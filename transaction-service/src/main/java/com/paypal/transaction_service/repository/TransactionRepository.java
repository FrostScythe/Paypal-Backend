package com.paypal.transaction_service.repository;

import com.paypal.transaction_service.entity.Transaction;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.List;

@Repository
public interface TransactionRepository extends JpaRepository<Transaction, Long> {

    // Find transactions by sender name
    List<Transaction> findBySenderName(String senderName);

    // Find transactions by receiver name
    List<Transaction> findByReceiverName(String receiverName);

    // Find transactions by status
    List<Transaction> findByStatus(String status);

    // Find transactions within a date range
    @Query("SELECT t FROM Transaction t WHERE t.timestamp BETWEEN :startDate AND :endDate")
    List<Transaction> findTransactionsBetweenDates(@Param("startDate") LocalDateTime startDate,
                                                  @Param("endDate") LocalDateTime endDate);

    // Find transactions by sender or receiver
    @Query("SELECT t FROM Transaction t WHERE t.senderName = :name OR t.receiverName = :name")
    List<Transaction> findTransactionsByParticipant(@Param("name") String name);
}
