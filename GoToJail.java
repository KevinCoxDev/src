
public class GoToJail extends Segment{
	/**
	 * Constructor 
	 *
	 * @param nme name of player
	 * @param pos position of player
	 * 
	 */
	public GoToJail(String nme,int pos ){
		super(pos, nme);
	}
	/**
	 * @param player when current player lands on jail
	 */
	public void land(Player player){
		jailed(player);
	}
	/**
	 * @param player current player
	 * sends player to jail - board position 10
	 */
	public void jailed(Player player){
		player.setBoardPosition(10);
		player.jailed = true;
	}
	
}
