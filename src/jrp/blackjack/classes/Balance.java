package jrp.blackjack.classes;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

/**
 *
 * @author James Park
 */
public class Balance {

    private double starting_balance;
    private double current_balance;
    
    public Balance() {
    }

    public Balance(double balance) {
        this.starting_balance = balance;
        this.current_balance = balance;
    }

//========================GETTERS===============================================    
    public void setStarting_balance(double pBalance) {
        this.starting_balance = pBalance;
    }

    public double getStarting_balance() {
        return starting_balance;
    }
//==============================================================================
    
//========================SETTERS===============================================    
    public void setCurrent_balance(double pBalance) {
        this.current_balance = pBalance;
    }

    public double getCurrent_balance() {
        return current_balance;
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
                }else{
                    JOptionPane.showMessageDialog(null, "Enter numbers only");
                }
            } else {
                System.exit(0);
            }
        }
    }
//==============================================================================
}
