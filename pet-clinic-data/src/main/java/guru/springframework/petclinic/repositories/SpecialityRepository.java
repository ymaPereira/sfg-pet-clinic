package guru.springframework.petclinic.repositories;

import org.springframework.data.repository.CrudRepository;

import guru.springframework.petclinic.models.Speciality;

public interface SpecialityRepository extends CrudRepository<Speciality, Long>{

}
