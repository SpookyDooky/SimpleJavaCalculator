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

        for(int x = 0; x < 9; x++){
            final Button currentButton = buttons.get(x);
            currentButton.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                    if(e.getSource() == currentButton){
                        String existingNumber = Start.getStart().getClient().getDisplayField().getText();
                        Start.getStart().getClient().getDisplayField().setText(existingNumber + currentButton.getLabel());
                    }
                    Start.getStart().getClient().setFocusable(true);
                    Start.getStart().getClient().requestFocusInWindow();
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
            }
        });
        //Clear entirely
        list.get(1).addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Start.getStart().getClient().getDisplayField().setText("");
                //Later on clear the stored numbers/calculations in the memory aswell
            }
        });
        //Clear
        list.get(2).addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Start.getStart().getClient().getDisplayField().setText("");
            }
        });
    }
}
