package TuringMachine;

public abstract class TuringMachine {
    private State startingState;
    private Head head;

    private boolean stepMode;

    public TuringMachine(State startingState, int number1, int number2, boolean stepMode) {
        this.startingState = startingState;
        this.head = new Head(number1, number2);
        this.stepMode = stepMode;
    }

}
