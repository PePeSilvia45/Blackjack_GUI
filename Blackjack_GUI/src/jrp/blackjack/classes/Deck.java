package jrp.blackjack.classes;

import java.util.ArrayList;
import java.util.Random;
import jrp.blackjack.classes.Card;
import static jrp.blackjack.db_handler.Cards_DB_Handler.drawCard;

/**
 * @author James Park
 */
public class Deck {

    private ArrayList<Integer> cards;

    public ArrayList<Integer> getCards() {
        return cards;
    }

    public void setCards(ArrayList<Integer> deck) {
        this.cards = deck;
    }

    public Deck() {

        cards = new ArrayList<>();
        for (int i = 1; i < 53; i++) {
            cards.add(i);
        }
    }

    public static Deck shuffleDeck(Deck pDeck) {

        pDeck = new Deck();
        return pDeck;
    }

    public static Card drawCardFromDeck(Deck pDeck) {

        if (pDeck.getCards().size() > 1) {
            
            Random rand = new Random();
            int deck_index = rand.nextInt(pDeck.getCards().size());
            int card_id = pDeck.getCards().get(deck_index);
            pDeck.getCards().remove(deck_index);
            
            Card card = drawCard(card_id);
            
            return card;
            
        }else{
            pDeck = shuffleDeck(pDeck);
            
            Random rand = new Random();
            int deck_index = rand.nextInt(pDeck.getCards().size());
            int card_id = pDeck.getCards().get(deck_index);
            pDeck.getCards().remove(deck_index);
            
            Card card = drawCard(card_id);
            
            return card;
        }
    }
}
