package TuringMachine;

public class Transferfunction {
    private State currentState;
    private State nextState;
    private String readSymbol;
    private String writeSymbol;
    private Move move;

    public enum Move {
        LEFT, RIGHT
    }

    public Transferfunction(State currentState, State nextState, String readSymbol,
                            String writeSymbol, Move move) {
        this.currentState   = currentState;
        this.nextState      = nextState;
        this.readSymbol     = readSymbol;
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