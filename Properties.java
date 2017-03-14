import java.util.Scanner;

//properties class extends buyable class
//inherits public methods from buyable
public class Properties extends Buyable {
	
	volatile boolean buy;
	
	/**
	 * Constructor
	 * @param nme name of the player
	 * @param cost cost of the property
	 * @param pos position of the player
	 */
	public Properties(String nme, int cost, int pos ){
		super(cost, pos, nme);
	}
	
	/**
	 * @param player current player
	 * if player lands on property that they do not own they have the option to buy it 
	 * else if they do own it they can sell it 
	 */
	public void land(Player player){
		if(!isOwned){
			
			System.out.println(player.getPlayerName() + " has the option to buy the property " + name + " at pos" + player.getBoardPosition() + ". The property costs " + getCost(value) + " . They have " + player.balance.getBalance());
			//buy(player);
			
		}
		else if (turn == true && getOwner() == player){
			sell(player);
		}
	}
	
	/**
	 * @param position position of the player on the board
	 * return value of the property they land on 
	 */
	public int getCost(int position){
		return value;
	}
	
	/**
	 * @param player current player
	 * if player buys a property it returns in a string how many properties they now own
	 * otherwise it will return they have unsufficient funds to buy property
	 */
	public void buy(Player player){
		
		//Buy
		System.out.println("1");
		
		//Get Input
		
		if(player.balance.getBalance()> getCost(value)){
			player.balance.subtractBalance(getCost(player.boardPosition));
			System.out.println(player.getPlayerName() + " has bought this property. They now have " + player.balance.getBalance());
			this.SetOwner(player);
			System.out.println("2");
		}
		else if(player.balance.getBalance()< getCost(value)){
			System.out.println(player.getPlayerName() +" has an insufficient balace to buy this property");
			System.out.println("3");
		}
		else{
			System.out.println("Input is incorrect");
			buy(player);
			System.out.println("4");
		}
	}
	

	/**
	 * @param player current player
	 * if they own a property they land on,
	 * they have the option to sell the property to another player 
	 */
	public void sell(Player player){
		if(isOwned){
			player.balance.addBalance(getCost(player.boardPosition));
			owner = null;
			isOwned = false;
			System.out.println("You have sold the property");
		}
	}
	
	/**
	 * @param player current player
	 */
	public void hotel(Player player){
		if(isOwned){
			player.balance.subtractBalance(getCost(player.boardPosition)*3);
		}
	}
	
	/**
	 * @param player current player
	 * if player lands on property they do not own but someone else on the board does
	 * they must pay rent on this property
	 */
	public void rent(Player player){
		if(!isOwned){
			int rent = getCost((player.boardPosition)*4)/5;
			player.balance.subtractBalance(rent);
			owner.balance.addBalance(rent);
		}
	}
}
