
public class Tax extends Segment {
	
	/**
	 * Constructor
	 * @param nme name of player
	 * @param cost cost of property
	 * @param pos position of player on board
	 */
	public Tax(String nme, int cost, int pos) {
		super(pos, nme);
		// TODO Auto-generated constructor stub
	}

	/**
	 * @param player current player
	 * they must pay 200 tax
	 */
	public void land(Player player){
		player.balance.subtractBalance(200);
		System.out.println("They've been taxed 200");
	}
	

}
