package inner.exception;

public class NonPossitiveArgumentException extends IllegalArgumentException {
    public NonPossitiveArgumentException(int rubs, String fieldName) {
        super(String.format("field %s value %s", fieldName, rubs));
    }
}
