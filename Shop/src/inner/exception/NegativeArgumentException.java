package inner.exception;

public class NegativeArgumentException extends IllegalArgumentException{
    public NegativeArgumentException(String name, String productName){
        super(String.format("name %s ", productName));
    }
}
