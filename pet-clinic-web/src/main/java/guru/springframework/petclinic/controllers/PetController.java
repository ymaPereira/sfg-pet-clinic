package guru.springframework.petclinic.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import guru.springframework.petclinic.services.PetService;

@Controller
@RequestMapping("/pets")
public class PetController {

	private final PetService petService;
	
	
	public PetController(PetService petService) {
		super();
		this.petService = petService;
	}


	@RequestMapping({"","/","/index","/index.html"})
	public String listVets(Model model) {
		model.addAttribute("pets", petService.findAll());
		return "pets/index";
	}
}
