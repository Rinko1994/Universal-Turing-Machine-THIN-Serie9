package TuringMachine;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import static TuringMachine.Direction.RIGHT;

public class TuringMachine {
    private State startingState;
    private State finishingState;
    private Head head;
    private State currentState;


    public TuringMachine(String tape) {
        this.currentState = startingState;
        this.head = new Head(tape);

    }

    public void run() {
        readAutomaton();

        while (currentState != finishingState) {


        }
    }

    private void readAutomaton() {
        List<Character> delimiterList = new ArrayList<>();
        List<Character> lastCharacters = new ArrayList<>();

        for (int i = 0; i < 3; i++) {
            delimiterList.add('1');
        }

        while (delimiterList != lastCharacters) {
            lastCharacters.add(head.getCurrentChar());
            head.nextPosition(RIGHT);
            System.out.println(head.getCurrentChar());
        }

    }

    private void getNextMove() {

    }

    private void getNextState() {


    }
}
/*
    private void printTM(State currentState, int stepCount) {

        System.out.println("---:)---");
        /*System.out.println("Current state: " + currentState.getName() + " accepted: " + currentState.acceptedState());
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
*/