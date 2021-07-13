
import java.io.*;
import java.util.ArrayList;
import java.util.Collection;
import java.util.concurrent.ForkJoinPool;


public class Main {

    public static final String LINK = "https://lenta.ru";

    public static void main(String[] args) throws IOException {
        HTMLParser parser = new HTMLParser(LINK);

        GenerateMap generateMap = new GenerateMap(parser);

        ArrayList<String> invoke = new ForkJoinPool().invoke(generateMap);

        invoke.stream().forEach(System.out::println);
    }
}



