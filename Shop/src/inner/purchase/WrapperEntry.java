package inner.purchase;

import inner.date.DataParser;
import inner.exception.CsvLineException;

public class WrapperEntry {
    public WrapperDate getDate() {
        return date;
    }

    private final WrapperDate date;

    public Purchase getPurchase() {
        return purchase;
    }

    private final Purchase purchase;

    public WrapperEntry(WrapperDate date, Purchase purchase){
        this.date = date;
        this.purchase = purchase;
    }

    public static WrapperEntry gerValidEntry(String csv) throws CsvLineException {
        String[] values = csv.split(";", 2);	//рассплитить line не более, чем  на 2 подстроки
        if (values.length < 2) {
            throw new CsvLineException();
        }


        DataParser dp = new DataParser(values[0]);
        WrapperDate date = new WrapperDate(dp.parse());


        Purchase purchase = PurchasesFactory.getPurchaseFromFactory(values[1]);
        return new WrapperEntry(date, purchase);
    }

    @Override
    public String toString() {
        return purchase + " " + date;
    }
}
