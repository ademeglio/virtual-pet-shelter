# My Notes

  * I skipped the stretch tasks this time due to time contraints on my part.


# Virtual Pet Shelter
So, you have some experience under your belt in the care and feeding of a virtual pet. It’s time to share that with the community! Time to volunteer!

## Setup
  * [x] Create a Java project in Eclipse named virtual-pet-shelter.
  * [x] Be sure to set up your testing environment and use the second script, now that you have experience with both JUnit and Hamcrest.
  * [x] Set up a .gitignore. Remember through bash you can type subl .gitignore and it will open a text editor for you. Its contents should include (at minimum):
   ```.classpath
  .gradle/
  .project
  .settings/
  bin/

  ```
  * [x] Create a README.md file in your project folder to describe what you’ve done with your project. No fancy formatting is necessary. Just separate paragraphs with an empty line. (If you’d like to learn more about Markdown formatting, check out the Github Markdown Guide.)
  * [x] Create a GitHub repository also named virtual-pet-shelter and set it up so that you can push your code there from your Eclipse project. Do this now. It’s the least fun part, so just get it out of the way.
  * Create the following classes along with the test class(es) you feel are necessary:
    * [x] `VirtualPet`: You can start with your class from last week’s assignment or create another.
    * [x] `VirtualPetShelter`: Homeless virtual pets need a place to stay.
	  * [x] `VirtualPetShelterApp`: This class will house your `main` method, and be responsible for reading user input and writing output to the console.

## Details
We’re going to use TDD to drive the creation of an application that simulates you taking care of the pets in a shelter.

Include a game loop in this project, too. It should query the user, then call the appropriate method(s) on `VirtualPetShelter` and/or `VirtualPet`. In general, your `VirtualPetApp` should talk to your `VirtualPetShelter`, and your `VirtualPetShelter` should talk to your `VirtualPet`. Try to avoid `VirtualPetApp` talking directly to `VirtualPet` instances, apart from accessing basic information about pets (via `get*` methods).

### Example Interactions
```
Thank you for volunteering at Big Al's Virtual Pet Shelter and Delicatessen!

This is the status of your pets:

Name	|Hunger	|Thirst	|Boredom
--------|-------|-------|-------
Joey	|83     |34     |23
Johnny	|69     |49     |2
Dee Dee	|39     |18     |88
Tommy	|59     |19     |37

What would you like to do next?

1. Feed the pets
2. Water the pets
3. Play with a pet
4. Adopt a pet
5. Admit a pet
6. Quit

```

#### Example Pet Selection Interaction
```
Ok, so you'd like to play with a pet. Please choose one:

[Joey] looks like he's seen better days.
[Johnny] is a bit nervous.
[Dee Dee] probably didn't start with that many legs.
[Tommy] smells like a Stargazer lily fresh with morning dew.

Which pet would you like to play with?
Tommy

Ok, you play with Tommy.

```
## Required Tasks to be completed in the order you feel is necessary
### VirtualPetShelterApp class
  * Create a `main` method that…
    * [x] implements a game loop.
    * [x] asks for user input.
    * [x] writes output to the console.
    * [x] calls `VirtualPetShelter`’s `tick` method after each interaction
  * Available user interface actions should include (at minimum)…
    * [x] feeding all the pets
    * [x] watering all the pets
    * [x] playing with an individual pet, which should display a list of pet names and descriptions, allowing a user to select one
    * [x] allow adoption of a pet, which should display a list of pet names and descriptions, allowing a user to select one
    * [x] allow intake of a pet, prompting the user for the pet’s information, requiring the user to (at minimum) specify name and description

_(Hint: you can use tab characters (“\t”) to align console output in columns.)_

### VirtualPetShelter class
  * [x] include appropriate instance variable(s) to store the pets who reside at the shelter
  * [x] include methods that:
    * [x] return a Collection of all of the pets in the shelter
    * [x] return a specific VirtualPet given its name
    * [x] allow intake of a homeless pet
    * [x] allow adoption of a homeless pet
    * [x] feed all of the pets in the shelter
    * [x] water all of the pets in the shelter
    * [x] plays (or performs some other interaction(s)) with an individual pet in the shelter
    * [x] include a `tick` method that calls the `tick` method for each of the pets in the shelter, updating their needs

### VirtualPet class

In addition to the requirements from last week’s project:

  * include instance variables representing:
    * [x] name (from the above example, this might be “Tommy”)
    * [x] description (from the above example, this might be “smells like a Stargazer lily fresh with morning dew”)
  * include a constructor that accepts a name and description _I used a builder to create my constructor in my original Virtual Pet Project and
  did not want to change the funcionality. It atually helped for the same reason I created it. I was able to set values for testing purposes._
  * include a constructor that, in addition to name and description, accepts default values for the pet’s attributes (hunger, boredom, etc) _see comment in last point_

Do **not** include a default (zero arguments) constructor.


## ~Stretch Tasks~
  * [ ] ~Consider any stretch tasks from last week’s project that you did not attempt.~
  * [ ] ~Keep track of the cleanliness of individual pets’ cages and offer an option in the user interface to clean pet cages~
  * [ ] ~DNA! In order to give your pets individual character, include as part of each pet’s state one or more multipliers for needs so that one pet may become hungrier/thirstier/more bored slower/faster than another pet. (Tip: you could create a class to encapsulate this.)~