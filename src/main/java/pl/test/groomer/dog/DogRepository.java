package pl.test.groomer.dog;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface DogRepository extends CrudRepository<Dog,Long> {
}
