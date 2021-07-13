package inner.purchase;

import inner.exception.CoinsOutOfArrangeException;
import inner.exception.NonPossitiveArgumentException;
import inner.exception.PatternArgumentExcpetion;
import inner.exception.RangeArgumentException;

public class Byn {
    private int value;


    public Byn(int value) {
        this.value = value;
    }

    public Byn(Byn byn) {
        this(byn.getValue());
    }

    public int getValue() {
        return value;
    }

    public Byn(String strByn) {
        this(getValidValue(strByn));
        this.value = value;
    }

    public Byn(int rubs, int coins) {
        this(getValidValue(rubs, coins));
    }


    public static int getValidValue(String value) {
        boolean matches = value.matches("([0-9]*)[.][0-9]{1,2}?$");
        if (!matches) {
            throw new PatternArgumentExcpetion(value, "bynValue");
        }
        String[] arr = value.split("\\.");

        return getValidValue(Integer.parseInt(arr[0]), Integer.parseInt(arr[1]));
    }


    public static int getValidValue(int rubs, int coins) {

        if (coins > 100) {
            throw new CoinsOutOfArrangeException(coins, "bynCoins");
        }
        if (rubs < 0) {
            throw new NonPossitiveArgumentException(rubs, "ruble");
        }
        if (coins < 0) {
            throw new NonPossitiveArgumentException(coins, "coins");
        }
        long amount = 0;
        amount = (long) rubs * 100 + coins;
        if (amount > Integer.MAX_VALUE) {
            throw new RangeArgumentException( amount, "bynAmount");
        }
        return (int) amount;
    }

    @Override
    public String toString() {
        return value + " ";
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Byn byn = (Byn) o;
        return value == byn.value;
    }

    @Override
    public int hashCode() {
        return value;
    }

    public int compareTo (Byn byn){
        if (byn.getValue()!=this.getValue()){
            return (byn.getValue()>this.getValue()?-1:1);
        }
        return 0;
    }
}
