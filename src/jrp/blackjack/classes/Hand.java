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

     
    public Hand() {

        this.hand = new ArrayList<>();
    }

//========================GETTERS===============================================
    public ArrayList<Card> getHand() {
        return hand;
    }

    public int getScore() {
        score = 0;
        for (Card card : hand) {
            score += card.getCard_value();
        }
        return score;
    }

    public int getHitCount() {
        return hitCount;
    }
//==============================================================================
 
//========================SETTERS===============================================
    public void setHand(ArrayList<Card> hand) {
        this.hand = hand;
    }

    public void setScore(int score) {
        this.score = score;
    }

    public void setHitCount(int hitCount) {
        this.hitCount = hitCount;
    }
//==============================================================================
   
//========================METHODS===============================================
    public void addCardToHand(Card pCard) {

        hand.add(pCard);
    }

    public int addToScore(Card pCard) {

        score += pCard.getCard_value();

        return this.score;
    }

    public void incrementHitCount() {
        hitCount++;
    }
//==============================================================================
}
