package TuringMachine;

public class Head{
    private int position;
    private char[] tape;
    private char currentChar;
    private boolean isFinished = false;

    public Head(String tape) {
        this.position = 0;
        this.tape = tape.toCharArray();
    }

    private void read(){
        currentChar = tape[position];
    }

    public char getReadChar(){
        return tape[position];
    }

    public void nextPosition(Direction direction){
        position += direction.getNextMove();
    }

    public void write(char newChar){
        tape[position] = newChar;
    }

    public char getCurrentChar(){
        return currentChar;
    }

    public boolean isFinished(){
        return isFinished;
    }



}
