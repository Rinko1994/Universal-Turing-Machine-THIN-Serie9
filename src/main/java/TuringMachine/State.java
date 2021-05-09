package TuringMachine;


import java.util.ArrayList;
import java.util.List;

public class State {
    private String name;
    private boolean acceptedState;
    private List<Transferfunction> transferfunctionList;

    public State(String name, boolean acceptedState) {
        this.name = name;
        this.acceptedState = acceptedState;
        this.transferfunctionList = new ArrayList<Transferfunction>();
    }

    public boolean acceptedState() {
        return acceptedState;
    }

    public String getName() {
        return name;
    }

    public Transferfunction getNextTransferFunction(String readSymbol) {
        for (Transferfunction element : transferfunctionList) {
            if (element.getReadSymbol().equals(readSymbol)) {
                return element;
            }
        }
        throw new IllegalArgumentException("Illegal language");
    }

    public void addTransferfunction(Transferfunction tf) {
        transferfunctionList.add(tf);
    }
}
