package main;

public class StubYourToeMapFeature extends MapFeature {

	int damageInflicted = 1;

	public StubYourToeMapFeature(int xPosition, int yPosition) {
		super(xPosition, yPosition);
	}

	@Override
	public void feature(int health, int attack) {
		health -= damageInflicted;
		System.out.println("You stubbed your toe! God it hurts like a b****!");
		System.out.println("");
		System.out.println("You've lost " + damageInflicted + "health.");
		System.out.println(health + " health remaining.");
		System.out.println("");
	}

}
