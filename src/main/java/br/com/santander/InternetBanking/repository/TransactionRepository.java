package br.com.santander.InternetBanking.repository;

import br.com.santander.InternetBanking.entity.Transaction;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDateTime;

public interface TransactionRepository extends JpaRepository<Transaction, Long> {
    Page<Transaction> findByDateTimeBetween(LocalDateTime dateTime, LocalDateTime now, Pageable pageable);
    Page<Transaction> findByDateTimeBetweenAndTransactionName(LocalDateTime dateTime, LocalDateTime now, String transactionName, Pageable pageable);
}
