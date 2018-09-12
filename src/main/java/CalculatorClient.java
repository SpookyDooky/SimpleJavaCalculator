import java.awt.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class CalculatorClient extends Frame {

    public CalculatorClient(){
        super("Simple Calculator");
        setLayout(null);

        setup();
    }

    /**
     * Sub-method for launching all the initialization methods
     */
    public void setup(){
        initWindowListener();
        setupLayout();
    }

    /**
     * Makes sure that the window closes when you press the close button.
     */
    public void initWindowListener(){
        addWindowListener(
                new WindowAdapter() {
                    @Override
                    public void windowClosing(WindowEvent e) {
                        System.exit(1);
                    }
                }
        );
    }

    public void setupLayout(){
        setupDisplayField();
    }

    public void setupDisplayField(){
        TextField displayField = new TextField(40);
        displayField.setBounds(50,50,150,50);
        add(displayField);
    }

    public void setupButtons(){

    }
}
