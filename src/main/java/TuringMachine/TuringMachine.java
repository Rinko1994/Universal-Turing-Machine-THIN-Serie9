package TuringMachine;

import java.io.IOException;

public abstract class TuringMachine {
    private State startingState;
    private Head head;

    private boolean stepMode;

    public TuringMachine(State startingState, int number1, int number2, boolean stepMode) {
        this.startingState = startingState;
        this.head = new Head(number1, number2);
        this.stepMode = stepMode;
    }

    protected TuringMachine() {
    }

    public void run() {
        State currentState = this.startingState;
        Transferfunction currentTransition = currentState.getNextTransferFunction(this.head.getCurrentSymbol());
        int counter = 1;
        while (!currentState.acceptedState()) {
            this.head.writeToTape(currentTransition.getWriteSymbol(), currentTransition.getMove());
            String newReadSymbol = this.head.getCurrentSymbol();
            currentState = currentTransition.getCurrentState();
            currentTransition = currentState.getNextTransferFunction(newReadSymbol);
            if (stepMode) {
                this.printTM(currentState, counter);
                try {
                    System.in.read();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            counter++;
        }

        this.printFinalTM(currentState, counter);
    }

    private void printTM(State currentState, int stepCount) {

        System.out.println("---:)---");
        System.out.println("Current state: " + currentState.getName() + " accepted: " + currentState.acceptedState());
        System.out.println("Current head position: " + this.head.getHeadPosition());
        System.out.println("Steps: " + stepCount);
        this.head.printTapeStatus();
        System.out.println("---:)---");

    }

    private void printFinalTM(State currentState, int stepCount) {
        if (!this.stepMode) {
            this.printTM(currentState, stepCount);
        }
        System.out.println("Result: " + this.head.getResult());
    }

}
