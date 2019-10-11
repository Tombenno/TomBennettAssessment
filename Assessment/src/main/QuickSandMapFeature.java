package main;

public class QuickSandMapFeature extends MapFeature {

	int damageInflicted = 2;

	public QuickSandMapFeature(int xPosition, int yPosition) {
		super(xPosition, yPosition);
	}

	@Override
	public void feature(int health, int attack) {
		health -= damageInflicted;
		System.out.println("You've fallen into quicksand! You manage to claw");
		System.out.println("yourself out of it but you've damaged your ankle badly.");
		System.out.println("");
		System.out.println("You've lost " + damageInflicted + "health.");
		System.out.println(health + " health remaining.");
		System.out.println("");
	}

}
