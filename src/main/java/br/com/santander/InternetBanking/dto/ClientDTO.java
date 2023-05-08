package br.com.santander.InternetBanking.dto;

import lombok.Data;

import java.math.BigDecimal;
import java.time.LocalDate;

@Data
public class ClientDTO {
    private String name;
    private Boolean exclusive;
    private BigDecimal balance;
    private String accountNumber;
    private LocalDate birthdayDate;
}
