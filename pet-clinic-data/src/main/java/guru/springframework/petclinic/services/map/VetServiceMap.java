package guru.springframework.petclinic.services.map;

import org.springframework.stereotype.Service;

import guru.springframework.petclinic.models.Vet;
import guru.springframework.petclinic.services.SpecialitesService;
import guru.springframework.petclinic.services.VetService;

@Service
public class VetServiceMap extends AbstractServiceMap<Vet, Long> implements VetService{

	private final SpecialitesService specialityService;
	
	
	public VetServiceMap(SpecialitesService specialityService) {
		super();
		this.specialityService = specialityService;
	}


	@Override
	public Vet save(Vet object) {
		if(object.getSpecialities().size() > 0) {
			object.getSpecialities().forEach(sp->{
				if(sp.getId() == null) {
					sp = specialityService.save(sp);
				}
			});
		}
		return super.save(object.getId(), object);
	}

}
