package main;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class Map {

	DecimalFormat format = new DecimalFormat("#.##");

	Player player = new Player();

	Random random = new Random();

	public double xMovementMetres = 2.5;
	public double yMovementMetres = 2.5;

	public int startXPosition = 15;
	public int startYPosition = 15;

	public int targetXPosition = random.nextInt(30);
	public int targetYPosition = random.nextInt(30);
	public boolean hasReachedTargetPosition = false;

	MapFeature quickSand1 = new QuickSandMapFeature(random.nextInt(10), random.nextInt(10));
	MapFeature quickSand2 = new QuickSandMapFeature(random.nextInt(10), random.nextInt(10));
	MapFeature deadWarrior1 = new FindDeadWarriorMapFeature(random.nextInt(10), random.nextInt(10));
	MapFeature walkingGhoul1 = new WalkingGhoulMapFeature(random.nextInt(10), random.nextInt(10));
	MapFeature walkingGhoul2 = new WalkingGhoulMapFeature(random.nextInt(10), random.nextInt(10));
	MapFeature walkingGhoul3 = new WalkingGhoulMapFeature(random.nextInt(10), random.nextInt(10));
	MapFeature stubbedToe1 = new StubYourToeMapFeature(random.nextInt(10), random.nextInt(10));
	MapFeature stubbedToe2 = new StubYourToeMapFeature(random.nextInt(10), random.nextInt(10));
	MapFeature stubbedToe3 = new StubYourToeMapFeature(random.nextInt(10), random.nextInt(10));
	MapFeature stubbedToe4 = new StubYourToeMapFeature(random.nextInt(10), random.nextInt(10));
	MapFeature guardianAngel1 = new GuardianAngelMapFeature(random.nextInt(10), random.nextInt(10));
	MapFeature endFeature = new EndMapFeature(targetXPosition, targetYPosition);
	List<MapFeature> features = new ArrayList<MapFeature>();

	public void addFeaturesToList() {

		features.add(quickSand1);
		features.add(quickSand2);
		features.add(endFeature);
		features.add(deadWarrior1);
		features.add(walkingGhoul1);
		features.add(walkingGhoul2);
		features.add(walkingGhoul3);
		features.add(stubbedToe1);
		features.add(stubbedToe2);
		features.add(stubbedToe3);
		features.add(stubbedToe4);
		features.add(guardianAngel1);
	}

	public void inputRequest() {
		if (player.health == 0) {
			System.out.println("You have died! Unlucky!");
			System.out.println("Game Over!");
		} else {
			System.out.println("---------------------------------------------------------------------------");
			distanceFromClosestFeature(features);
			Scanner scan = new Scanner(System.in);
			System.out.println("Which way do you want to go? North, South, East or West?");
			System.out.println("Alternatively you can type 'stats' to see your stats");
			String input = scan.nextLine();
			whichWayToMove(input);
			scan.close();
		}
	}

	public void whichWayToMove(String input) {
		if (hasReachedTargetPosition == false) {
			if (input.toLowerCase().equals("north")) {
				player.moveNorth();

			} else if (input.toLowerCase().equals("south")) {
				player.moveSouth();

			} else if (input.toLowerCase().equals("east")) {
				player.moveEast();

			} else if (input.toLowerCase().equals("west")) {
				player.moveWest();

			} else if (input.toLowerCase().equals("stats")) {
				player.showStats();

			} else {
				System.out.println("You typed something other than north, south, east or west. Please try again.");
				inputRequest();
			}
		}
		hasReachedTarget();

		if (hasReachedTargetPosition == false) {
			inputRequest();
		}

		else {
			System.out.println("Congratulations you've found the portal out of this twisted place!");
			System.out.println("Game Over!");
		}
	}

	public boolean hasReachedTarget() {

		if (player.currentXPosition == targetXPosition && player.currentYPosition == targetYPosition) {
			return hasReachedTargetPosition = true;
		} else {
			return hasReachedTargetPosition = false;
		}
	}

	public double distanceFromClosestFeature(List<MapFeature> features) {
		double closestNextFeatureDistance = 0;

		for (MapFeature i : features) {
			int xDistanceFromTarget = i.getxPosition() - player.currentXPosition;
			int yDistanceFromTarget = i.getyPosition() - player.currentYPosition;

			double xMetresAway = xDistanceFromTarget * xMovementMetres;
			double yMetresAway = yDistanceFromTarget * yMovementMetres;

			double metresAway = Math.hypot(xMetresAway, yMetresAway);

			if (closestNextFeatureDistance > metresAway || closestNextFeatureDistance == 0) {
				closestNextFeatureDistance = metresAway;
				if (i.getxPosition() == player.currentXPosition && i.getyPosition() == player.currentYPosition) {
					i.feature(player.health, player.attack);
					features.remove(i);
				}
			}
		}

		System.out.println("Your compass says you are " + format.format(closestNextFeatureDistance)
				+ " metres away from... something.");
		return closestNextFeatureDistance;
	}
}
