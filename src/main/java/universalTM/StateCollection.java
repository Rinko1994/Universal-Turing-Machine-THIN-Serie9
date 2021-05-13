package universalTM;

import java.util.List;

public enum StateCollection {

    q0("0", false), q1("00", false), q2("000", true),
    q3("0000", false), q4("00000", false), q5("000000", false),
    q6("0000000", false), q7("00000000", false), q8("000000000", false),
    q9("0000000000", false);

    public String code;
    public Boolean accepted;

    private StateCollection(String code, Boolean accepted){
        this.code = code;
        this.accepted = accepted;
    }

    public static StateCollection decode(String code){
        for(StateCollection stateCollection : StateCollection.values()){
            if(stateCollection.code.equals(code)){
                return stateCollection;
            }
        }
        return null;
    }
}
