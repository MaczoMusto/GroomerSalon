package pl.test.groomer.dog.mapper;

import org.springframework.stereotype.Service;
import pl.test.groomer.client.ClientRepository;
import pl.test.groomer.dog.Dog;
import pl.test.groomer.dog.dto.DogDto;

@Service
public class DogDtoMapper {

    private final ClientRepository clientRepository;

    public DogDtoMapper(ClientRepository clientRepository) {
        this.clientRepository = clientRepository;
    }

    public DogDto map(Dog dog){
        DogDto dto = new DogDto();
        dto.setId(dog.getId());
        dto.setBreed(dog.getBreed());
        dto.setName(dog.getName());
        dto.setSize(dog.getSize());
        dto.setClientId(dog.getClient().getId());
        return dto;
    }

    public Dog map(Long id, DogDto dto){
        Dog dog = new Dog();
        dog.setBreed(dto.getBreed());
        dog.setName(dto.getName());
        dog.setSize(dto.getSize());
        clientRepository.findById(id)
                .ifPresent(dog::setClient);
        return dog;
    }
}
