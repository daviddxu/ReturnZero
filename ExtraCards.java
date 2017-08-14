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

public class ExtraCards extends Player{
  
   public ExtraCards(Card[] cards){this.hand = new ArrayList<Card>(Arrays.asList(cards));}
 
   public boolean play(DiscardPile discardPile, Stack<Card> drawPile, ArrayList<Player> players){
      
     boolean breaker = false;
     Card addedCard;
    //check if neighbours have only one card left (late stage of the game)
//     System.out.println("this here ran");
     for(int i = 0; i < players.size(); i++){
       if(players.get(i).getSizeOfHand() == 1){                           
        //check if your hand has any power cards
         for(int j = 0; j < this.hand.size(); j++){
           if(this.hand.get(j).getRank() == 2 || this.hand.get(j).getRank() == 4 || this.hand.get(j).getRank() == 7 || this.hand.get(j).getRank() == 8){
             breaker = true;
             break;
           }
         }
        
         if(breaker == true){
 //          System.out.println("breaker true");
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
      //   System.out.println("rank: " + this.hand.get(k).getRank());
      //   System.out.println("suit: " + this.hand.get(k).getSuit());
           
         if(this.hand.get(k).getRank() == discardPile.top().getRank() || this.hand.get(k).getSuit() == discardPile.top().getSuit()){
     //   System.out.println("playing card");
           discardPile.add(this.hand.remove(k)); 
         }
//       System.out.println("this ran");
       }
//     System.out.println("now this ran");
//     System.out.println("hand size: " + this.hand.size());
     if (this.hand.size() == 0){
      return true; 
     } 
       return false;       
   }
  
}
