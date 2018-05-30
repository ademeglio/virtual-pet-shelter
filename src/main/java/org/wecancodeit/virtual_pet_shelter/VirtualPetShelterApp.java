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
		
		System.out.println("Welcome to the DeMegz Sanctuary!\n\nThank you for volunteering to help care"
				+ " for these fun little creatures! They\ncan be a little finicky but they make great"
				+ " pets and I'm sure you'll be fine.\nAll you have to do is feed them, give them"
				+ "water and play with them. I'm sure\nafter a short while, you'll want to adopt and"
				+ " take one home for yourself!\n");
		
//		Game Loop
		while (true) {
			// pet status
			petShelter.allPetStatus(petCollection);
			
			System.out.println("What would you like to do (1 - 6)? \n");
			
			// menu
			
			System.out.println(" 1. Feed the pets\t\t4. Adopt a pet"
						   + "\n 2. Water the pets\t\t5. Admit a pet"
						   + "\n 3. Play with a pet\t\t6. Quit");
			
			String response = userInput.nextLine();
			
			switch(response) {
			
			case "1" : // Feed the pets
				petShelter.feedAll(petCollection, 1);
				break;
			
			case "2" : // Water the pets
				petShelter.waterAll(petCollection, 1);
				break;
			
			case "3": // Play with a pet
				System.out.println("How fun! Who would you like to play with? Please choose one or \"Quit\":");
				boolean selectionMade = false;
				
				while (!selectionMade) { // loop through until a proper selection is made.
					for (VirtualPet pet : petCollection) {
						System.out.println("[" + pet.getPetName() + "] " + pet.getPetDescription() );
					}
					response = userInput.nextLine();
					VirtualPet currentPet = petShelter.findPet(response);
							
					if (petCollection.contains(currentPet)) {
						petShelter.playWith(response, 2);;
						System.out.println("I think " + currentPet.getPetName() + " is having a great time with you!");
						selectionMade = true;
					} else if (response.toLowerCase().equals("quit")){
						break;
					} else {
						System.out.println("Please pick a name from the list or 'quit'. Thank you.");
					}
				} // end pick a pet to play with	
				break;
				
			case "4": // Adopt a pet
				System.out.println("We knew you couldn't resist! Who would you like to adopt? Type their name or quit to cancel");
				selectionMade = false;
				while (!selectionMade) {
					for (VirtualPet pet : petCollection) {
						System.out.println("[" + pet.getPetName() + "] " + pet.getPetDescription() );
					}
					response = userInput.nextLine();

					petShelter.addPet(petShelter.findPet(response));
				}
				break;				
				
			case "5": //TODO Admit a pet

				break;				

			case "6": // Quit
				userInput.close();
				System.exit(0);
				
			default :
				System.out.println("Please make a valid selection (1 - 6)");
			} // end switch
			
			// tick
			petShelter.updateAllTick(petCollection);
		} // End Game Loop

	} // End Main

} // End VirtualPetShelter();
