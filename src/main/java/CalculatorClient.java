import java.awt.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.ArrayList;

public class CalculatorClient extends Frame {

    private Font arialFont;
    private TextField displayField;

    private ArrayList<Button> numericalButtons;
    private ButtonListener buttonListener;

    //Delete, ClearEntire, Clear
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
        setupDisplayField();
        setupButtons();
    }

    public void setupDisplayField(){
        TextField displayField = new TextField(40);
        displayField.setBounds(25,40,450,50);
        displayField.setEditable(false);
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
        setupEraseButtons();
        this.buttonListener.setupAllButtons();
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
    }

    public ArrayList<Button> getNumericalButtons(){
        return this.numericalButtons;
    }

    public void setupEraseButtons(){
        Button deleteButton = new Button("DEL");
        deleteButton.setBounds(190,95,50,50);
        deleteButton.setFont(this.arialFont);
        add(deleteButton);

        Button clearEntireButton = new Button("CE");
        clearEntireButton.setBounds(190,150,50,50);
        clearEntireButton.setFont(this.arialFont);
        add(clearEntireButton);

        Button clearButton = new Button("C");
        clearButton.setBounds(190,205,50,50);
        clearButton.setFont(this.arialFont);
        add(clearButton);

        this.buttonList.add(deleteButton);
        this.buttonList.add(clearEntireButton);
        this.buttonList.add(clearButton);
    }

    public ArrayList<Button> getButtonList(){
        return this.buttonList;
    }
}
