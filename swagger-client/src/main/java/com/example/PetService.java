package com.example;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Service;

import com.example.client.PetModel;
import com.example.client.PetsApi;

@Service
@ComponentScan("com.example")
public class PetService {
	
	private final PetsApi petsAPI;
	
	@Autowired
	public PetService(final PetsApi petsAPI) {
		
		this.petsAPI = petsAPI;
	}
	
	public PetModel findPetById(final Long id) {
		
		return petsAPI.findPetByIDUsingGET(id);
	}

	public List<PetModel> findAllPets() {
		
		return petsAPI.findAllPetsUsingGET();
	}

	public PetModel createPet(final PetModel pet) {
		
		return petsAPI.addPetUsingPOST(pet);
	}
}

