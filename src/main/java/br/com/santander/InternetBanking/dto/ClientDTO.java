package br.com.santander.InternetBanking.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ClientDTO {
    private String name;
    private Boolean exclusive;
    private BigDecimal balance;
    private String accountNumber;
    private LocalDate birthdayDate;
}
