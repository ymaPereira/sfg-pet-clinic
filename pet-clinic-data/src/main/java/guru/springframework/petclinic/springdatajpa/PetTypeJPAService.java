package guru.springframework.petclinic.springdatajpa;

import java.util.HashSet;
import java.util.Set;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;
import guru.springframework.petclinic.helpers.ConstantProfile;
import guru.springframework.petclinic.models.PetType;
import guru.springframework.petclinic.repositories.PetTypeRepository;
import guru.springframework.petclinic.services.PetTypeService;

@Service
@Profile(ConstantProfile.SPRING_DATA_JPA)
public class PetTypeJPAService implements PetTypeService{

	private final PetTypeRepository petTypeRepository;

	public PetTypeJPAService(PetTypeRepository petTypeRepository) {
		super();
		this.petTypeRepository = petTypeRepository;
	}

	@Override
	public PetType save(PetType object) {
		return petTypeRepository.save(object);
	}

	@Override
	public PetType findById(Long id) {
		return petTypeRepository.findById(id).orElse(null);
	}

	@Override
	public void delete(PetType object) {
		petTypeRepository.delete(object);
	}

	@Override
	public void deleteById(Long id) {
		petTypeRepository.deleteById(id);
	}

	@Override
	public Set<PetType> findAll() {
		Set<PetType> pettypes = new HashSet<>();
		petTypeRepository.findAll().forEach(pettypes::add);
		return pettypes;
	}
	
	
}
