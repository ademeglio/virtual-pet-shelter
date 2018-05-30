package org.wecancodeit.virtual_pet_shelter;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

public class VirtualPetShelter {
	
	Map<String, VirtualPet> virtualPets = new HashMap<>();
	
	public void addPet(VirtualPet pet) {
		virtualPets.put(pet.getPetName(), pet);
	}

	public VirtualPet findPet(String petName) {
		return virtualPets.get(petName);
	}

	public Collection<VirtualPet> getAllPets() {
		return virtualPets.values();
	}

	public void adoptPet(VirtualPet pet) {
		virtualPets.remove(pet.getPetName(), pet);	
	}

	public void feedAll(Collection<VirtualPet> pets, int qty) {
		for (VirtualPet pet : pets) {
			pet.feed(qty);
		}
	}

	public void waterAll(Collection<VirtualPet> pets, int qty) {
		for (VirtualPet pet : pets) {
			pet.water(qty);
		}
	}
	
	



}
