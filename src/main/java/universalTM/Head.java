package universalTM;

public class Head {
    private int position = 0;
    private char[] tape;
    private char currentChar;
    private char delimiter = '1';

    public void processTape(String tape){
        this.tape = tape.toCharArray();
        currentChar = this.tape[position];

        initializeStates();

        //while(!TuringMachine.currentState.accepted){
            //lis de shit und rechne
        //}
    }

    private void write(char character){
        tape[position] = character;
    }

    private void initializeStates(){
        int counter = position;
        while(currentChar != delimiter){
            String[] transferFunctionCode = new String[5];

            while(currentChar != delimiter){
                String currentCode = "";

                for(int i = 0; i < transferFunctionCode.length; i++) {
                    while (currentChar != delimiter) {
                        currentCode += currentChar;
                        write('$');
                        readNextChar(Direction.RIGHT);
                    }
                    transferFunctionCode[i] = currentCode;
                    currentCode = "";
                    readNextChar(Direction.RIGHT);
                    if(currentChar == delimiter){
                        break;
                    }
                }
                System.out.println("got out");

                counter = position - counter;
                System.out.println(counter);
                TransferFunction transferFunction = new TransferFunction(StateCollection.decode(transferFunctionCode[0]),
                        SymbolCollection.decode(transferFunctionCode[1]).value,
                        StateCollection.decode(transferFunctionCode[2]),
                        SymbolCollection.decode(transferFunctionCode[3]).value,
                        Direction.decode(transferFunctionCode[4]));

                TuringMachine.stateList.get(StateCollection.decode(transferFunctionCode[0])).add(transferFunction);
                readNextChar(Direction.RIGHT);
            }
        }

    }


    private void readInput(){
        for(TransferFunction transferFunction : TuringMachine.stateList.get(TuringMachine.currentState)){
            if(transferFunction.currentSymbol == currentChar){
                tape[position] = transferFunction.newSymbol;
                position += transferFunction.nextDirection.nextPosition;
            }
        }

    }

    private void readNextChar(Direction direction){
        position += direction.nextPosition;
        currentChar = tape[position];
    }

}
