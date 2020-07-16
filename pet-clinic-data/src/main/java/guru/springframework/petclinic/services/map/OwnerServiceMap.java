package guru.springframework.petclinic.services.map;

import org.springframework.stereotype.Service;

import guru.springframework.petclinic.models.Owner;
import guru.springframework.petclinic.models.Pet;
import guru.springframework.petclinic.services.OwnerService;
import guru.springframework.petclinic.services.PetService;
import guru.springframework.petclinic.services.PetTypeService;

@Service
public class OwnerServiceMap extends AbstractServiceMap<Owner, Long> implements OwnerService{

	private final PetService petService;
	private final PetTypeService petTypeService;
		
	public OwnerServiceMap(PetService petService, PetTypeService petTypeService) {
		super();
		this.petService = petService;
		this.petTypeService = petTypeService;
	}

	@Override
	public Owner save(Owner object) {
		if(object != null) {
			if(object.getPets() != null) {
				object.getPets().forEach(pet -> {
					if(pet.getPetType() != null) {
						if(pet.getPetType().getId() == null) {
							pet.setPetType(petTypeService.save(pet.getPetType()));
						}
					}else {
						throw new RuntimeException("The pet type is required");
					}
					if(pet.getId() == null) {
						Pet savedPet = petService.save(pet);
						pet.setId(savedPet.getId());
					}
				});
			}
			return super.save(object.getId(), object);
		}
		return null;
	}

	@Override
	public Owner findByLastName(String lastName) {
		return super.findAll().stream().filter(o->o.getLastName().compareTo(lastName)==0).findFirst().get();
	}

}
