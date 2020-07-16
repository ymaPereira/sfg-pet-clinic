package guru.springframework.petclinic.springdatajpa;

import java.util.HashSet;
import java.util.Set;

import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

import guru.springframework.petclinic.helpers.ConstantProfile;
import guru.springframework.petclinic.models.Pet;
import guru.springframework.petclinic.repositories.PetRespository;
import guru.springframework.petclinic.services.PetService;

@Service
@Profile(ConstantProfile.SPRING_DATA_JPA)
public class PetJPAService implements PetService{

	private final PetRespository petRepository;
	
	
	public PetJPAService(PetRespository petRepository) {
		super();
		this.petRepository = petRepository;
	}

	@Override
	public Pet save(Pet object) {
		return petRepository.save(object);
	}

	@Override
	public Pet findById(Long id) {
		return petRepository.findById(id).orElse(null);
	}

	@Override
	public void delete(Pet object) {
		petRepository.delete(object);
	}

	@Override
	public void deleteById(Long id) {
		petRepository.deleteById(id);
	}

	@Override
	public Set<Pet> findAll() {
		Set<Pet> pets = new HashSet<>();
		petRepository.findAll().forEach(pets::add);
		return pets;
	}

}
