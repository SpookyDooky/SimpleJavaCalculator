import java.awt.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.ArrayList;

public class CalculatorClient extends Frame {

    private Font arialFont;
    private TextField displayField;

    private ArrayList<Button> numericalButtons;
    private ButtonListener buttonListener;

    public CalculatorClient(){
        super("Simple Calculator");
        setLayout(null);

        this.buttonListener = new ButtonListener(this);
        this.numericalButtons = new ArrayList<Button>();
        this.arialFont = new Font("Arial",1,30);
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
        setupButtons();
    }

    public void setupDisplayField(){
        TextField displayField = new TextField(40);
        displayField.setBounds(25,40,450,50);
        displayField.enableInputMethods(false);
        Font newFont = new Font("Arial",Font.PLAIN,40);
        displayField.setFont(newFont);
        add(displayField);
        this.displayField = displayField;
    }

    public TextField getDisplayField(){
        return this.displayField;
    }

    public void setupButtons(){
        setupNumericalButtons();
    }

    public void setupNumericalButtons(){ //Grid size is 3 * 3
        int x = 25;
        int y = 95;
        //Height & width are 50
        int number = 1;
        for(int column = 0; column < 3; column++){
            if(column > 0){
                y = 95;
                y = y + column * 55; //Distance between buttons is 5
            }
            for(int row = 0; row < 3; row++){
                Button button = new Button(String.valueOf(number));
                button.setLabel(String.valueOf(number));
                number++;
                if(x > 0){
                    x = 25;
                    x = x + row*55;
                }
                button.setFont(this.arialFont);
                button.setBounds(x,y,50,50);
                add(button);
                this.numericalButtons.add(button);
            }
        }

        this.buttonListener.setupNumericalListeners();
    }

    public ArrayList<Button> getNumericalButtons(){
        return this.numericalButtons;
    }
}
