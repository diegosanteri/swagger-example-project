package com.example.model;

import com.example.enums.AnimalEnum;
import com.fasterxml.jackson.annotation.JsonProperty;

public class PetModel {

	@JsonProperty("id")
	private final Long id;	
	@JsonProperty("pet_name")
	private final String petName;
	@JsonProperty("animal")
	private final AnimalEnum animal;
	@JsonProperty("age")
	private final int age;
	@JsonProperty("owner_name")
	private final String ownerName;
	
	public PetModel(final Long id, final String petName, final AnimalEnum animal, final int age, final String ownerName) {
		
		this.id = id;
		this.petName = petName;
		this.animal = animal;
		this.age = age;
		this.ownerName = ownerName;
	}
	
	
	public Long getId() {
		return id;
	}

	public String getPetName() {
		return petName;
	}

	public AnimalEnum getAnimal() {
		return animal;
	}

	public int getAge() {
		return age;
	}

	public String getOwnerName() {
		return ownerName;
	}
}
