package br.com.santander.InternetBanking.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

import java.math.BigDecimal;
import java.util.Date;

@Entity
@Table(name = "CLIENTS")
@Data
public class Client {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "NAME")
    private String name;

    @Column(name = "EXCLUSIVE")
    private Boolean exclusive;

    @Column(name = "BALANCE")
    private BigDecimal balance;

    @Column(name = "ACCOUNT_NUMBER")
    private String accountNumber;

    @Column(name = "BIRTHDAY_DATE")
    private Date birthdayDate;

}
