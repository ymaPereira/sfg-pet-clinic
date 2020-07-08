package guru.springframework.petclinic.services;

import java.util.Set;

public interface CrudService<T,ID> {

	T save(T object);
	
	T findById(ID id);
	
	void delete(T object);
	
	void deleteById(ID id);
	
	Set<T> findAll();
}
