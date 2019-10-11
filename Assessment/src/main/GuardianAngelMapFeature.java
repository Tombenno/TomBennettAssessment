package main;

public class GuardianAngelMapFeature extends MapFeature {

	int healthGained = 5;

	public GuardianAngelMapFeature(int xPosition, int yPosition) {
		super(xPosition, yPosition);
	}

	@Override
	public void feature(int health, int attack) {
		health += healthGained;
		System.out.println("A blinding light shoots down from the sky!");
		System.out.println("The angel Jordan has appeared from the clouds!");
		System.out.println("'Here drink this my child' he says. Its a potion.");
		System.out.println("You drink it and he glides back into the light graciously.");
		System.out.println("");
		System.out.println("You've gained " + healthGained + "health!");
		System.out.println(health + " health remaining.");
		System.out.println("");
	}

}
