package TuringMachine;

// reads from tape alphabet
// writes onto tape alphabet
// can move left/right after reading and writing

import java.util.ArrayList;

public class Head extends TuringMachine{
    private ArrayList<String> tapeArray;
    private int position;

    public static String SYMBOL = "0";
    public static String SEPARATOR = "1";
    public static String BLANK = "$";

    public Head(int number1, int number2) {
        this.tapeArray = new ArrayList<>();
        for (int i = 0; i< number1; i++) {
            tapeArray.add(SYMBOL);
        }
        tapeArray.add(SEPARATOR);
        for (int i = 0; i< number2; i++) {
            tapeArray.add(SYMBOL);
        }
    }

    public String getCurrentSymbol() {
        return getIndexSymbol(position);
    }

    public String getIndexSymbol(int index) {
        try {
            return tapeArray.get(index);
        } catch (IndexOutOfBoundsException e) {
            return BLANK;
        }
    }

    public void setTapeSymbol(String newSymbol) {
        try {
            tapeArray.set(position, newSymbol);
        } catch (IndexOutOfBoundsException e) {
            tapeArray.add(position, newSymbol);
        }
    }

    public void writeToTape(String newSymbol, Transferfunction.Move move) {
        switch (move) {
            case LEFT:
                setTapeSymbol(newSymbol);
                position -= position;
                break;
            case RIGHT:
                setTapeSymbol(newSymbol);
                position += position;
                break;
            default:
                throw new IllegalArgumentException("Illegal move");
            }
        }

    public int getHeadPosition() {
        return position;
    }

    public int getResult() {
        int counter = 0;
        for (String symbol : tapeArray) {
            if (symbol.equals(SYMBOL)) counter++;
        }
        return counter;
    }

    public void printTapeStatus() {
        System.out.println("!");
        for (int i = position - 15; i < this.position; i++) {
            System.out.println(getIndexSymbol(i));
            System.out.println("!");
        }
        System.out.println("q");
        for (int i = position; i < position + 15; i++) {
            System.out.println(getIndexSymbol(i));
            System.out.println("!");
        }
        System.out.println("");
    }

}
