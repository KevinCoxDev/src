import java.util.Scanner;

/**
 * station class extends buyable class
 * station inherits public methods from buyable
 */
public class Station extends Buyable {

	int numOwnedByPlayer;
	
	/**
	 * @param nme name of the player
	 * @param cost cost of the station
	 * @param pos position of the player on the board
	 * 
	 */
	public Station(String nme, int cost, int pos ){
		super(cost, pos, nme);
	}
	
	/**
	 * rent method when player lands on a station owned by another player
	 * @return rent amount due
	 */
	public int rent(){
		float rent = 12.5f;
		for(int x = 1; x <= 4; x++){
			rent *= 2;
			if(x == numOwnedByPlayer){
				break;
			}
		}
		return (int)rent;
	}
	
	/**
	 * @param player current player
	 * if player lands on a station they do not own they can buy
	 * otherwise if they already own it they can sell it  
	 */
	public void land(Player player){
			if(turn == true && !isOwned){
				
				System.out.println(player.getPlayerName() + " has the option to buy the station " + name + " at pos" + player.getBoardPosition() + ". The property costs " + getCost() + " . They have " + player.balance.getBalance());
				
				buy(player);
				
			}
			else if (turn == true && getOwner() == player){
				sell(player);
			}
			
		}
	
	/**
	 * @param player current player
	 * if player lands on station another player owns they must pay rent
	 */
	public void payRent(Player player){
		if(!isOwned && owner != null){
			player.balance.subtractBalance(rent());
		}
	}
	
	/**
	 * @return 200
	 */
	public int getCost(){
		return 200;
	}
	
	/**
	 * @param player current player
	 * if player buys a station it returns in a string how many stations they now own
	 * otherwise it will return they have unsufficient funds to buy a station
	 */
	public void buy(Player player){
		
		//Buy
		System.out.println("1");
		
		//Get Input
		if(player.balance.getBalance()> getCost()){
			player.balance.subtractBalance(getCost());
			System.out.println(player.getPlayerName() + " has bought this station. They now have " + player.balance.getBalance());
			this.SetOwner(player);
			System.out.println("2");
		}
		else if(player.balance.getBalance()< getCost()){
			System.out.println(player.getPlayerName() +" has an insufficient balace to buy this station");
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
	 * if player lands on their station they can sell it
	 */
	public void sell(Player player){
		if(isOwned){
			player.balance.addBalance(getCost());
			owner = null;
			isOwned = false;
			System.out.println("You have sold the property");
		}
	}
	
	
}



