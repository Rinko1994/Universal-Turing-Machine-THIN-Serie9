package TuringMachine;

// reads from tape alphabet
// writes onto tape alphabet
// can move left/right after reading and writing

public class Head extends TuringMachine{
    private Tape tape;
    private int position;

    public static String SYMBOL = "0";
    public static String SEPARATOR = "1";
    public static String EMPTY = "$";




    public Head(int position) {
        setPosition(position);
    }

    public void setPosition(int position) {
        this.position = position;
    }

    public void moveLeft() {}

    public void moveRight() {}
}
