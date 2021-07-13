package inner.exception;

import inner.purchase.Byn;

public class NegativeArgumentPriceException extends IllegalArgumentException {
    public NegativeArgumentPriceException(Byn byn, String productPrice) {
        super(String.format("byn %s", productPrice));
    }
}
