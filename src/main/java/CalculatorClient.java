import java.awt.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.ArrayList;

public class CalculatorClient extends Frame {

    private Font arialFont;
    private TextField inputField;
    private TextField trackerField;

    private ArrayList<Button> numericalButtons;
    private ButtonListener buttonListener;

    //Delete, ClearEntire, Clear, left bracket, right bracket
    private ArrayList<Button> buttonList;

    public CalculatorClient(){
        super("Simple Calculator");
        setLayout(null);

        setFocusable(true);
        requestFocusInWindow();

        this.buttonListener = new ButtonListener(this);
        this.numericalButtons = new ArrayList<Button>();
        this.buttonList = new ArrayList<Button>();
        this.arialFont = new Font("Arial",1,23);
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
        setupInputField();
        setupCalculationTrackerField();
        setupButtons();
    }

    public void setupInputField(){
        TextField displayField = new TextField(40);
        displayField.setBounds(25,95,450,50);
        displayField.setEditable(false);
        Font newFont = new Font("Arial",Font.PLAIN,40);
        displayField.setFont(newFont);
        displayField.enableInputMethods(false);
        this.inputField = displayField;
        add(inputField);
    }

    public void setupCalculationTrackerField(){
        TextField trackerField = new TextField(40);
        trackerField.setBounds(25,40,450,50);
        trackerField.setEditable(false);
        Font newFont = new Font("Arial", Font.PLAIN,40);
        trackerField.setFont(newFont);
        trackerField.enableInputMethods(false);
        this.trackerField = trackerField;
        add(trackerField);
    }

    public TextField getInputField(){
        return this.inputField;
    }

    public TextField getTrackerField(){
        return this.trackerField;
    }

    public void setupButtons(){
        setupNumericalButtons();
        setupEraseButtons();
        setupBracketButtons();
        //Method for attatching action listeners to all buttons of the calculator.
        this.buttonListener.setupAllButtons();
    }

    public void setupNumericalButtons(){ //Grid size is 3 * 3
        int x = 25;
        int y = 150;
        //Height & width are 50
        int number = 9;
        for(int column = 0; column < 3; column++){
            if(column > 0){
                y = 150;
                y = y + column * 55; //Distance between buttons is 5
            }
            for(int row = 0; row < 3; row++){
                Button button = new Button(String.valueOf(((((2-column)*3) + 1) + row)));
                number--;
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

        Button zeroButton = new Button("0");
        zeroButton.setFont(this.arialFont);
        zeroButton.setBounds(80,315,50,50);
        add(zeroButton);
        this.numericalButtons.add(zeroButton);
    }

    public ArrayList<Button> getNumericalButtons(){
        return this.numericalButtons;
    }

    public void setupEraseButtons(){
        Button deleteButton = new Button("DEL");
        deleteButton.setBounds(190,150,50,50);
        deleteButton.setFont(this.arialFont);
        add(deleteButton);

        Button clearEntireButton = new Button("CE");
        clearEntireButton.setBounds(190,205,50,50);
        clearEntireButton.setFont(this.arialFont);
        add(clearEntireButton);

        Button clearButton = new Button("C");
        clearButton.setBounds(190,260,50,50);
        clearButton.setFont(this.arialFont);
        add(clearButton);

        this.buttonList.add(deleteButton);
        this.buttonList.add(clearEntireButton);
        this.buttonList.add(clearButton);
    }

    public void setupBracketButtons(){
        Button leftBracketButton = new Button("(");
        leftBracketButton.setBounds(135,315,50,50);
        leftBracketButton.setFont(this.arialFont);
        add(leftBracketButton);

        Button rightBracketButton = new Button(")");
        rightBracketButton.setBounds(190,315,50,50);
        rightBracketButton.setFont(this.arialFont);
        add(rightBracketButton);

        this.buttonList.add(leftBracketButton);
        this.buttonList.add(rightBracketButton);
    }

    public ArrayList<Button> getButtonList(){
        return this.buttonList;
    }
}
