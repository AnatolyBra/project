package inner.exception;

public class CoinsOutOfArrangeException extends IllegalArgumentException {
    public CoinsOutOfArrangeException(int coins, String bynCoins) {
        super(String.format("uncorrect value %s", coins));
    }
}
