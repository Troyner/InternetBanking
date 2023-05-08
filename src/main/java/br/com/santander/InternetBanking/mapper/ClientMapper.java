package br.com.santander.InternetBanking.mapper;

import br.com.santander.InternetBanking.dto.ClientDTO;
import br.com.santander.InternetBanking.entity.Client;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.time.ZoneId;

@Component
public class ClientMapper {

    @Autowired
    private ModelMapper modelMapper;

    public ClientDTO convertToDto(Client client) {
        ClientDTO clientDTO = modelMapper.map(client, ClientDTO.class);
        clientDTO.setBirthdayDate(client.getBirthdayDate().toInstant()
                .atZone(ZoneId.systemDefault())
                .toLocalDate());
        return clientDTO;
    }
}
