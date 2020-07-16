package guru.springframework.petclinic.services.map;

import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

import guru.springframework.petclinic.models.Person;
import guru.springframework.petclinic.services.PersonService;

@Service
@Profile({"default","map"})
public class PersonServiceMap extends AbstractServiceMap<Person, Long> implements PersonService {

	@Override
	public Person save(Person object) {
		return super.save(object.getId(), object);
	}

}
