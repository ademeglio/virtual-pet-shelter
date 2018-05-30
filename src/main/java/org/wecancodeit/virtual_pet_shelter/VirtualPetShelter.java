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

	public void playWith(String petName, int val) {
		virtualPets.get(petName).play(val);
	}
	
	// update tick for all pets
	public void updateAllTick(Collection<VirtualPet> pets) {
		for (VirtualPet pet : pets) {
			pet.tick();
		}
	}
	
	// iterate through pets and display them
	public void allPetStatus(Collection<VirtualPet> pets) {
		System.out.println("\nDEMEGZ NAME\t|HUNGER\t|THIRST\t|BOREDOM|TIRED  |");
		System.out.println("----------------|-------|-------|-------|-------|");
		for (VirtualPet pet : pets) {
			System.out.println(pet.getPetName() + "\t\t| " + pet.getHunger()
				+ "\t| " + pet.getThirst() + "\t| " + pet.getBored()
				+ "\t| " + pet.getTired() + "\t| ");
		}
		System.out.println("-------------------------------------------------");
	}
}
