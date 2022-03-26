package pl.test.groomer.dog;

import org.springframework.stereotype.Service;
import pl.test.groomer.dog.dto.DogDto;
import pl.test.groomer.dog.mapper.DogDtoMapper;

@Service
public class DogService {

    private final DogRepository dogRepository;
    private final DogDtoMapper dogDtoMapper;

    public DogService(DogRepository dogRepository, DogDtoMapper dogDtoMapper) {
        this.dogRepository = dogRepository;
        this.dogDtoMapper = dogDtoMapper;
    }

    public DogDto saveDog(Long id, DogDto dogDto){
        Dog dogToSave = dogDtoMapper.map(id,dogDto);
        Dog savedDog = dogRepository.save(dogToSave);
        return dogDtoMapper.map(savedDog);
    }

}
