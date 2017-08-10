import java.util.ArrayList;
import java.util.Arrays;
import java.util.Stack;
import java.util.Random;

public class Crazy8Game{

 public static void main(String[] args){
  
  /* create the deck */
  Card[] deck = new Card[24];
  int index = 0;
  for(int r=2; r<=7; r+=1){
   for(int s=0; s<4; s+=1){
    deck[index++] = new Card(Card.SUITS[s], Card.RANKS[r]);
   }
  }
  
  /* shuffle the deck */
  Random rnd = new Random();
  Card swap;
  for(int i = deck.length-1; i>=0; i=i-1){
   int pos = rnd.nextInt(i+1);
   swap = deck[pos];
   deck[pos] = deck[i];
   deck[i] = swap;
  }  
  
  
 
  
  /* players in the game */
  Player[] players = new Player[3];
  players[0] = new BadPlayer( Arrays.copyOfRange(deck, 0, 5) );
  System.out.println("0 : " + Arrays.toString( Arrays.copyOfRange(deck, 0, 5))); 
  players[1] = new BadPlayer( Arrays.copyOfRange(deck, 5, 10) );
  System.out.println("0 : " + Arrays.toString( Arrays.copyOfRange(deck, 5, 10))); 
  players[2] = new BadPlayer( Arrays.copyOfRange(deck, 10, 15) );
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

  while( !win ){
System.out.println("count: " + count);    
   

while(drawPile.isEmpty() != true){
      discardPile.add(drawPile.pop());
}
 //  player = (player + 1) % players.length;
/*   System.out.println("player " + player);
   System.out.println("draw pile    : " + drawPile.peek() );
   System.out.println("discard pile : " + discardPile.top() );
*/
//   win = people.get(player).play(discardPile, drawPile, people);
/*
   System.out.println("draw pile   : " + drawPile.peek() );
   System.out.println("discard pile : " + discardPile.top() );
*/


   /*shuffle start*/
   if(drawPile.size() == 0){
     
   //  System.out.println("now shuffling");
   Stack <Card> top = new Stack <Card>();
   Stack <Card> temp = new Stack <Card>();
 
   // saves top of discard pile
   top.add(discardPile.pop());
   System.out.println("top: " + top);
 /*  while(discardPile.isEmpty() != true){     
     drawPile.push(discardPile.pop());
   }
   */
//  System.out.println("draw pile: ");
  
 /* while(drawPile.isEmpty() != true){
    
    System.out.println(drawPile.pop());
    
  }*/
   
  Card [] shuffle_temp = new Card[discardPile.size()];
  int i = 0;
  while(discardPile.isEmpty() != true){

    shuffle_temp[i] = discardPile.pop();
    i++;
    
  }
System.out.println("printing unshuffled array");
  for(i = 0; i < shuffle_temp.length; i++){
    
   System.out.println(shuffle_temp[i]); 
    
  }
  Card shuffle;
   for( i = shuffle_temp.length-1; i>=0; i=i-1){
   int position = rnd.nextInt(i+1);
   shuffle = shuffle_temp[position];
   shuffle_temp[position] = shuffle_temp[i];
   shuffle_temp[i] = shuffle;
  }  
  System.out.println("priniting shuffled array");
  for(int l = 0; l < shuffle_temp.length; l++){
   System.out.println(shuffle_temp[l]);
    
  }
  System.out.println("drawPile size : " + drawPile.size());
  for(int k = 0; k < shuffle_temp.length; k++){
    System.out.println("copying back");
   drawPile.add(shuffle_temp[k]); 
  }
  System.out.println("draw pile size: " + drawPile.size());
  System.out.println("peeking draw pile");
  
  System.out.println(drawPile.peek());
   }
       
//count++;
break;
  }
  
  /*shuffle end*/

  
   System.out.println("printing the shuffled list");
   while(drawPile.isEmpty() != true){
     
    System.out.println(drawPile.pop()); 
   }
   
//  System.out.println("winner is player " + player);
  
 }
 
}
