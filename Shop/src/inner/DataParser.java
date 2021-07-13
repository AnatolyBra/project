package inner.date;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class DataParser extends DateParse {
    private static final String REGEXDATE = "([0-3]?[0-9][\\-\\.\\/][0-1]?[0-9][\\-\\.\\/][0-9]{2}?[0-9])";
    private static final Pattern DATE = Pattern.compile(REGEXDATE);
    private static final String REGEXDATEHYPHEN = "([0-3]?[0-9]\\-[0-1]?[0-9]\\-(?:[0-9]{2})?[0-9]{2})";
    private static final Pattern DATEHYPHEN = Pattern.compile(REGEXDATEHYPHEN);

    public DataParser(String line, Pattern pattern) {
        super(line, pattern);
    }
    public DataParser(String line) {
        super(line);
    }
    public DataParser() {

    }



    public String parse() {
        String result = "";
        Matcher matcher = DATEHYPHEN.matcher(getLine());

        DateFormat dateFormat = DateFormat.getDateInstance(DateFormat.LONG, Locale.ENGLISH);
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yy-MM-dd");

        try {
            if (matcher.matches()){
                result=matcher.group();
            }
            Date dateFormat1 = simpleDateFormat.parse(result);
            String a = dateFormat.format(dateFormat1);
            return a;
        }
        catch (ParseException e){
            System.out.println("error");
        }
        return null;
    }
    /*public String parse(WrapperDate wrapperDate) {
        String result = "";
        Matcher matcher = DATEHYPHEN.matcher(wrapperDate.getDateSt());

        DateFormat dateFormat = DateFormat.getDateInstance(DateFormat.LONG, Locale.ENGLISH);
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yy-MM-dd");

        try {
            if (matcher.matches()){
                result=matcher.group();
            }
            Date dateFormat1 = simpleDateFormat.parse(result);
            String a = dateFormat.format(dateFormat1);
            return a;
        }
        catch (ParseException e){
            System.out.println("error");
        }
        return null;
    }*/
}
