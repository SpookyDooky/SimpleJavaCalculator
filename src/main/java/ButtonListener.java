import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.ArrayList;

public class ButtonListener {

    private CalculatorClient client;

    public ButtonListener(CalculatorClient client){
        this.client = client;
    }

    public void setupAllButtons(){
        setupNumericalListeners();
        setupKeyboardButtons();
        setupEraseButtons();
    }

    public void setupNumericalListeners(){
        ArrayList<Button> buttons = this.client.getNumericalButtons();

        for(int x = 0; x < 10; x++){
            final Button currentButton = buttons.get(x);
            currentButton.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                    if(e.getSource() == currentButton){
                        String existingNumber = Start.getStart().getClient().getDisplayField().getText();
                        Start.getStart().getClient().getDisplayField().setText(existingNumber + currentButton.getLabel());
                    }
                    fixFocus();
                }
            });
        }
    }

    public void setupKeyboardButtons(){
        this.client.addKeyListener(new KeyListener() {
            @Override
            public void keyTyped(KeyEvent e) {
            }

            @Override
            public void keyPressed(KeyEvent e) {
                if(e.getExtendedKeyCode() == KeyEvent.VK_BACK_SPACE){
                    String current = Start.getStart().getClient().getDisplayField().getText();
                    if(current.length() > 0) {
                        Start.getStart().getClient().getDisplayField().setText(current.substring(0, current.length() - 1));
                    }
                } else if(e.getExtendedKeyCode() >= 48 && e.getExtendedKeyCode() <= 57){
                    int number = e.getExtendedKeyCode() - 48;
                    String numberString = String.valueOf(number);
                    String existingNumber = Start.getStart().getClient().getDisplayField().getText();
                    Start.getStart().getClient().getDisplayField().setText(existingNumber + numberString);
                }
            }

            @Override
            public void keyReleased(KeyEvent e) {
            }
        });
    }

    public void setupEraseButtons(){
        ArrayList<Button> list = this.client.getButtonList();
        //Delete
        list.get(0).addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String current = Start.getStart().getClient().getDisplayField().getText();
                if(current.length() > 0){
                    Start.getStart().getClient().getDisplayField().setText(current.substring(0,current.length() - 1));
                }
                fixFocus();
            }
        });
        //Clear entirely
        list.get(1).addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Start.getStart().getClient().getDisplayField().setText("");
                //Later on clear the stored numbers/calculations in the memory aswell
                fixFocus();
            }
        });
        //Clear
        list.get(2).addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Start.getStart().getClient().getDisplayField().setText("");
                fixFocus();
            }
        });
    }

    public void fixFocus(){
        this.client.setFocusable(true);
        this.client.requestFocusInWindow();
    }
}
