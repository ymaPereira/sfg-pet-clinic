package guru.springframework.petclinic.springdatajpa;

import java.util.HashSet;
import java.util.Set;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;
import guru.springframework.petclinic.models.Owner;
import guru.springframework.petclinic.repositories.OwnerRepository;
import guru.springframework.petclinic.repositories.PetRespository;
import guru.springframework.petclinic.repositories.PetTypeRepository;
import guru.springframework.petclinic.services.OwnerService;

@Service
//You can use it @Primary
@Profile("springdatajpa")
public class OwnerJPAservice implements OwnerService{

	private final OwnerRepository ownerRepository;
	private final PetRespository petRepository;
	private final PetTypeRepository petTypeRepository;
	
	
	public OwnerJPAservice(OwnerRepository ownerRepository, PetRespository petRepository,
			PetTypeRepository petTypeRepository) {
		super();
		this.ownerRepository = ownerRepository;
		this.petRepository = petRepository;
		this.petTypeRepository = petTypeRepository;
	}

	@Override
	public Owner save(Owner object) {
		return ownerRepository.save(object);
	}

	@Override
	public Owner findById(Long id) {
		return ownerRepository.findById(id).orElse(null);
	}

	@Override
	public void delete(Owner object) {
		ownerRepository.delete(object);		
	}

	@Override
	public void deleteById(Long id) {
		ownerRepository.deleteById(id);
	}

	@Override
	public Set<Owner> findAll() {
		Set<Owner> owners = new HashSet<>();
		ownerRepository.findAll().forEach(owners::add);
		return owners ;
	}

	@Override
	public Owner findByLastName(String lastName) {
		return ownerRepository.findByLastName(lastName);
	}

}
