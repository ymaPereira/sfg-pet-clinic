package guru.springframework.petclinic.services.map;

import org.springframework.stereotype.Service;

import guru.springframework.petclinic.models.Pet;
import guru.springframework.petclinic.services.PetService;

@Service
public class PetServiceMap extends AbstractServiceMap<Pet, String> implements PetService{

	@Override
	public Pet save(Pet object) {
		return super.save(object.getId(), object);
	}

	

}
