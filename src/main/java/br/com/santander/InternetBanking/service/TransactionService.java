package br.com.santander.InternetBanking.service;

import br.com.santander.InternetBanking.dto.TransactionDTO;
import br.com.santander.InternetBanking.enums.Transaction;
import br.com.santander.InternetBanking.mapper.TransactionMapper;
import br.com.santander.InternetBanking.repository.TransactionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

@Service
public class TransactionService {

    @Autowired
    private TransactionRepository repository;

    @Autowired
    private TransactionMapper mapper;

    private List<TransactionDTO> get(LocalDateTime dateTime, Integer page, Integer size) {
        return repository.findByDateTimeBetween(dateTime, LocalDateTime.now(), PageRequest.of(page, size)).stream()
                .map(mapper::convertToDto)
                .collect(Collectors.toList());
    }

    public List<TransactionDTO> get(LocalDateTime dateTime, String transactionName, Integer page, Integer size) {
        if (Objects.isNull(transactionName)) {
            return this.get(dateTime, page, size);
        } else {
            return repository.findByDateTimeBetweenAndTransactionName(dateTime, LocalDateTime.now(), Transaction.valueOf(transactionName).name(), PageRequest.of(page, size)).stream()
                    .map(mapper::convertToDto)
                    .collect(Collectors.toList());
        }
    }

    public void save(Transaction transaction, BigDecimal amount) {
        TransactionDTO transactionDTO = new TransactionDTO(LocalDateTime.now(), transaction.name(), amount);
        repository.save(mapper.convertToEntity(transactionDTO));
    }
}
