package br.com.santander.InternetBanking.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class TransactionDTO {

    private LocalDateTime dateTime;
    private String transactionName;
    private BigDecimal amount;

}
