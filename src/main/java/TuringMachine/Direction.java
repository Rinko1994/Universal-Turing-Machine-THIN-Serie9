package TuringMachine;

public enum Direction {
    RIGHT(1), LEFT(-1);

    private int i;

    private Direction(int i){
        this.i = i;
    }

    public int getNextMove(){
        return i;
    }
}
