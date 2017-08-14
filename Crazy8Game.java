import java.util.ArrayList;
import java.util.Arrays;
import java.util.Stack;
import java.util.Random;

public class Crazy8Game{
  
  public static int numPlayers = 3;
  
  public static void main(String[] args){
 
    Random rand = new Random();
    Game game = new Game();
    /* create the deck */
    Card[] deck = new Card[52]; 
    deck = game.deck_init();  
    /* shuffle the deck */
    deck = game.shuffle(deck);


  
    /* players in the game */
    Player[] players = new Player[numPlayers];
    int[] scoreboard = new int[numPlayers];

    for(int p = 0; p < scoreboard.length; p++){
      scoreboard[p] = 0; 
    }
  
    players[0] = new ExtraCards( Arrays.copyOfRange(deck, 0, 5) );
    System.out.println("0 : " + Arrays.toString( Arrays.copyOfRange(deck, 0, 5))); 
    players[1] = new ExtraCards( Arrays.copyOfRange(deck, 5, 10) );
    System.out.println("0 : " + Arrays.toString( Arrays.copyOfRange(deck, 5, 10))); 
    players[2] = new ExtraCards( Arrays.copyOfRange(deck, 10, 15) );
    System.out.println("0 : " + Arrays.toString( Arrays.copyOfRange(deck, 10, 15))); 


    /* discard and draw piles */
    DiscardPile discardPile = new DiscardPile();
    Stack<Card> drawPile = new Stack<Card>();
    for(int i=15; i<deck.length; i++){
      drawPile.push(deck[i]);
    }

    System.out.println("draw pile is : " + Arrays.toString( Arrays.copyOfRange(deck, 15, deck.length) ));

    deck = null;  

    boolean win = false;
    int player = -1;    // start game play with player 0

    ArrayList<Player> people = new ArrayList<Player>(Arrays.asList(players));
    discardPile.add( drawPile.pop() );

    int count = 0;

    while(!win ){

      /**TESTING ONLY STARTS**/
      /*while(drawPile.isEmpty() != true){
            discardPile.add(drawPile.pop());
      }*/
      /**TESTING ONLY ENDS**/

      player = (player + 1) % players.length;
      System.out.println("player " + player);
      // System.out.println("draw pile    : " + drawPile.peek() );
      // System.out.println("discard pile : " + discardPile.top() );

      win = people.get(player).play(discardPile, drawPile, people);

      //  System.out.println("draw pile   : " + drawPile.peek() );
      //   System.out.println("discard pile : " + discardPile.top() );

      /*shuffle start*/
      System.out.println("draw pile size: " + drawPile.size());

      if(drawPile.size() == 0){
         System.out.println("recycling cards");
   
         Stack <Card> top = new Stack <Card>();
 
         // saves top of discard pile
         top.add(discardPile.pop());
        //  System.out.println("top: " + top);
 
        Card [] recycled_cards = new Card[discardPile.size()];

        recycled_cards = game.recycle(discardPile);

        //clear discard pile
        discardPile.clear();

        //add top back to the discard pile
        discardPile.add(top.pop());

        //shuffling

        //copying back to the draw pile
        for(int k = 0; k < recycled_cards.length; k++){
        drawPile.add(recycled_cards[k]); 
    }

   }
}
  
   System.out.println("winner is player " + player);
   scoreboard = game.score(scoreboard, player);
  
   for(int i = 0; i < scoreboard.length; i++){
    
      System.out.println("Score for: " + i + " " + scoreboard[i]); 
   
   }
  
  
 }
}
 
