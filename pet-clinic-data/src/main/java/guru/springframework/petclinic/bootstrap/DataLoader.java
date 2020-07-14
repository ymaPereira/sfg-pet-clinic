package guru.springframework.petclinic.bootstrap;

import java.time.LocalDate;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import guru.springframework.petclinic.models.*;
import guru.springframework.petclinic.services.*;

@Component
public class DataLoader implements CommandLineRunner{

	private final OwnerService ownerService;
	private final VetService vetService;
	private final PetTypeService petTypeService;
	/*private final PetService petService;
	private final PersonService personService;*/
	
	@Autowired
	public DataLoader(OwnerService ownerService, VetService vetService,PetTypeService petTypeService) {
		super();
		this.ownerService = ownerService;
		this.vetService = vetService;
		this.petTypeService = petTypeService;
	}


	@Override
	public void run(String... args) throws Exception {
		System.out.println("Save pet type");
		PetType dog = new PetType();
		dog.setName("Dog");
		dog = petTypeService.save(dog);
		
		PetType cat = new PetType();
		cat.setName("Cat");
		cat = petTypeService.save(cat);
		
		System.out.println("Save owners...");
		Owner owner1 = new Owner();
		owner1.setFirstName("Michael");
		owner1.setLastName("Weston");
		owner1.setAddress("XPTO");
		owner1.setCity("Praia");
		owner1.setTelephone("9999999");
		owner1 = ownerService.save(owner1);
		
		Pet pet1 = new Pet();
		pet1.setOwner(owner1);
		pet1.setPetType(dog);
		pet1.setBirthDate(LocalDate.of(01, 01, 2020));
		pet1.setName("Rosco");
		owner1.getPets().add(pet1);
		
		Owner owner2 = new Owner();
		owner2.setFirstName("Fiona");
		owner2.setLastName("Weston");
		owner2.setAddress("YPTO");
		owner2.setCity("Praia");
		owner2.setTelephone("9999991");
		owner2 = ownerService.save(owner2);


		Pet pet2 = new Pet();
		pet2.setOwner(owner2);
		pet2.setPetType(cat);
		pet2.setBirthDate(LocalDate.of(01, 02, 2020));
		pet2.setName("Just Cat");
		owner2.getPets().add(pet2);
		
		System.out.println("Save vets...");
		Vet vet1 = new Vet();
		vet1.setFirstName("Sam");
		vet1.setLastName("Axe");
		vetService.save(vet1);

		Vet vet2 = new Vet();
		vet2.setFirstName("Jessie");
		vet2.setLastName("Porter");
		vetService.save(vet2);
	}


}
