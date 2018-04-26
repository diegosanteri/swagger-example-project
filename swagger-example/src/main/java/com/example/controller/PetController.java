package com.example.controller;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.example.model.PetModel;
import com.example.service.PetService;

import io.swagger.annotations.Api;

@RestController
@Api(tags="pets")
@RequestMapping(value="/api/v1/pets")
public class PetController {

	
	private final PetService petService;
	
	@Autowired
	public PetController(final PetService petService) {
		
		this.petService = petService;
	}
	
	@RequestMapping(method = RequestMethod.GET)
	public ResponseEntity<List<PetModel>> findAllPets() {
		
		return ResponseEntity.ok(petService.findAllPets());
	}
	
	@RequestMapping(method = RequestMethod.POST)
	public ResponseEntity<PetModel> addPet(@RequestBody PetModel pet) {
		
		try {			
		final PetModel petModel = petService.createPet(pet);		
		URI locatedHeader = new URI("/api/v1/pets/" + petModel.getId());
			return ResponseEntity.created(locatedHeader).body(petModel);
		} catch (URISyntaxException e) {			
			throw new InternalError("Something wrong has happened");
		}
	}
	
	public PetService getPetService() {
		return petService;
	}

	@RequestMapping(value="/{id}", method = RequestMethod.GET)
	public ResponseEntity<PetModel> findPetByID(@PathVariable("id") final Long id) {
		
		return ResponseEntity.ok(petService.findPetById(id));
	}
}
