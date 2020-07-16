package guru.springframework.petclinic.repositories;

import org.springframework.data.repository.CrudRepository;

import guru.springframework.petclinic.models.Visit;

public interface VisitRepository extends CrudRepository<Visit, Long>{

}
