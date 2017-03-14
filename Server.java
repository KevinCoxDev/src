//code for server
import java.io.*;
import java.net.*;
import java.util.ArrayList;

public class Server
{
	boolean canBuy = false;
	
	boolean fuckedUp = false;
	boolean option = false;
	
	Player player1;
	Player player2;
	Player player3;
	Player player4;
	
	static Game game = new Game();
	
	//One for each client
    ServerSocket soc0;
    ServerSocket soc1;
    
    Socket s0;
    Socket s1;
    
    //Input and Output stream for each client
    DataInputStream dis0;
    DataInputStream dis1;
    
    DataOutputStream dos0;
    DataOutputStream dos1;
    
    int port1 = 19999;
    int port2 = 19998;
    int port3 = 19997;
    int port4 = 19996;

	private DataOutputStream dos0pos;

	private int posPlayer1;
    
    
    public Server() throws IOException
    {

        System.out.println("Server Started");
        
        ///SET UP FOR EACH CLIENT
        //Only client 0 set up now
        soc0=new ServerSocket(port1);
        s0=soc0.accept();
        System.out.println(s0);
        System.out.println("CLIENT CONNECTED on port " + port1);
        
        dis0= new DataInputStream(s0.getInputStream());
        dos0= new DataOutputStream(s0.getOutputStream());
        dos0pos = new DataOutputStream(s0.getOutputStream());
        
        Game();
    }

    public static void main (String as[]) throws UnknownHostException, IOException
    {
         new Server(); 
    }

    public void Game() throws IOException
    {
    	player1 = new Player(1, "Brian");
    	player2 = new Player(1, "Fishy");
    	player3 = new Player(1, "Nikki");
    	player4 = new Player(1, "Paul");
    	
		ArrayList<Player> players = new ArrayList<Player>();
		
		players.add(player1);
		players.add(player2);
		players.add(player3);
		players.add(player4);
		
		Board board = new Board();
		board.createBoard();
		
		String str = null, s1 = null;
		do
		{
			for(int client = 0; client < 4; client ++){
				// One giant if for each client
				// for each if, change dis, player, dos...
				if(client == 0){
					if(!option && !fuckedUp){
						dos0.writeUTF("Your turn is beginning, Roll the dice. You have " + player1.balance.getBalance());
						dos0.flush();
						posPlayer1 = player1.boardPosition;
						dos0pos.writeInt(posPlayer1);
					}
					
					fuckedUp = false;
					
					//BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
					
				    str=dis0.readUTF();
				    System.out.println(str + " received");
				  
				    //If dice hasn't been rolled yet, and player clicks Roll Dice
				    if(!option && str.equals("turn")){
				    	s1 = CheckString(str, player1);
				        
					    System.out.println(s1 + " = s1");
					    
					    System.out.println("Sending Message " + s1);
					    dos0.writeUTF(s1);
					    dos0.flush();
					   
					    option(player1);
					    
					//If dice has been rolled, but player now has an option to buy or not buy    
				    }else if(option && (str.equals("buy") || str.equals("dontbuy"))){
				    	
				    	s1 = CheckString(str, player1);
				        
					    System.out.println(s1 + " = s1");
					    
					    System.out.println("Sending Message " + s1);
					    dos0.writeUTF(s1);
					    dos0.flush();
					   
					    option(player1);
				    }else{
				    	fuckedUp = true;
				    }
				    //else repeat turn because wrong input??? may not work, fuckin better
	
				    if(!option && !fuckedUp){
				    	dos0.writeUTF("Moving to next player");
					    dos0.flush();
					    //Increment loop of players
					    client++;
				    }
				}
			}
		}
		while(true);
	}
		    
	public String CheckString(String str, Player player){
		if(str.equals("turn")){
			
			return turn(player);
			
		}else if(str.equals("buy")){
			
			return buy();
			
		}else if(str.equals("dontbuy")){
			
			return dontBuy();
			
		}else if(str.equals("sell")){
			
			return sell();
			
		}else{
			
			return "NA";
			
		}
    }
    
    public String buy(){
    	String returnString = "";
    	
    	System.out.println("Buy() called");
    	
    	returnString = game.buy();
    	
    	return returnString;
    }
    
    public String dontBuy(){
    	option = false;
    	return "DontBuy() called";
    }
    
    public String sell(){
    	return "Sell() called";
    }
    
    public String turn(Player player){
    	System.out.println("turn() called");
    	return game.turn(player);
    }
    
    public void option(Player player){
    	option = game.option(player);
    }
}
