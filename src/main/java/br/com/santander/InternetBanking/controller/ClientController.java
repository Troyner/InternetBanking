package br.com.santander.InternetBanking.controller;

import br.com.santander.InternetBanking.dto.ClientDTO;
import br.com.santander.InternetBanking.service.ClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

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
        List<ClientDTO> response = null;

        if (Objects.isNull(size)) {
            response = service.get();
        } else {
            response = service.get(page, size);
        }

        return ResponseEntity.ok(response);
    }
}
