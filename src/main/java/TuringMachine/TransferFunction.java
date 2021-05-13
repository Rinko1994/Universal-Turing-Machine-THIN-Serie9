package TuringMachine;

public class TransferFunction {
    private State currentState;
    private State nextState;
    private String readSymbol;
    private String writeSymbol;
    private Move move;

    public enum Move {
        LEFT, RIGHT
    }

    public TransferFunction(State currentState, State nextState, String readSymbol,
                            String writeSymbol, Move move) {
        this.currentState   = currentState;
        this.readSymbol     = readSymbol;
        this.nextState      = nextState;
        this.writeSymbol    = writeSymbol;
        this.move           = move;
    }

    public State getCurrentState() {
        return currentState;
    }

    public State getNextState() {
        return nextState;
    }

    public String getReadSymbol() {
        return readSymbol;
    }

    public String getWriteSymbol() {
        return writeSymbol;
    }

    public Move getMove() {
        return move;
    }
}
