package guru.springframework.petclinic.services.map;

import org.springframework.stereotype.Service;

import guru.springframework.petclinic.models.Owner;
import guru.springframework.petclinic.services.OwnerService;

@Service
public class OwnerServiceMap extends AbstractServiceMap<Owner, Long> implements OwnerService{

	@Override
	public Owner save(Owner object) {
		return super.save(object.getId(), object);
	}

	@Override
	public Owner findByLastName(String lastName) {
		return super.findAll().stream().filter(o->o.getLastName().compareTo(lastName)==0).findFirst().get();
	}

}
