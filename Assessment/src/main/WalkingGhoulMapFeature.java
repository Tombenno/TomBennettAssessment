package main;

public class WalkingGhoulMapFeature extends MapFeature {

	int damageTaken = 5;
	

	public WalkingGhoulMapFeature(int xPosition, int yPosition) {
		super(xPosition, yPosition);
	}

	@Override
	public void feature(int health, int attack) {
		
		if(attack > 5) {
			System.out.println("You see a ghoul wandering the swamp covered in dirt.");
			System.out.println("He turns and runs at you! Luckily you have a cool sword");
			System.out.println("You chop him in half in one clean movement!");
			System.out.println("");
		}
		else {
			health -= damageTaken;
			System.out.println("You see a ghoul wandering the swamp covered in dirt.");
			System.out.println("He turns and runs at you! You battle with him and");
			System.out.println("fight with him the best you can! You kill him, not");
			System.out.println("without harming yourself too!");
			System.out.println("");
			System.out.println("You've lost " + damageTaken + "health.");
			System.out.println(health + " health remaining.");
			System.out.println("");
		}
	}
}
