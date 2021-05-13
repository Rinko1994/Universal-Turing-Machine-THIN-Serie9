package universalTM;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class TuringMachine {
    public static StateCollection currentState;
    public static Map<StateCollection, List<TransferFunction>> stateList = new HashMap<>();
    public String tape;
    private Head head = new Head();

    public TuringMachine(String tape){
        this.tape = tape;
        for(StateCollection stateCollection : StateCollection.values()){
            stateList.put(stateCollection, new ArrayList<TransferFunction>());
        }

        head.processTape(tape);
    }

    public void run(){
        head.processTape(tape);


    }






}
