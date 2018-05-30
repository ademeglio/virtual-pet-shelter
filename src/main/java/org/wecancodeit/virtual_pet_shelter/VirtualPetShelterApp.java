package org.wecancodeit.virtual_pet_shelter;

import java.util.Collection;
import java.util.Scanner;

public class VirtualPetShelterApp {

	/*
	 * WeCanCodeIT Module Project 3
	 * by Anthony J. DeMeglio
	 * 5/30/2018
	 * 
	 * Virtual Pet Shelter
	 * Volunteer at the pet shelter and take care of the the pets!
	 * 
	 * https://github.com/ademeglio/virtual-pet-shelter
	 * 
	 */
	
	public static void main(String[] args) {
//		create pet shelter and add initial pets
		VirtualPetShelter petShelter = new VirtualPetShelter();
		VirtualPet pet1 = new VirtualPet.Builder().name("Riley").description("likes to run in circles!").build();
		VirtualPet pet2 = new VirtualPet.Builder().name("Jordan").description("is sooo cute!").build();
		VirtualPet pet3 = new VirtualPet.Builder().name("Angel").description("is blind as a bat!").build();
		
		// Add to the Map
		petShelter.addPet(pet1);
		petShelter.addPet(pet2);
		petShelter.addPet(pet3);
		
		Collection<VirtualPet> petCollection = petShelter.getAllPets();
		
		Scanner userInput = new Scanner(System.in);
//		Welcome
		
		System.out.println("Welcome to the DeMegz Sanctuary! Thank you for volunteering to help care"
				+ "\nfor these fun little creatures! They can be a little finicky but they make great"
				+ "\n pets and I'm sure you'll be fine. All you have to do is feed them, give them"
				+ "\nwater and play with them. I'm sure after a short while, you'll want to adopt and"
				+ "\ntake one home for yourself!");
		
//		Game Loop
		while (true) {
			// pet status
			petShelter.allPetStatus(petCollection);
			
			// menu
			
			// tick
			break;
		} // End Game Loop

	} // End Main

} // End VirtualPetShelter();
