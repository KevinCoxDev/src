import java.util.Random;

public class Dice {
	
	Random rand = new Random();
	int face1;
	int face2;
	volatile boolean pressed;
	
	/**
	 * Constructor
	 */
	public Dice(){
		
	}
	
	/**
	 * 
	 */
	public void RollDice(){
		int[]test = {6,7,8};
		int testRoll = rand.nextInt(3);
		face1 = test[testRoll];
		System.out.println(face1 + " has been rolled.");
	}
	
	/**
	 * 
	 */
	public int getMovement(){
		int totalMovement = face1;
		return totalMovement;
	}
	
}
