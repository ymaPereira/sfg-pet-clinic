package guru.springframework.petclinic.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import guru.springframework.petclinic.services.VetService;

@RequestMapping("vets")
@Controller
public class VetController {

	private final VetService vetService;
	
	@Autowired
	public VetController(VetService vetService) {
		super();
		this.vetService = vetService;
	}


	@RequestMapping({"","/","/index","/index.html"})
	public String listVets(Model model) {
		model.addAttribute("vets", vetService.findAll());
		return "vets/index";
	}
	
	@RequestMapping({"/find"})
	public String findVets() {
		return "notimplemented";
	}
}
