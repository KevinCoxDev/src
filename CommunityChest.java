import java.util.Random;
public class CommunityChest extends Segment{
	
	/**
	 * Constructor
	 * @param nme name of player
	 * @param pos position of player
	 */
	public CommunityChest(String nme, int pos ){
		super(pos, nme);
	}
	
	/**
	 * @param player current player
	 * if player lands on a community chest
	 */
	public void land(Player player){
		getCommunity(player);
	}
	
	/**
	 * @param player current player
	 * if player lands on a community chest, a card is randomly picked from 1 to 12
	 * player must abide by the card rules
	 */
	Random rand = new Random();
	public void getCommunity(Player player){
		int card = 1 +rand.nextInt(11);
		if (card == 1){
			System.out.println("Advance to Go! - Collect 200!");
			//Add 200 to bank balance
			player.balance.addBalance(200);
		}
		else if (card == 2){
			System.out.println("Bank error in your favor - Collect 200!");
			//Add 200 to bank balance
			player.balance.addBalance(200);
		}
		else if (card == 3){
			System.out.println("Doctor's fee - Pay 50!");
			//Subtract 50 from bank balance
			player.balance.subtractBalance(50);
		}
		else if (card == 4){
			System.out.println("Sale of Stock - Collect 50!");
			//Add 50 to bank balance
			player.balance.addBalance(50);
		}
		else if (card == 5){
			System.out.println("You Have Won Second Prize in a Beauty Contest - Collect 10!");
			//add 10 to bank balance
			player.balance.addBalance(10);
		}
		else if (card == 6){
			System.out.println("Go to Jail!");
			// send person to spot 10 lock them in
			player.setBoardPosition(10);
		}
		else if (card == 7){
			System.out.println("Holiday Fund Matures - Collect 100!");
			//Add 100 to bank balance
			player.balance.addBalance(100);
		}
		else if (card == 8){
			System.out.println("Income tax refund - Collect 20!");
			//add 20 to bank balance
			player.balance.addBalance(20);
		}
		else if (card == 9){
			System.out.println("Life Insurance Matures - Collect 100!");
			//Add 100 to bank balance
			player.balance.addBalance(100);
		}
		else if (card == 10){
			System.out.println("Hospital Fees - Pay 100!");
			// Subtract 100 from bank balance
			player.balance.subtractBalance(100);
		}
		else if (card == 11){
			System.out.println("School Fees - Pay 150!");
			//subtract 150 from bank balance
			player.balance.subtractBalance(150);
		}
		else if (card == 12){
			System.out.println("Consultancy Fee - Collect 25!");
			//add 25 to bank balance
			player.balance.addBalance(25);
		}
		
		System.out.println("CC " + player.getPlayerName() + " " +player.balance.getBalance());
}
}
