package universalTM;

import java.util.ArrayList;
import java.util.List;

public class TuringMachine {
    public static State currentState;
    public static List<TransferFunction> transferFunctionList = new ArrayList<>();
    private static Head head = new Head();

    public static void run(String tape, Boolean stepByStepMode){
        currentState = State.q0;
        head.processTape(tape, stepByStepMode);
    }
}
