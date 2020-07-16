package guru.springframework.petclinic.services.map;

import guru.springframework.petclinic.models.Visit;
import guru.springframework.petclinic.services.VisitService;

public class VisitMapService extends AbstractServiceMap<Visit, Long> implements VisitService{

	@Override
	public Visit save(Visit visit) {
		
		if(visit.getPet() == null || visit.getPet().getOwner() == null || visit.getPet().getId() == null || visit.getPet().getOwner().getId() == null) {
			throw new RuntimeException("Invalid Visit");
		}
		return super.save(null, visit);
	}

}
