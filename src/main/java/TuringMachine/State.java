package TuringMachine;


import java.util.ArrayList;
import java.util.List;

public class State {
    private int stateNumber;
    private List<TransferFunction> transferFunctionList;
    private Head head;

    public State(int stateNumber, List<TransferFunction> nextMoveList) {
        this.stateNumber = stateNumber;
        this.transferFunctionList = new ArrayList<TransferFunction>();
    }


    public TransferFunction getNextTransferFunction(char readSymbol) {
        for (TransferFunction transferFunction : transferFunctionList) {
            if (transferFunction.getReadSymbol().equals(readSymbol)) {
                return transferFunction;
            }
        }
        throw new IllegalArgumentException("Illegal language");
    }

    public void addTransferFunction(TransferFunction tf) {
        transferFunctionList.add(tf);
    }
}
