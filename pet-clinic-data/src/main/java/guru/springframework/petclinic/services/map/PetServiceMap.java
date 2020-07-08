package guru.springframework.petclinic.services.map;

import guru.springframework.petclinic.models.Pet;
import guru.springframework.petclinic.services.PetService;

public class PetServiceMap extends AbstractServiceMap<Pet, Long> implements PetService{

	@Override
	public Pet save(Pet object) {
		return super.save(object.getId(), object);
	}

}
