package jrp.blackjack.classes;

/**
 * @author James Park
 */
public class Card {

    private int card_id;
    private int card_value;
    private boolean card_alt_value;
    private String card_suit;
    private String card_name;
    private String card_file_path;

    public int getCard_id() {
        return card_id;
    }

    public int getCard_value() {
        return card_value;
    }

    public boolean isCard_alt_value() {
        return card_alt_value;
    }

    public String getCard_suit() {
        return card_suit;
    }

    public String getCard_name() {
        return card_name;
    }

    public String getCard_file_path() {
        return card_file_path;
    }

    public void setCard_id(int card_id) {
        this.card_id = card_id;
    }

    public void setCard_value(int card_value) {
        this.card_value = card_value;
    }

    public void setCard_alt_value(boolean card_alt_value) {
        this.card_alt_value = card_alt_value;
    }
    
    public void setCard_suit(String card_suit) {
        this.card_suit = card_suit;
    }

    public void setCard_name(String card_name) {
        this.card_name = card_name;
    }

    public void setCard_file_path(String car_file_path) {
        this.card_file_path = car_file_path;
    }

    public Card() {
    }

    public Card(int card_id) {

        this.card_id = card_id;
        this.card_value = 0;
        this.card_suit = "";
        this.card_name = "";
        this.card_file_path = "";
        this.card_alt_value = false;
    }

    public Card(int card_id, int card_value, String card_suit, String card_name, String car_file_path, boolean card_alt_value) {

        this.card_id = card_id;
        this.card_value = card_value;
        this.card_suit = card_suit;
        this.card_name = card_name;
        this.card_file_path = car_file_path;
        this.card_alt_value = card_alt_value;
    }
}
