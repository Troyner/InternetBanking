package br.com.santander.InternetBanking.service;

import br.com.santander.InternetBanking.dto.ClientDTO;
import br.com.santander.InternetBanking.mapper.ClientMapper;
import br.com.santander.InternetBanking.repository.ClientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ClientService {

    @Autowired
    private ClientRepository repository;

    @Autowired
    private ClientMapper clientMapper;

    public List<ClientDTO> get() {
        return repository.findAll().stream()
                .map(clientMapper::convertToDto)
                .collect(Collectors.toList());
    }


    public List<ClientDTO> get(Integer page, Integer size) {
        return repository.findAll(PageRequest.of(page, size)).stream()
                .map(clientMapper::convertToDto)
                .collect(Collectors.toList());
    }
}
