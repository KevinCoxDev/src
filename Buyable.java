
public class Buyable extends Segment {
	
	//public boolean buyable = true;
	
	protected Player owner;
	
	/**
	 * Constructor
	 * @param cost cost of the property
	 * @param pos position of player
	 * @param nme name of player
	 */
	public Buyable(int cost, int pos, String nme){
		super(pos, nme);
		value = cost;
		buyable = true;
	}
	
	/**
	*returns true if the property is owned
	*else returns false
	*/
	public boolean isOwned(){
		return isOwned;
	}
	
	/**
	 * @param player current player
	 * returns true if owner is the current player
	 */
	public boolean isMine(Player player){
		if(owner == player){
			return true;
		}else{
			return false;
		}
	}
	
	public void sell(){
		// link to player to be able to sell at any time
	}
	
	/**
	 * if there is an owner returns player object
	 * else returns null
	 */
	public Player getOwner(){
		if(!isOwned){
			return null;
		}else{
			return owner;
		}
	}
	
	/**
	 * @param player 
	 * sets the owner to current player
	 */
	public void SetOwner(Player player){
		owner = player;
		isOwned = true;
	}
	
}
