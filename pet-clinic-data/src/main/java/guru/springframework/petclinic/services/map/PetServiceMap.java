package guru.springframework.petclinic.services.map;

import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

import guru.springframework.petclinic.models.Pet;
import guru.springframework.petclinic.services.PetService;

@Service
@Profile({"default","map"})
public class PetServiceMap extends AbstractServiceMap<Pet, Long> implements PetService{

	@Override
	public Pet save(Pet object) {
		return super.save(object.getId(), object);
	}

	

}
