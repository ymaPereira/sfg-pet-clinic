package guru.springframework.petclinic.services.map;

import guru.springframework.petclinic.models.Vet;
import guru.springframework.petclinic.services.VetService;

public class VetServiceMap extends AbstractServiceMap<Vet, Long> implements VetService{

	@Override
	public Vet save(Vet object) {
		return super.save(object.getId(), object);
	}

}
