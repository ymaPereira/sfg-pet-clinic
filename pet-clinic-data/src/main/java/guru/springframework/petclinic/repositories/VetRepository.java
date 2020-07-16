package guru.springframework.petclinic.repositories;

import org.springframework.data.repository.CrudRepository;

import guru.springframework.petclinic.models.Pet;

public interface VetRepository extends CrudRepository<Pet, Long>{

}
