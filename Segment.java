/**
 * abstract segment class
 */
public abstract class Segment {
	
	volatile boolean turn = false;
	volatile boolean buy = false;
	
	protected int value;
	protected boolean isOwned = false;
	protected boolean buyable = false;

	protected int position;
	protected String name;
	
	/**
	 * @param pos position of player on the board
	 * @param mme name of player
	 */
	public Segment(int pos, String nme){
		position = pos;
		name = nme;
	}
	
	public void land(Player player){	}

	public void buy(Player currentPlayer) {	}
}
