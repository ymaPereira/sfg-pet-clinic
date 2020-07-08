package guru.springframework.petclinic.services.map;

import guru.springframework.petclinic.models.Person;
import guru.springframework.petclinic.services.PersonService;

public class PersonServiceMap extends AbstractServiceMap<Person, Long> implements PersonService {

	@Override
	public Person save(Person object) {
		return super.save(object.getId(), object);
	}

}
