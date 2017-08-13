import java.util.Random;

/*
 * Implements the procedures from Crazy8Game in a separate class (creating a deck, shuffling and keeping score)
 *  
 * 
 * */

public class Game{
  
    public Card[] shuffle(Card[] deck){
    
  Random rnd = new Random();
  Card swap;
  for(int i = deck.length-1; i>=0; i=i-1){
   int pos = rnd.nextInt(i+1);
   swap = deck[pos];
   deck[pos] = deck[i];
   deck[i] = swap;
  }  
    
  return deck;
  }
  
  public   Card[] deck_init(){
  Card[] deck = new Card[52];  
  int index = 0;
  for(int r=2; r<=14; r+=1){
   for(int s=0; s<4; s+=1){
    deck[index++] = new Card(Card.SUITS[s], Card.RANKS[r]);
   }
  }
  return deck;
  }
  
  /*Score keeping*/
  
  public int [] score(int [] players, int winning_player){
    
    players[winning_player]++;
    return players;
  }
}