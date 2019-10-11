package main;

public class App {

	public static void main(String[] args) {

		Map map = new Map();

		System.out.println("You wake up to find yourself in a very obscure place. You stand up to find ");
		System.out.println("yourself in the middle or a murky grey swamp, your vision stops by a few");
		System.out.println("metres everywhere you look due to the amount of fog rolling over the water.");
		System.out.println("You feel in your pocket and find a compass. A not on the back of it says");
		System.out.println("'I show you the way to good, I show you the way to bad, but following me");
		System.out.println("is the only choice you have'.");

		map.addFeaturesToList();
		map.inputRequest();

	}
}
