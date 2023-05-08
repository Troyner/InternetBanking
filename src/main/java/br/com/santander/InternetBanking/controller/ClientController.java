package br.com.santander.InternetBanking.controller;

import br.com.santander.InternetBanking.dto.ClientDTO;
import br.com.santander.InternetBanking.service.ClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.math.BigDecimal;
import java.util.List;
import java.util.Objects;

@RestController
@RequestMapping(path = "clients")
public class ClientController {

    @Autowired
    private ClientService service;

    @GetMapping
    public ResponseEntity<List<ClientDTO>> get(@RequestParam(required = false) Integer page,
                                               @RequestParam(required = false) Integer size) {
        List<ClientDTO> response;

        if (Objects.isNull(size)) {
            response = service.get();
        } else {
            response = service.get(page, size);
        }

        return ResponseEntity.ok(response);
    }

    @PatchMapping(value = "{id}/deposit")
    public ResponseEntity<String> deposit(@PathVariable("id") Long id,
                                          @RequestBody BigDecimal amount) {
        BigDecimal balance = service.deposit(id, amount);
        return ResponseEntity.ok("Your balance now is $" + balance.toString());
    }

    @PatchMapping(value = "{id}/withdraw")
    public ResponseEntity<String> withdraw(@PathVariable("id") Long id,
                                          @RequestBody BigDecimal amount) {
        BigDecimal balance = service.withdraw(id, amount);
        return ResponseEntity.ok(String.format("Your balance now is $%s", balance.toString()));
    }

}
