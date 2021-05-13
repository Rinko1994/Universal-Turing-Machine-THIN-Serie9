package universalTM;

public class TransferFunction {
    public StateCollection currentStateCollection;
    public char currentSymbol;
    public StateCollection nextStateCollection;
    public char newSymbol;
    public Direction nextDirection;


    public TransferFunction(StateCollection currentStateCollection, char currentSymbol, StateCollection nextStateCollection,
                            char newSymbol, Direction nextDirection){
        this.currentStateCollection = currentStateCollection;
        this.currentSymbol = currentSymbol;
        this.nextStateCollection = nextStateCollection;
        this.newSymbol = newSymbol;
        this.nextDirection = nextDirection;

    }
}