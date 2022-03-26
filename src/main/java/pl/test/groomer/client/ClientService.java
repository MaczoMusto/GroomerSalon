package pl.test.groomer.client;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.test.groomer.client.dto.ClientDto;
import pl.test.groomer.client.mapper.ClientDtoMapper;

import java.util.List;
import java.util.Optional;


@Service
public class ClientService {

    private final ClientRepository clientRepository;
    private final ClientDtoMapper clientDtoMapper;

    @Autowired
    public ClientService(ClientRepository clientRepository, ClientDtoMapper clientDtoMapper) {
        this.clientRepository = clientRepository;
        this.clientDtoMapper = clientDtoMapper;
    }

    public ClientDto saveClient(ClientDto clientDto) {
        Client client = clientDtoMapper.map(clientDto);
        Client savedClient = clientRepository.save(client);
        return clientDtoMapper.map(savedClient);
    }

    public ClientDto getClientById(Long id) {
        Optional<Client> client = clientRepository.findById(id);
        ClientDto foundedClientDto;
        if (client.isPresent()) {
            foundedClientDto = clientDtoMapper.map(client.get());
        }else {
            throw new RuntimeException("Product with id: "+id+" not found.");
        }
        return foundedClientDto;
    }

    public List<Client> getAllClients() {
        return clientRepository.findAll();
    }


}
