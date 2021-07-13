package inner.purchase;

import inner.exception.NegativeArgumentException;
import inner.exception.NegativeArgumentPriceException;

public class Product {
    private final String name;
    private final Byn price;
    public String getName() {
        return name;
    }

    public Byn getPrice() {
        return price;
    }




    public Product(String name, Byn price){
        this.name = getValidName(name);
        this.price = getValidPrice(price);
    };


    public String getValidName(String name){
        boolean matches = name.matches("\\b([a-zA-Z][-,a-z]*)+");
        if (!matches){
            throw new NegativeArgumentException(name, "productName");
        }
        return name;
    }

    public Byn getValidPrice (Byn byn){
        if (byn.getValue() <0){
            throw new NegativeArgumentPriceException(byn, "productPrice");
        }
        return byn;
    }

    @Override
    public String toString() {
        return "продукт: " + getName() + "; цена "+ getPrice();
    }


    
}
