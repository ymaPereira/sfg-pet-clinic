package guru.springframework.petclinic.services.map;

import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

import guru.springframework.petclinic.models.Speciality;
import guru.springframework.petclinic.services.SpecialitesService;

@Service
@Profile({"default","map"})
public class SpecialitesMapService extends AbstractServiceMap<Speciality, Long> implements SpecialitesService{

	@Override
	public Speciality save(Speciality object) {
		return super.save(null, object);
	}

}
