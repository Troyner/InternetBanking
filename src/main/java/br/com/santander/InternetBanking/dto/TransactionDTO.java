package br.com.santander.InternetBanking.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Schema(description = "Transaction Dto")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class TransactionDTO {

    @JsonProperty
    private LocalDateTime dateTime;

    @JsonProperty
    private String transactionName;

    @JsonProperty
    private BigDecimal amount;

}
