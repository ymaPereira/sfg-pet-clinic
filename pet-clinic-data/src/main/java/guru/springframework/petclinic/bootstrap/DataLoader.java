package guru.springframework.petclinic.bootstrap;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import guru.springframework.petclinic.models.*;
import guru.springframework.petclinic.services.*;
import guru.springframework.petclinic.services.map.*;

@Component
public class DataLoader implements CommandLineRunner{

	private final OwnerService ownerService;
	private final VetService vetService;
	/*private final PetService petService;
	private final PersonService personService;*/
	
	
	
	public DataLoader() {
		super();
		this.ownerService = new OwnerServiceMap();
		this.vetService = new VetServiceMap();
		/*this.petService = new PetServiceMap();
		this.personService = new PersonServiceMap();*/
	}



	@Override
	public void run(String... args) throws Exception {
		
		Owner owner1 = new Owner();
		owner1.setId(1L);
		owner1.setFirstName("Michael");
		owner1.setLastName("Weston");
		ownerService.save(owner1);
		
		Owner owner2 = new Owner();
		owner2.setId(2L);
		owner2.setFirstName("Fiona");
		owner2.setLastName("Weston");
		ownerService.save(owner2);
		
		Vet vet1 = new Vet();
		vet1.setId(1L);
		vet1.setFirstName("Sam");
		vet1.setLastName("Axe");
		vetService.save(vet1);

		Vet vet2 = new Vet();
		vet2.setId(2L);
		vet2.setFirstName("Jessie");
		vet2.setLastName("Porter");
		vetService.save(vet2);
	}

}
