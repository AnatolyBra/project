package inner.purchase;

import java.util.Date;

public class WrapperDate {

    private Date date;

    public Date getDate() {
        return date;
    }

    public String getDateSt() {
        return dateSt;
    }

    private String dateSt;

    public WrapperDate(Date date) {
        this.date = date;
    }

    public WrapperDate(String dateSt) {
        this.dateSt = dateSt;
    }

    @Override
    public String toString() {
        return "дата " + getDateSt();
    }
}
