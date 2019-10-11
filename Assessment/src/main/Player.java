package main;

public class Player {

	public int currentXPosition = 15;
	public int currentYPosition = 15;
	public int health = 10;
	public int attack = 2;

	public void moveNorth() {
		if (currentYPosition == 30) {
			System.out.println("You are unable to move north.. an unclimbable mountain faces you.");
		} else {
			currentYPosition++;
		}
	}

	public void moveSouth() {
		if (currentYPosition == 0) {
			System.out.println("You are unable to move south.. A dark, dark forest is ahead");
			System.out.println("you see eyes watching you... Probably best to stay in the open swamp.");
		} else {
			currentYPosition--;
		}
	}

	public void moveEast() {
		if (currentXPosition == 30) {
			System.out.println("You are unable to move east... A deep crack in the ground is ahead.");
		}

		else {
			currentXPosition++;
		}
	}

	public void moveWest() {
		if (currentXPosition == 0) {
			System.out.println("You are unable to move west... A long wall blocks your path.");
		} else {
			currentXPosition--;
		}

	}

	public void showStats() {
		System.out.println("Your Health is: " + health);
		System.out.println("Your Attack is: " + attack);
	}

}
