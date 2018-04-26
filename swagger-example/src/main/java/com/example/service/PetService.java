package com.example.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.context.NotfoundException;
import com.example.model.PetModel;
import com.example.repository.PetRepository;

@Service
public class PetService {

	private final PetRepository petRepository;
	
	@Autowired
	public PetService(final PetRepository petRepository) {
		
		this.petRepository = petRepository;
	}
	
	public PetModel findPetById(final Long id) {
		
		final PetModel petModel = petRepository.findPetById(id);
		if (petModel != null) {
			
			throw new NotfoundException("Pet not found");
		}
		
		return petModel;
	}

	public List<PetModel> findAllPets() {
		
		return petRepository.findAll();
	}

	public PetModel createPet(final PetModel pet) {
		
		return petRepository.save(pet);
	}
}
