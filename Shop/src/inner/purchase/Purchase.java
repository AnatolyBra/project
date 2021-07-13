package inner.purchase;


import inner.exception.NegativeArgumentException;
import inner.exception.NonPossitiveArgumentException;
import inner.exception.RangeArgumentException;

public class Purchase {


    private final Product product;
    private final int unitsNumber;

    public Product getProduct() {
        return product;
    }

    public int getUnitsNumber() {
        return unitsNumber;
    }

    public Purchase(Product product, int unitsNumber) {

        this.product = product;
        this.unitsNumber = getValidUnitsNumber(unitsNumber);
        getValidCost(product, unitsNumber);
    }

    public Purchase(Product product, String strUnitsNumber) {

        this.product = product;
        this.unitsNumber = getValidUnitsNumber(strUnitsNumber);
        getValidCost(product, unitsNumber);
    }

    private int getValidUnitsNumber(int a) {
        if (a < 0) {
            throw new NonPossitiveArgumentException(a, "unitsNumber");
        }
        return a;
    }

    private int getValidUnitsNumber(String strUnitsNumber) {
        boolean matches = strUnitsNumber.matches("\\d+");
        if (!matches) {
            throw new NegativeArgumentException(strUnitsNumber, "unitsName");
        }
        return Integer.parseInt(strUnitsNumber);
    }

    private void getValidCost(Product product, int unitsNumber) {
        long amount = 0;
        amount = (long) this.product.getPrice().getValue() * unitsNumber;
        if (amount != (int) amount) {
            throw new RangeArgumentException(amount, "purchaseAmount");
        }

    }
    public int getCost(Product product, int unitsNumber){

        return product.getPrice().getValue() * unitsNumber;
    }

    @Override
    public String toString() {
        return product + "; количество " + unitsNumber + "; общая сумма " + getCost(product, unitsNumber);
    }
}
