import TuringMachine.Head;
import universalTM.Direction;
import universalTM.StateCollection;
import universalTM.TransferFunction;
import universalTM.TuringMachine;

import java.util.List;

public class Main {

    public static void main(String[] args) {
        args    = new String[1];
        args[0] = "010100001000100110100100100100110010001000100010011001010010100110000101000010100110000100100000100100110000010001000000100010110000010100000001000100110000001000101010011000000101000000101011000000100100000010010110000000100010000000010001001100000001010000000101001100000000100010000000001010110000000010100000000101001100000000010001000000000010001011000000000101000000000101011000000000010001000001010011000000000010100000000001010";
        args[0] += "00100";

        TuringMachine turingMachine = new TuringMachine(args[0]);
    }
}
