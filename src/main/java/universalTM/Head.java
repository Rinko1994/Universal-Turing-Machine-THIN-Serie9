package universalTM;

import java.util.Arrays;

public class Head {
    private int position = 0;
    private char[] tape;
    private char currentChar;
    private char delimiter = '1';
    private Boolean stepMode;

    public void processTape(String tape, Boolean stepMode){
        this.stepMode = stepMode;
        this.tape = tape.toCharArray();
        currentChar = this.tape[position];

        initializeTransferFunctions();

        processInput();
    }

    private void write(char character){
        tape[position] = character;
    }

    private void initializeTransferFunctions(){
        while(currentChar != delimiter){
            String[] transferFunctionCode = new String[5];
            int iterator = 0;

            while(currentChar != delimiter){
                String currentCode = "";

                while(currentChar != delimiter){
                    if(iterator >= 5){
                        throw new IllegalArgumentException("iterator > 4");
                    }
                    currentCode += currentChar;
                    write('$');
                    readNextChar(Direction.RIGHT);
                }
                write('$');

                transferFunctionCode[iterator] = currentCode;
                iterator++;
                readNextChar(Direction.RIGHT);
            }
            write('$');

            TransferFunction transferFunction = new TransferFunction(State.decode(transferFunctionCode[0]),
                    SymbolCollection.decode(transferFunctionCode[1]).value,
                    State.decode(transferFunctionCode[2]),
                    SymbolCollection.decode(transferFunctionCode[3]).value,
                    Direction.decode(transferFunctionCode[4]));

            TuringMachine.transferFunctionList.add(transferFunction);

            readNextChar(Direction.RIGHT);
        }
        write('$');
    }

    private void processInput(){
        int counter = 0;
        readNextChar(Direction.RIGHT);
        int tapeOriginalLength = tape.length;
        tape = Arrays.copyOf(tape, tape.length * 2);

        for(int i = 0; i < tape.length - tapeOriginalLength; i++){
            tape[tapeOriginalLength + i] = '$';
        }

        while(!TuringMachine.currentState.accepted){
            for(TransferFunction tf : TuringMachine.transferFunctionList){
                if(tf.currentState == TuringMachine.currentState &&
                        tf.currentSymbol == currentChar){
                    counter++;
                    if (stepMode) {
                        System.out.print("Step: " + counter + "| State = " + tf.currentState.toString() +
                                "| Tape: ");
                        for (int i = position - 15; i < position + 16; i++) {
                            if (i == position) {
                                System.out.print("[");
                            }
                            System.out.print(tape[i]);
                            if (i == position) {
                                System.out.print("]");
                            }
                        }
                        System.out.print("\n");
                        System.out.println("_____________________________________________________________________________");
                    }
                    write(tf.newSymbol);
                    readNextChar(tf.nextDirection);
                    TuringMachine.currentState = tf.nextState;
                }
            }
        }
        int result = 0;
        while(currentChar == '0'){
            result++;
            readNextChar(Direction.RIGHT);
        }
        System.out.println("Result: " + result);
    }

    private void readNextChar(Direction direction){
        position += direction.nextPosition;
        currentChar = tape[position];
    }
}