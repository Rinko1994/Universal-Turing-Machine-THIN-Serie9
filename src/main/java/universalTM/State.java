package universalTM;

public class State {
    private String name;
    private Boolean accepted;

    public State(String name, Boolean accepted){
        this.name = name;
        this.accepted = accepted;
    }

    public Boolean isAccepted(){
        return accepted;
    }
}
