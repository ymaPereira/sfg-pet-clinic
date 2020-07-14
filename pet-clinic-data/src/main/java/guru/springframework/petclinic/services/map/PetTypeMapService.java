package guru.springframework.petclinic.services.map;

import org.springframework.stereotype.Service;
import guru.springframework.petclinic.models.PetType;
import guru.springframework.petclinic.services.PetTypeService;

@Service
public class PetTypeMapService extends AbstractServiceMap<PetType, String> implements PetTypeService{

	@Override
	public PetType save(PetType object) {
		return super.save(null, object);
	}

}
