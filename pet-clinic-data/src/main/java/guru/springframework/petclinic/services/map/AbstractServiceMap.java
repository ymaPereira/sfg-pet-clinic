package guru.springframework.petclinic.services.map;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.UUID;

import guru.springframework.petclinic.models.BaseEntity;

public abstract class AbstractServiceMap<T extends BaseEntity,ID extends String>{

	Map<String,T> map = new HashMap<>();
	
	public T save(ID id,T object) {
		if(object != null) {
			if(object.getId() == null) {
				object.setId(getNextId());
			}
			map.put(object.getId(), object);
		}
		map.put(id, object);
		return object;
	}

	public T findById(ID id) {
		return map.get(id);
	}

	public void delete(T object) {
		map.entrySet().removeIf(entry->entry.getValue().equals(object));
	}

	public void deleteById(ID id) {
		map.remove(id);
	}

	public Set<T> findAll() {
		return new HashSet<>(map.values());
	}

	public String getNextId() {
		return UUID.randomUUID().toString();
	}
}
