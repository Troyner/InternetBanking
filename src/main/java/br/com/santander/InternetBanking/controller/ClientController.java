package br.com.santander.InternetBanking.controller;

import br.com.santander.InternetBanking.dto.ClientDTO;
import br.com.santander.InternetBanking.service.ClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(path = "clients")
public class ClientController {

    @Autowired
    private ClientService service;

    @GetMapping
    public ResponseEntity<List<ClientDTO>> get() {
        return ResponseEntity.ok(service.get());
    }
}
