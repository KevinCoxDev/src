

public class Game{
	
	public static Player currentPlayer;
	
	Segment seg;
	static int jailCounter = 0;
	boolean jailed = false;
	int turnCounter = 0;
	static int counter = 0;
	
	Dice dice = new Dice();
	Board board = new Board();


	public volatile boolean check = false;
	
	/**
	 * @param player current player
	 * @return returnString gets position of player on the board and other information
	 * turn decides which players go it is 
	 */
	public String turn(Player player){
		String returnString = "";
		
		currentPlayer = player;
		System.out.println("turn starting for " + currentPlayer.playerName);
		if(!player.jailed){
			System.out.println(player.getPlayerName() + " is starting their turn at " + board.getSegment(player.getBoardPosition()).name);
			dice.RollDice();
			int movement = dice.getMovement();	
			returnString += "You have rolled " + movement;
			player.setBoardPosition(movement + player.getBoardPosition());
			seg = board.getSegment(player.getBoardPosition());
			returnString += "\nYou are at " + seg.name;
			returnString += pressCheck(player);
			check =  false;
			System.out.println("turn() has ended");
		}
		else{
			System.out.println(player.getPlayerName() + " is in Jail.");
			jailCounter--;
			System.out.println("turn() has ended");
		}
		
		return returnString;
	}
	
	/**
	 * @param player current player
	 * @return returns true if player lands on a property that is buyable and not owned by another player
	 * otherwise returns false if it is already owned 
	 */
	public Boolean option(Player player){
		Segment seg = board.getSegment(player.getBoardPosition());
		if(seg.buyable && !seg.isOwned){
			return true;
		}
		return false;
	}
	
	/**
	 * @return returnString
	 */
	public String buy(){
		String returnString = "";
		
		if(seg != null){
			System.out.println(seg);
			seg.buy(currentPlayer);
			
			/*
			 * returnString = information on balance and stuff
			 * 
			 */
		}
		
		return returnString;
	}
	
	/**
	 * @param player current player
	 * @return returnString 
	 * 
	 */
	public String pressCheck(Player player){
		String returnString = "";
		
		if(check = true){
			seg.land(player);
		}
		else{
			pressCheck(player);
		}
		
		System.out.println("here");
		System.out.println(seg.buyable + "<- Buyable  isOwned -> " +  seg.isOwned);
		
		if(seg.buyable && !seg.isOwned){
			returnString += "\nYou can buy this for " + seg.value;
		}
		return returnString;
	}
	
	/**
	 * @param player current player
	 * @param position position on the board
	 */
	public void moveDirectly(Player player, int position){
		player.boardPosition = position;
		seg.land(player);
		
	}

	/**
	 * @return currentPlayer player currently on the board
	 */
	public Player getCurrentPlayer() {
		return currentPlayer;
	}
}
