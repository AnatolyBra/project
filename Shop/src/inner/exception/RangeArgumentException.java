package inner.exception;

public class RangeArgumentException extends IllegalArgumentException {
    public RangeArgumentException(long amount, String bynAmount) {
        super(String.format("amount %s ", bynAmount));
    }
}
