package jrp.blackjack.db_handler;

import java.sql.Connection;
import java.sql.Statement;
import java.sql.ResultSet;
import java.sql.SQLException;
import static jrp.blackjack.db_handler.DB_Handler.getConnection;
import jrp.blackjack.classes.Card;

/**
 * @author James Park
 */
public class Cards_DB_Handler {

    public static Card drawCard(int card_id) {

        try {
            Connection con = getConnection();
            Statement stmt = con.createStatement();
            ResultSet drawCard = stmt.executeQuery(
                    "SELECT * FROM deck "
                    + "WHERE "
                    + "card_id = " + card_id
            );

            drawCard.next();

            Card card = new Card(
                    card_id,
                    drawCard.getInt("card_value"),
                    drawCard.getString("card_suit"),
                    drawCard.getString("card_name"),
                    drawCard.getString("card_image_path"),
                    drawCard.getBoolean("card_alt_value")
            );
            
            return card;
            
        } catch (SQLException e) {

            System.err.println("drawCard : error");
            System.err.println("SQLException occured " + e);
        }
        return new Card();
    }
}


