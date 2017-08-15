/*ExtraCards algorithm
 * 
 *
 * (check if power cards are in hand)
 * check if next player has only 1 card left
 * if true: draw one card and do not play (keep running this procedure until a power card is drawn)
 * (in the early game: only draw 1 card) (check game stage if the other players have 3 or less cards)
 * (if the other players have 3 or less cards, keep drawing from the draw pile until a power card is drawn
 * if the draw pile runs out, do the shuffle operation on the discard pile and merge with the draw pile (card refresh)
 * 
 * 
 *KNOWN ISSUES: If all players are ExtraCards, and every player has a power card but none match the top of the discard card pile, no one is able to move. 
 * They cannot pick up cards either, since they all have at least one power card.
 * 
 * 
 *
 * */

import java.util.Arrays;
import java.util.ArrayList;
import java.util.Stack;
import java.util.HashMap;

public class ExtraCards extends Player{
  
  
  public String wildEight(){
    
  HashMap<String, Integer> suits = new HashMap<String, Integer>();
    
  String suit = null;
  String maxsuit = null;
  int count = 0;
  int maxcount = -1;
  for(int i = 0; i < this.hand.size(); i++){
    if(suits.containsKey(this.hand.get(i).getSuit())){
      suits.put(this.hand.get(i).getSuit(), suits.get(this.hand.get(i).getSuit()+1));
    }else{
         suits.put(this.hand.get(i).getSuit(), 1);
    }
  }
    for(int i = 0; i < this.hand.size(); i++){
     suit = this.hand.get(i).getSuit();
     count = suits.get(suit);
     if(count > maxcount){
       maxsuit = suit;
       maxcount = count;
     }   
    }  
     return maxsuit;
       
  }
  
   public ExtraCards(Card[] cards){this.hand = new ArrayList<Card>(Arrays.asList(cards));}
 
   public boolean play(DiscardPile discardPile, Stack<Card> drawPile, ArrayList<Player> players){
      
     Card add = null;
     boolean breaker = false;
     Card addedCard;
    //check if neighbours have only one card left (late stage of the game)
//     System.out.println("this here ran");
     for(int i = 0; i < players.size(); i++){
     //  System.out.println("i: " + i);
       if(players.get(i).getSizeOfHand() == 1){                           
        //check if your hand has any power cards
         for(int j = 0; j < this.hand.size(); j++){
           if(this.hand.get(j).getRank() == 2 || this.hand.get(j).getRank() == 4 || this.hand.get(j).getRank() == 7 || this.hand.get(j).getRank() == 8){
             breaker = true;
             break;
           }
         }
        
         if(breaker == true){
    //       System.out.println("breaker true");
          break; 
         }        
           while(drawPile.size() > 0){         
           addedCard = drawPile.pop();
           this.hand.add(addedCard);          
           if(addedCard.getRank() == 2 || addedCard.getRank() == 4 || addedCard.getRank() == 7 || addedCard.getRank() == 8){
            break; 
           }      
           
         }
       }  
    


         // draw cards until you pick up a power card         
    
       
         if(drawPile.size() == 0){
//          System.out.println("out of cards"); 
         }
     }//end for
     
     //play card
       for(int k = 0; k < this.hand.size(); k++){   
   //      System.out.println("rank: " + this.hand.get(k).getRank());
     //    System.out.println("suit: " + this.hand.get(k).getSuit());
           System.out.println("EC hand: " + this.hand.toString());
         if(this.hand.get(k).getRank() == discardPile.top().getRank() || this.hand.get(k).getSuit() == discardPile.top().getSuit()){
       System.out.println("playing card");
       System.out.println("k: " + k);
       add = this.hand.remove(k);
       System.out.println("add: " + add);
       if(add != null){
         System.out.println("adding");
           discardPile.add(add); 
           break;
       }
         }
//       System.out.println("this ran");
       }
//     System.out.println("now this ran");
   //  System.out.println("hand size: " + this.hand.size());
     if (this.hand.size() == 0){
      return true; 
     } 
       return false;       
   }
  
}
