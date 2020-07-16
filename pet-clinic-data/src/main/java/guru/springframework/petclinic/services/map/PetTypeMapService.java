package guru.springframework.petclinic.services.map;

import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;
import guru.springframework.petclinic.models.PetType;
import guru.springframework.petclinic.services.PetTypeService;

@Service
@Profile({"default","map"})
public class PetTypeMapService extends AbstractServiceMap<PetType, Long> implements PetTypeService{

	@Override
	public PetType save(PetType object) {
		return super.save(null, object);
	}

}
