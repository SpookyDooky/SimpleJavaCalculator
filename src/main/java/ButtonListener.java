import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class ButtonListener {

    private CalculatorClient client;

    public ButtonListener(CalculatorClient client){
        this.client = client;
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
}
