import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class Run2
{
	static boolean running;
	static boolean helping;
	static boolean playing;
	static String command;
	static String raw;
	static ArrayList<Player> players;
	static Player activePlayer;
	static Scanner userInput = new Scanner(System.in);
	static Scanner parser;
	public static void main(String[] args)
	{
		System.out.println("Running...");
		 running = true;
		 System.out.println("welcome message");
		 while(running)
		 {
			 raw = userInput.nextLine().toLowerCase();
			 parser = new Scanner(raw);
			 command = parser.next();
			 if(command.equals("q") || command.equals("quit"))
				 running = false;
			 else if(command.equals("?") || command.equals("h") || command.equals("help"))
			 {
				System.out.println("Launching help...");
				helping = true;
				if(parser.hasNext())
				{
					System.out.println(helpCommand(parser.next()));
					exit("help");
				}
				else
				{
					System.out.println("help init message");
					while(helping)
					{
						
						command = userInput.next().toLowerCase();
						if(command.equals("b") || command.equals("back"))
						{
							exit("help");
						}
					}
				}
			 }
			 
			 else if(command.equals("play") || command.equals("start") || command.equals("p") || command.equals("s"))
			 {
				 playing = true;
				 players = new ArrayList<Player>();
				 System.out.println("How many players would you like?");
				 int numPlayers = userInput.nextInt();
				 for(int i = 0; i < numPlayers; i++)
					 players.add(new Player(i + 1));
				 Collections.shuffle(players);
				 activePlayer = players.get(0);
				 activePlayer.beginTurn();
				 while(playing)
				 {
					 command = userInput.next();
				 }
			 }
			 else
				 System.out.println("Error: \'" + command +  "\' is an unrecognized command or invalid in this context");
		 }
	}
	public static void exit(String menu)
	{
		System.out.println("Exiting " + menu +"...");
		switch(menu)
		{
		case "help": 
			helping = false;
			break;
		default:
			System.out.println("Error tried to exit " + menu + " but that menu type does not exist");
		}
		userInput.nextLine();
	}
	public static String helpCommand(String command)
	{
		return "No help page for '" + command + "'";
	}
	public static boolean responseIsYes()
	{ 
		while(true)
		{
			System.out.println("Type yes or no");
			String response = userInput.next().toLowerCase();
			if(response.equals("y") || response.equals("yes"))
				return true;
			if(response.equals("n") || response.equals("no"))
				return false;			
		}
		
	}
}
