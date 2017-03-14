public class Go extends Segment{

	/**
	* @param nme name of player
	* @param pos position of player
	*/

	public Go(String nme, int pos) {
		super(pos, nme);
	}
	
	/**
	* 
	* @param player when the player lands on GO they will receive 200
	* 
	*/
	public void land(Player player){
		player.balance.addBalance(200);
	}
}
