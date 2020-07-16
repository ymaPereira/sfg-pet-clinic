package guru.springframework.petclinic.springdatajpa;

import java.util.HashSet;
import java.util.Set;

import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

import guru.springframework.petclinic.helpers.ConstantProfile;
import guru.springframework.petclinic.models.Visit;
import guru.springframework.petclinic.repositories.VisitRepository;
import guru.springframework.petclinic.services.VisitService;

@Service
@Profile(ConstantProfile.SPRING_DATA_JPA)
public class VisitJPAService implements VisitService{

	private final VisitRepository visitRepository;

	public VisitJPAService(VisitRepository visitRepository) {
		super();
		this.visitRepository = visitRepository;
	}

	@Override
	public Visit save(Visit object) {
		return visitRepository.save(object);
	}

	@Override
	public Visit findById(Long id) {
		return visitRepository.findById(id).orElse(null);
	}

	@Override
	public void delete(Visit object) {
		visitRepository.delete(object);
	}

	@Override
	public void deleteById(Long id) {
		visitRepository.deleteById(id);
	}

	@Override
	public Set<Visit> findAll() {
		Set<Visit> visits = new HashSet<>();
		visitRepository.findAll().forEach(visits::add);
		return visits;
	}
	
	
}
