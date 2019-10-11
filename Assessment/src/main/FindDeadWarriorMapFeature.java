package main;

public class FindDeadWarriorMapFeature extends MapFeature {

	int attackGained = 4;

	public FindDeadWarriorMapFeature(int xPosition, int yPosition) {
		super(xPosition, yPosition);
	}

	@Override
	public void feature(int health, int attack) {
		attack += attackGained;
		System.out.println("You find a dead warrior. Looks like he died of");
		System.out.println("thirst... maybe don't drink the water. But you");
		System.out.println("found a cool sword!");
		System.out.println("");
		System.out.println("You've gained " + attackGained + "attack!");
		System.out.println(attack + " is now your attack.");
		System.out.println("");
	}

}
