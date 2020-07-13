package guru.springframework.petclinic.services.map;

import org.springframework.stereotype.Service;

import guru.springframework.petclinic.models.Person;
import guru.springframework.petclinic.services.PersonService;

@Service
public class PersonServiceMap extends AbstractServiceMap<Person, String> implements PersonService {

	@Override
	public Person save(Person object) {
		return super.save(object.getId(), object);
	}

}
