import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;

import java.io.IOException;
import java.util.*;
import java.util.stream.Collectors;


public class HTMLParser {



    private static List<String> list = new ArrayList<>();

    private String link;
    public List<String> getList() {
        return list;
    }

    public HTMLParser(String link) throws IOException {

        Document doc = Jsoup.connect(link).get();
        Elements elements = doc.select("a");
        List<String> lines = elements.stream().map(element -> element.attr("abs:href"))
                .filter(x -> x.contains(link))
                .collect(Collectors.toList());
        Collections.sort(lines);
        //Set<String> linesSet = new LinkedHashSet<>(lines);
        for (int i = 0; i < lines.size() - 1; i++) {
            if (!lines.get(i).equals(lines.get(i + 1))) {
                list.add(lines.get(i));
            }
        }
    }
}
