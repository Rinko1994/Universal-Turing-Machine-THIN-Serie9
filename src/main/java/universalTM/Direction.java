package universalTM;

public enum Direction {
    RIGHT(1, "00"), LEFT(-1, "0");

    public int nextPosition;
    public String code;

    private Direction(int nextPosition, String code){
        this.nextPosition = nextPosition;
        this.code = code;
    }

    public static Direction decode(String code){
        for(Direction direction : Direction.values()){
            if(direction.code.equals(code)){
                return direction;
            }
        }
        return null;
    }
}