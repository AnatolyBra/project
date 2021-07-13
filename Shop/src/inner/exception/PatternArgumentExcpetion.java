package inner.exception;

public class PatternArgumentExcpetion extends IllegalArgumentException {
    public PatternArgumentExcpetion(String value, String bynValue) {
    super(String.format("field: %s value: %s", value,bynValue));
    }

}
