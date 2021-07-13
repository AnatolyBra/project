package inner.purchase;

import inner.exception.NonPossitiveArgumentException;
import inner.exception.PatternArgumentExcpetion;

public class PriceDiscountPurchase extends Purchase{




    private int discount;

    public PriceDiscountPurchase(Product product, int unitsNumber, int discount) {
        super(product, unitsNumber);
        this.discount = getValidDiscount(discount);
        getDiscountPriceCorrect(product, discount);

    }

    public PriceDiscountPurchase(Product product, String strUnitsNumber, String strDiscount) {
        super(product, strUnitsNumber);
        this.discount = getValidDiscount(strDiscount);
        getDiscountPriceCorrect(product, discount);

    }

    private int getValidDiscount (int discount){
        if (discount<0){
            throw new NonPossitiveArgumentException(discount, "discount");
        }

        return discount;
    }

    private int getValidDiscount (String discount){
        boolean matches = discount.matches("(([0-9]*)[.][0-9]*)|([0-9]*)");
        if (discount.charAt(discount.length()-1)=='0'){
            discount = discount.substring(0, discount.length()-1);
        }

        if (!matches){
            throw new PatternArgumentExcpetion(discount, "discount");
        }
        int amount =0;
        if (discount.contains(".")){
        String[] arr = discount.split("\\.");
        amount = Integer.parseInt(arr[0])* 100 + Integer.parseInt(arr[1]);}
        else amount = Integer.parseInt(discount)* 100;

        return amount;
    }

    private int getDiscountPriceCorrect(Product product, int discount){
        if(discount> getProduct().getPrice().getValue()){
            throw new NonPossitiveArgumentException(discount, "productDiscount");
        }
        return discount;
    }

    public int getDiscount() {
        return discount;
    }
    @Override
    public int getCost(Product product, int unitsNumber){
        int cost = (product.getPrice().getValue() - getDiscount()) * unitsNumber;
        return cost;
    }

    @Override
    public String toString() {
        return getProduct() + "; кол-во товара по скидке " + getUnitsNumber() + "; общая сумма " + getCost(getProduct(), getUnitsNumber());
    }
}
