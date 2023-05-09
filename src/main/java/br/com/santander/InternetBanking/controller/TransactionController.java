package br.com.santander.InternetBanking.controller;

import br.com.santander.InternetBanking.dto.TransactionDTO;
import br.com.santander.InternetBanking.service.TransactionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;
import java.util.List;

@RestController
@RequestMapping(path = "transactions")
public class TransactionController {

    @Autowired
    private TransactionService service;

    @GetMapping
    public ResponseEntity<List<TransactionDTO>> get(@RequestParam LocalDateTime dateTime,
                                                    @RequestParam(required = false) String transactionName,
                                                    @RequestParam Integer page,
                                                    @RequestParam Integer size) {
        return ResponseEntity.ok(service.get(dateTime, transactionName, page, size));
    }

}