package jrp.blackjack.classes;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

/**
 * @author James Park
 */
public class Balance {

    private double starting_balance;
    private double current_balance;
    private double bet;

    public Balance() {
    }

    public Balance(double balance) {
        this.starting_balance = balance;
        this.current_balance = balance;
    }

//========================GETTERS===============================================    
    public double getStarting_balance() {
        return starting_balance;
    }

    public double getCurrent_balance() {
        return current_balance;
    }

    public double getBet() {
        return this.bet;
    }
//==============================================================================

//========================SETTERS===============================================    
    public void setCurrent_balance(double pBalance) {
        this.current_balance = pBalance;
    }

    public void setStarting_balance(double pBalance) {
        this.starting_balance = pBalance;
    }

    public void setBet(double pBet) {
        this.bet = pBet;
    }
//==============================================================================
//========================METHODS===============================================
    public void initial_deposit() {

        JLabel label_deposit = new JLabel("Enter Deposit Amount");
        JTextField get_deposit = new JTextField();

        Object[] initial_deposit = {label_deposit, get_deposit};

        boolean numberEntered = false;
        while (!numberEntered || "".equals(get_deposit.getText())) {
            int userInteraction = JOptionPane.showConfirmDialog(
                    null,
                    initial_deposit,
                    "Add Funds",
                    JOptionPane.OK_CANCEL_OPTION,
                    JOptionPane.PLAIN_MESSAGE
            );

            try {
                Integer.parseInt(get_deposit.getText());
                numberEntered = true;
            } catch (NumberFormatException e) {
                numberEntered = false;
            }

            if (userInteraction == JOptionPane.OK_OPTION) {
                if (numberEntered && !"".equals(get_deposit.getText())) {
                    this.current_balance = Integer.parseInt(get_deposit.getText());
                    this.starting_balance = Integer.parseInt(get_deposit.getText());
                } else {
                    JOptionPane.showMessageDialog(null, "Enter Numbers Only");
                }
            } else {
                System.exit(0);
            }
        }
    }

    public boolean placeBet() {

        JLabel get_bet_label = new JLabel("Place your bet");
        JTextField get_bet_textfield = new JTextField();

        Object[] get_bet_GUI = {get_bet_label, get_bet_textfield};

        boolean isNumber = false;
        while (!isNumber) {
            int userInteraction = JOptionPane.showConfirmDialog(
                    null,
                    get_bet_GUI,
                    "Place Bet",
                    JOptionPane.OK_CANCEL_OPTION,
                    JOptionPane.PLAIN_MESSAGE
            );
            double userBet = Double.parseDouble(get_bet_textfield.getText());
            try {
                userBet = Double.parseDouble(get_bet_textfield.getText());
                isNumber = true;
            } catch (NumberFormatException e) {
                isNumber = false;
            }
            if (userInteraction == JOptionPane.OK_OPTION) {
                if (isNumber && !"".equals(get_bet_textfield.getText()) && userBet <= current_balance) {
                    this.current_balance -= Integer.parseInt(get_bet_textfield.getText());
                    this.bet = userBet;
                    return true;
                } else if(userBet > current_balance) {
                    JOptionPane.showMessageDialog(null, "Insufficent Funds!");
                }else {
                    JOptionPane.showMessageDialog(null, "Enter numbers only");
                }
            } else {
                JOptionPane.showMessageDialog(null, "Place Bet To Continue");
                return false;
            }
        }
        return false;
    }
    
    public void resultWinOrDraw(char outcome, boolean blackjack){
        switch(outcome){
            case'W' -> {
                if(!blackjack){
                    this.current_balance += (this.bet*2);
                }
                else if(blackjack){
                    this.current_balance += (this.bet*2.5);
                }
            }
            case'D' -> this.current_balance += this.bet;
            default -> {
            }
        }
    }
//==============================================================================
}
