package guru.springframework.petclinic.repositories;

import org.springframework.data.repository.CrudRepository;
import guru.springframework.petclinic.models.PetType;

public interface PetTypeRepository extends CrudRepository<PetType, Long>{

}
