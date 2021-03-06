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
	private final SpecialitesService specialitesService;
	private final VisitService visitService;
	private final PetService petService;
	
	@Autowired
	public DataLoader(OwnerService ownerService, VetService vetService, PetTypeService petTypeService,
			SpecialitesService specialitesService, VisitService visitService, PetService petService) {
		super();
		this.ownerService = ownerService;
		this.vetService = vetService;
		this.petTypeService = petTypeService;
		this.specialitesService = specialitesService;
		this.visitService = visitService;
		this.petService = petService;
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
		pet1.setBirthDate(LocalDate.now());
		pet1.setName("Rosco");
		pet1 = petService.save(pet1);
		owner1.getPets().add(pet1);
		
		Owner owner2 = new Owner();
		owner2.setFirstName("Fiona");
		owner2.setLastName("Weston");
		owner2.setAddress("YPTO");
		owner2.setCity("Praia");
		owner2.setTelephone("9999991");
		owner2 = ownerService.save(owner2);

		Visit catVisit = new Visit();
		catVisit.setDate(LocalDate.now());
		catVisit.setDescription("Visit 1");
		catVisit.setPet(pet1);
		catVisit = visitService.save(catVisit);
		
		Pet pet2 = new Pet();
		pet2.setOwner(owner2);
		pet2.setPetType(cat);
		pet2.setBirthDate(LocalDate.now());
		pet2.setName("Just Cat");
		owner2.getPets().add(pet2);
		
		System.out.println("Save specialities");
		Speciality sp1 = new Speciality();
		sp1.setDescription("Speciality 1");
		sp1 = specialitesService.save(sp1);
		

		Speciality sp2 = new Speciality();
		sp2.setDescription("Speciality 2");
		sp2 = specialitesService.save(sp2);
		
		System.out.println("Save vets...");
		Vet vet1 = new Vet();
		vet1.setFirstName("Sam");
		vet1.setLastName("Axe");
		vet1.getSpecialities().add(sp1);
		vet1 = vetService.save(vet1);

		Vet vet2 = new Vet();
		vet2.setFirstName("Jessie");
		vet2.setLastName("Porter");
		vet2.getSpecialities().add(sp2);
		vet2 = vetService.save(vet2);
	}


}
