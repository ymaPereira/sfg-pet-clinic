package guru.springframework.petclinic.springdatajpa;

import java.util.HashSet;
import java.util.Set;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;
import guru.springframework.petclinic.helpers.ConstantProfile;
import guru.springframework.petclinic.models.Vet;
import guru.springframework.petclinic.repositories.VetRepository;
import guru.springframework.petclinic.services.VetService;

@Service
@Profile(ConstantProfile.SPRING_DATA_JPA)
public class VetJPAService implements VetService{

	private final VetRepository vetRepository;
	
	
	public VetJPAService(VetRepository vetRepository) {
		super();
		this.vetRepository = vetRepository;
	}

	@Override
	public Vet save(Vet object) {
		return vetRepository.save(object);
	}

	@Override
	public Vet findById(Long id) {
		return vetRepository.findById(id).orElse(null);
	}

	@Override
	public void delete(Vet object) {
		vetRepository.delete(object);
	}

	@Override
	public void deleteById(Long id) {
		vetRepository.deleteById(id);
	}

	@Override
	public Set<Vet> findAll() {
		Set<Vet> vets = new HashSet<>();
		vetRepository.findAll().forEach(vets::add);
		return vets;
	}

}
