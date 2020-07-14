package guru.springframework.petclinic.services.map;

import org.springframework.stereotype.Service;

import guru.springframework.petclinic.models.Speciality;
import guru.springframework.petclinic.services.SpecialitesService;

@Service
public class SpecialitesMapService extends AbstractServiceMap<Speciality, String> implements SpecialitesService{

	@Override
	public Speciality save(Speciality object) {
		return super.save(null, object);
	}

}
