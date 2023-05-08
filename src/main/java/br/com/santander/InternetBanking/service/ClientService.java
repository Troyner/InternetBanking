package br.com.santander.InternetBanking.service;

import br.com.santander.InternetBanking.Fee;
import br.com.santander.InternetBanking.dto.ClientDTO;
import br.com.santander.InternetBanking.entity.Client;
import br.com.santander.InternetBanking.mapper.ClientMapper;
import br.com.santander.InternetBanking.repository.ClientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;
import java.util.stream.Collectors;

import static br.com.santander.InternetBanking.Fee.EXEMPTION_TAX;
import static br.com.santander.InternetBanking.Fee.MAX_TAX;
import static br.com.santander.InternetBanking.Fee.MIN_TAX;

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

    public BigDecimal deposit(Long id, BigDecimal amount) {
        Client client = repository.getReferenceById(id);
        client.setBalance(client.getBalance().add(amount));
        repository.save(client);
        return client.getBalance();
    }

    public BigDecimal withdraw(Long id, BigDecimal amount) {
        Client client = repository.getReferenceById(id);
        BigDecimal amountWithFee = getTax(amount, client.getExclusive())
                        .multiply(amount);
        client.setBalance(client.getBalance().subtract(amountWithFee));
        repository.save(client);
        return client.getBalance();
    }

    private BigDecimal getTax(BigDecimal amount, boolean exclusive) {
        if (exclusive || EXEMPTION_TAX.getMax().compareTo(amount) == 1) {
            return EXEMPTION_TAX.getTax();
        } else if (MIN_TAX.getMax().compareTo(amount) == 1) {
            return MIN_TAX.getTax();
        } else {
            return MAX_TAX.getTax();
        }
    }
}
