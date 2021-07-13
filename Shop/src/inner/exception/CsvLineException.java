package inner.exception;

public class CsvLineException extends IllegalArgumentException{
    public CsvLineException(int a){
        super(String.format("line length is uncorrected %s ", a));
    }
    public CsvLineException(){

    }
}
