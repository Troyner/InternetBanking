package br.com.santander.InternetBanking.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.time.LocalDate;

@Schema(description = "Client Dto")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class ClientDTO {

    @JsonProperty
    private String name;

    @JsonProperty
    private Boolean exclusive;

    @JsonProperty
    private BigDecimal balance;

    @JsonProperty
    private String accountNumber;

    @JsonProperty
    private LocalDate birthdayDate;
}
