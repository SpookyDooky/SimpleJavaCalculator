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
                }
            });
        }
    }

    public void setupKeyboardButtons(){
        this.client.addKeyListener(new KeyListener() {
            @Override
            public void keyTyped(KeyEvent e) {
                System.out.println(e.getExtendedKeyCode());
            }

            @Override
            public void keyPressed(KeyEvent e) {
                System.out.println(e.getExtendedKeyCode());
            }

            @Override
            public void keyReleased(KeyEvent e) {
                System.out.println(e.getExtendedKeyCode());
            }
        });
    }
}
