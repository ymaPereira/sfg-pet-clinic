package guru.springframework.petclinic.services.map;

import org.springframework.stereotype.Service;

import guru.springframework.petclinic.models.Vet;
import guru.springframework.petclinic.services.VetService;

@Service
public class VetServiceMap extends AbstractServiceMap<Vet, String> implements VetService{

	@Override
	public Vet save(Vet object) {
		return super.save(object.getId(), object);
	}

}
