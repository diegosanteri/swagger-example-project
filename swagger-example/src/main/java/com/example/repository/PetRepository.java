package com.example.repository;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.springframework.stereotype.Repository;

import com.example.enums.AnimalEnum;
import com.example.model.PetModel;

@Repository
public class PetRepository {

	private final Map<Long, PetModel> pets = initPets();
	
	private Map<Long, PetModel> initPets() {
		
		final Map<Long, PetModel> petMap = new HashMap<Long, PetModel>();
		petMap.put(1L, new PetModel(1L, "Oracio", AnimalEnum.DOG, 5, "Jose"));
		petMap.put(2L, new PetModel(2L, "Pitoco", AnimalEnum.CAT, 1, "Julie"));
		petMap.put(3L, new PetModel(3L, "Hamtaro", AnimalEnum.HAMSTER, 5, "Lucas"));
		petMap.put(4L, new PetModel(4L, "Pingo", AnimalEnum.DOG, 3, "Bruno"));
		petMap.put(5L, new PetModel(5L, "Tico", AnimalEnum.BIRD, 5, "Jose"));
		petMap.put(6L, new PetModel(6L, "Bob", AnimalEnum.DOG, 5, "Jose"));
		petMap.put(7L, new PetModel(7L, "Téo", AnimalEnum.CAT, 5, "Leonardo"));
		petMap.put(8L, new PetModel(8L, "Tedy", AnimalEnum.DOG, 5, "Douglas"));
		
		return petMap;
	}
	
	public PetModel findPetById(Long id) {
		
		return pets.get(id);
	}

	public List<PetModel> findAll() {
		return pets.values().stream().collect(Collectors.toList());
	}

	public PetModel save(PetModel pet) {
		
		final Long newId = Long.valueOf(pets.size() + 1);
		final PetModel newPet = new PetModel(newId, pet.getPetName(), pet.getAnimal(), pet.getAge(), pet.getOwnerName());
		
		return pets.put(newId, newPet);
	}

}
