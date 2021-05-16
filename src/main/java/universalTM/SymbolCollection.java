package universalTM;

public enum SymbolCollection {

    ZERO("0", '0'), ONE("00", '1'), EMPTY("000", '$');

    public String code;
    public char value;

    private SymbolCollection(String code, char value){
        this.code = code;
        this.value = value;
    }

    public static SymbolCollection decode(String code){
        for(SymbolCollection symbolCollection : SymbolCollection.values()){
            if(symbolCollection.code.equals(code)){
                return symbolCollection;
            }
        }
        return null;
    }
}
