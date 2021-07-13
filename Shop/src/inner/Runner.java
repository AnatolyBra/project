
import inner.exception.CsvLineException;
import inner.purchase.*;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.text.SimpleDateFormat;
import java.time.DayOfWeek;
import java.util.*;

public class Runner {
    private static List<PriceDiscountPurchase> priceDiscountPurchases = new ArrayList<>();
    private static Map<Purchase, WrapperDate> purchasesMap = new HashMap<>();
    private static Map<DayOfWeek, List<Purchase>> dayPurchasesMap = new EnumMap<>(DayOfWeek.class);
    private static List<DayOfWeek> listOfDay = new ArrayList<>();

    public static void main(String[] args) throws FileNotFoundException {
        Date date = new Date();
        SimpleDateFormat sp = new SimpleDateFormat("EEEE", Locale.ENGLISH);

        File file = new File("date.txt");
        //args[0] = "date.txt";
        try (Scanner sc = new Scanner(new FileReader(file))) {

            {

                while (sc.hasNext()) {
                    String line = sc.nextLine();

                    try {
                        String[] values = line.split(";", 2);	//рассплитить line не более, чем  на 2 подстроки
                        if (values.length < 2) {
                            throw new CsvLineException();
                        }


                        List<Purchase> listOfPurchases = new ArrayList<>();

                        WrapperEntry entry = WrapperEntry.gerValidEntry(line);
                        listOfPurchases.add(entry.getPurchase());



                        /*purchasesMap.put(entry.getPurchase(), entry.getDate());

                        if (entry.getPurchase() instanceof PriceDiscountPurchase) {
                            PriceDiscountPurchase priceDiscountPurchase =
                                    new PriceDiscountPurchase(entry.getPurchase().getProduct(), entry.getPurchase().getUnitsNumber(),
                                            ((PriceDiscountPurchase) entry.getPurchase()).getDiscount());
                            priceDiscountPurchases.add(priceDiscountPurchase);
                        }*/

                        MonthSelector monthSelector = new MonthSelector();
                        DayOfWeek dayOfWeek= monthSelector.monthSelector(entry.getDate().getDateSt());
                       if(dayOfWeek != null) {
                           dayPurchasesMap.put(dayOfWeek, listOfPurchases);
                       }

                    } catch (CsvLineException e) {
                        //System.out.println("error");
                    }
                }

            }
        } catch (FileNotFoundException e) {
            //System.out.println("error");
        }
        System.out.println();
        /*priceDiscountPurchases.forEach(System.out::println);
        System.out.println();
        purchasesMap.entrySet().forEach(System.out::println);
        System.out.println();*/
        dayPurchasesMap.entrySet().forEach(System.out::println);


    }
}
