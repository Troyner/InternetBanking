package br.com.santander.InternetBanking.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;
import java.math.BigDecimal;

@AllArgsConstructor
@Getter
public enum Fee {
    EXEMPTION_TAX(BigDecimal.ZERO, BigDecimal.valueOf(100), BigDecimal.ONE),
    MIN_TAX(BigDecimal.valueOf(100), BigDecimal.valueOf(300), BigDecimal.valueOf(1.004)),
    MAX_TAX(BigDecimal.valueOf(300), BigDecimal.ZERO, BigDecimal.valueOf(1.01));

    private BigDecimal min;
    private BigDecimal max;
    private BigDecimal tax;
}
