public class Start {

    private CalculatorClient client;
    static Start start;

    public Start(){
        this.client = new CalculatorClient();
        client.setVisible(true);
        client.setSize(500,600);
    }

    public static void main(String[] args){
        start = new Start();
    }

    public CalculatorClient getClient(){
        return this.client;
    }

    public static Start getStart(){
        return start;
    }
}
