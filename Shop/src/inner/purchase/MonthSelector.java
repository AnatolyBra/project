package inner.purchase;


import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.Month;


public class MonthSelector {

    public static void main(String[] args) {
        MonthSelector monthSelector = new MonthSelector();

        System.out.println(monthSelector.monthSelector(null));
    }
    public MonthSelector() {
    }

    public DayOfWeek monthSelector(String day) {
        DayOfWeek dayOfWeek;
            try {


            day = day.replaceAll(",", "");
            String[] days = day.split(" ");
            days[0] = days[0].toUpperCase();
            LocalDate localDate = LocalDate.of(Integer.parseInt(days[2]), Month.valueOf(days[0]), Integer.parseInt(days[1]));
                 dayOfWeek = DayOfWeek.from(localDate);
                return dayOfWeek;
            } catch (ArrayIndexOutOfBoundsException | NullPointerException e){
                System.out.println("erroR");
            }



        return null;
    }

}




