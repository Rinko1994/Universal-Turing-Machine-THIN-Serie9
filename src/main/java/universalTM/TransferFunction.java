package universalTM;

public class TransferFunction {
    public State currentState;
    public char currentSymbol;
    public State nextState;
    public char newSymbol;
    public Direction nextDirection;

    public TransferFunction(State currentState, char currentSymbol, State nextState,
                            char newSymbol, Direction nextDirection){
        this.currentState = currentState;
        this.currentSymbol = currentSymbol;
        this.nextState = nextState;
        this.newSymbol = newSymbol;
        this.nextDirection = nextDirection;
    }
}