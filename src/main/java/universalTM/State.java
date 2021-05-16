package universalTM;

public enum State {

    q0("0", false, "q0"), q1("00", false, "q1"),
    q2("000", true, "q2"), q3("0000", false, "q3"),
    q4("00000", false, "q4"), q5("000000", false, "q5"),
    q6("0000000", false, "q6"), q7("00000000", false, "q7"),
    q8("000000000", false, "q8"), q9("0000000000", false, "q9");

    public String code;
    public Boolean accepted;
    public String name;

    private State(String code, Boolean accepted, String name){
        this.code = code;
        this.accepted = accepted;
        this.name = name;
    }

    public static State decode(String code){
        for(State state : State.values()){
            if(state.code.equals(code)){
                return state;
            }
        }
        return null;
    }

    @Override
    public String toString(){
        return name;
    }
}
