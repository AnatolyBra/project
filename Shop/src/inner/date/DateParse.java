package inner.date;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

abstract public class DateParse {
    private String line;
    private Pattern pattern;
    private Matcher matcher;

    public DateParse(String line, Pattern pattern) {
        this.line = line;
        this.pattern = pattern;
        this.matcher = this.pattern.matcher(this.line);
    }
    public DateParse(String line) {
        this.line = line;

    }
    public DateParse() {


    }

    public String getLine() {
        return line;
    }

    public Matcher getMatcher() {
        return matcher;
    }

    public void setLine(String line) {
        this.line = line;
    }

    protected abstract String parse();

}
