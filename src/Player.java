import java.util.ArrayList;
import java.util.Collections;
import java.util.Stack;

class Player
{    

    //int[] hand;
    //int[] deck;
   // int[] amulet;
  //  int[] discard; 
    int cardsDrawn = 0;
    int numInHand = 0;
    int numInAmu = 0;
    int numInDiscard = 0;
    boolean hasPlayed;
    boolean hasCracked;
    String name;
    ArrayList<Gem> hand;
    Stack<Gem> deck;
    ArrayList<Gem> discard;
    ArrayList<Gem> amulet;
    
    public Player(int num)
    {
    	System.out.println("Would you like to enter a name for this player?");
    	if(Run2.responseIsYes())
    	{
    		System.out.println("What would you like to name them?");
    		name = Run2.userInput.next();
    	}
    	else
    		name = "Player " + num;
    	deck = new Stack<Gem>();
    	for(int i = 0; i <= 7; i++)
    	{
    		deck.add(new Gem(Gem.gemType.GLUTTONY));
    		deck.add(new Gem(Gem.gemType.WRATH));
    		deck.add(new Gem(Gem.gemType.SLOTH));
    		deck.add(new Gem(Gem.gemType.ENVY));
    		deck.add(new Gem(Gem.gemType.LUST));
    	}
    	Collections.shuffle(deck);
    	hand = new ArrayList<Gem>();
    	for(int i = 0; i <=5; i++)
    		drawWithVisibility(false);
    	discard = new ArrayList<Gem>();
    	amulet = new ArrayList<Gem>();
    }
    public void drawWithVisibility(boolean visible)
    {
    	hand.add(deck.pop());
    	if(visible)
    		System.out.println(name + " drew " + hand.get(hand.size() - 1).type);
    }
    public void beginTurn()
    {
    	drawWithVisibility(true);
    	hasPlayed = false;
    	hasCracked = false;
    }
}
