package pl.test.groomer.client.mapper;

import org.springframework.stereotype.Service;
import pl.test.groomer.client.Client;
import pl.test.groomer.client.dto.ClientDto;

@Service
public class ClientDtoMapper {

    public ClientDto map(Client client){
        ClientDto dto = new ClientDto();
        dto.setId(client.getId());
        dto.setFirstName(client.getFirstName());
        dto.setLastName(client.getLastName());
        dto.setPhoneNumber(client.getPhoneNumber());
        return dto;
    }

    public Client map(ClientDto clientDto){
        Client client = new Client();
        client.setId(clientDto.getId());
        client.setFirstName(clientDto.getFirstName());
        client.setLastName(clientDto.getLastName());
        client.setPhoneNumber(clientDto.getPhoneNumber());
        return client;
    }
}
