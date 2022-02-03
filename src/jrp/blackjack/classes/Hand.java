package jrp.blackjack.classes;

import java.util.ArrayList;

/**
 *
 * @author James Park
 */
public class Hand {
    
    private ArrayList<Card> hand;
    private int score = 0;
    private int hitCount = 0;

    public ArrayList<Card> getHand() {
        return hand;
    }
    
    public int getScore(){
        return score;
    }

    public int getHitCount(){
        return hitCount;
    }
    
    public void setHand(ArrayList<Card> hand) {
        this.hand = hand;
    }
    
    public void setScore(int score){
        this.score = score;
    }
    
    public void setHitCount(int hitCount){
        this.hitCount = hitCount;
    }
    
    public Hand(){
        
        this.hand = new ArrayList<>();
    }
    
    public void addCardToHand(Card pCard){
        
        hand.add(pCard);      
    }
    
    public int addToScore(Card pCard){
              
        score += pCard.getCard_value();

        return this.score;
    }
    
    public void incrementHitCount(){
        hitCount++;
    }
    
}
