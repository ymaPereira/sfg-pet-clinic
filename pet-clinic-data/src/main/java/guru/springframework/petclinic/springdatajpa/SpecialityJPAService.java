package guru.springframework.petclinic.springdatajpa;

import java.util.HashSet;
import java.util.Set;

import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

import guru.springframework.petclinic.helpers.ConstantProfile;
import guru.springframework.petclinic.models.Speciality;
import guru.springframework.petclinic.repositories.SpecialityRepository;
import guru.springframework.petclinic.services.SpecialitesService;

@Service
@Profile(ConstantProfile.SPRING_DATA_JPA)
public class SpecialityJPAService implements SpecialitesService{

	private final SpecialityRepository specialityRepository;

	public SpecialityJPAService(SpecialityRepository specialityRepository) {
		super();
		this.specialityRepository = specialityRepository;
	}

	@Override
	public Speciality save(Speciality object) {
		return specialityRepository.save(object);
	}

	@Override
	public Speciality findById(Long id) {
		return specialityRepository.findById(id).orElse(null);
	}

	@Override
	public void delete(Speciality object) {
		specialityRepository.delete(object);
	}

	@Override
	public void deleteById(Long id) {
		specialityRepository.deleteById(id);
	}

	@Override
	public Set<Speciality> findAll() {
		Set<Speciality> specialities = new HashSet<>();
		specialityRepository.findAll().forEach(specialities::add);
		return specialities;
	}
	
	
}
