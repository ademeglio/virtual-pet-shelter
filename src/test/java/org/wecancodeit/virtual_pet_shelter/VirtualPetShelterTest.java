package org.wecancodeit.virtual_pet_shelter;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.nullValue;
import static org.hamcrest.Matchers.containsInAnyOrder;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThat;

import java.util.Collection;

import org.junit.Before;
import org.junit.Test;

public class VirtualPetShelterTest {
	VirtualPetShelter underTest;
	VirtualPet pet1;
	VirtualPet pet2;
	
	@Before
	public void setup() {
		// Arrange
		underTest = new VirtualPetShelter();
		pet1 = new VirtualPet.Builder().name("Rover").description("won't stop running in circles")
				.hunger(2).thirst(2).build();
		pet2 = new VirtualPet.Builder().name("Spike").description("can eat a big cow")
				.hunger(2).thirst(2).build();
	}
		
	
	
	@Test
	public void shouldAddOnePetToShelter() {
		// Act
		underTest.addPet(pet1);
		VirtualPet retreivedPet = underTest.findPet(pet1.getPetName());
		// Assert
		assertThat(retreivedPet, is(pet1));	
	}
	
	@Test
	public void shouldAddTwoPetsToShelter() {
		// Act
		underTest.addPet(pet1);
		underTest.addPet(pet2);
		Collection<VirtualPet> allPets = underTest.getAllPets();
		// Assert
		assertThat(allPets, containsInAnyOrder(pet1, pet2));	
	}
	
	@Test
	public void shouldAdoptAPet() {
		// Act
		underTest.addPet(pet1);
		underTest.adoptPet(pet1);
		VirtualPet retrievedPet = underTest.findPet(pet1.getPetName());
		// Assert
		assertThat(retrievedPet, is(nullValue()));
	}
	
	@Test
	public void shouldFeedAllPets() {
		// Act
		underTest.addPet(pet1);
		underTest.addPet(pet2);
		Collection<VirtualPet> allPets = underTest.getAllPets();
		int pet1HungerLevelStart = pet1.getHunger();
		underTest.feedAll(allPets, 1);
		int pet1HungerLevelEnd = pet1.getHunger();
		// Assert
		assertEquals(pet1HungerLevelEnd, pet1HungerLevelStart - 1 );
		
	}
	
	@Test
	public void shouldWaterAllPets() {
		// Act
		underTest.addPet(pet1);
		underTest.addPet(pet2);
		Collection<VirtualPet> allPets = underTest.getAllPets();
		int pet1ThirstLevelStart = pet1.getThirst();
		underTest.waterAll(allPets, 2);
		int pet1ThirstLevelEnd = pet1.getThirst();
		// Assert
		assertEquals(pet1ThirstLevelEnd, pet1ThirstLevelStart - 2 );
	}
	
	@Test
	public void playWithIndividualPetInShelterBoredomTo0() {
		// Act
		underTest.addPet(pet1);
		underTest.addPet(pet2);
		int roverBoredomLevelStart = pet1.getBored();
		underTest.playWith("Rover", 1);
		int roverBoredomLevelEnd = pet1.getBored();
		// Assert
		assertEquals(roverBoredomLevelEnd, roverBoredomLevelStart - 1 );
		
		
	}
	
} // End VirtualPetShelterTest();
