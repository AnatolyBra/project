
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.ConcurrentModificationException;
import java.util.concurrent.RecursiveTask;



public class GenerateMap extends RecursiveTask<ArrayList<String>> implements Node {

    private Node node;
    private HTMLParser htmlParser;
    private static String nameFile = "SiteMap.txt";
    public GenerateMap(HTMLParser htmlParser) {
        this.htmlParser = htmlParser;
    }

    public GenerateMap(Node node) {
        this.node = node;
    }


    public GenerateMap(String linkGenerateMap) {
        this.linkGenerateMap = linkGenerateMap;
    }

    public String getLinkGenerateMap() {
        return linkGenerateMap;
    }

    @Override
    public String toString() {
        return getLinkGenerateMap();
    }

    private String linkNode;
    private String linkGenerateMap;
    private ArrayList<Node> linksNode = new ArrayList<>();

    @Override
    public Collection<Node> getChildren() {
        this.linksNode=linksNode;
        return linksNode;
    }

    @Override
    public String getValue() {
        this.linkNode = linkNode;
        return linkNode;
    }
    @Override
    protected ArrayList<String> compute() {
        ArrayList<String> taskList;
        ArrayList<String> answer = new ArrayList<>();
        try {
            ArrayList<Node> links = new ArrayList<>();
        HTMLParser parser = new HTMLParser("https://lenta.ru");

        taskList = new ArrayList<>(parser.getList());

        for (String x : taskList) {
            Node node = new GenerateMap(x);
            links.addAll(node.getChildren());
            GenerateMap generateMap = new GenerateMap(node);

            String[] words = node.toString().split("/");
            StringBuffer text = new StringBuffer("https://lenta.ru/");
            boolean flag = true;
            for (int i = 0; i < words.length; i++) {
                if(flag){
                    addRecord(text.toString());
                    answer.add(text.toString());
                    flag = false;
                }

                if (i > 2) {
                    text = text.append(words[i]).append("/");
                    text.insert(0, "\t");
                    addRecord(text.toString());
                    answer.add(text.toString());
                }
            }


            generateMap.fork();
        }} catch (IOException |ConcurrentModificationException e) {
            e.printStackTrace();
        }


        return answer;
    }

    public static void addRecord(String text) throws IOException {
        File file = new File(nameFile);
        BufferedWriter writer = new BufferedWriter(new FileWriter(file, true));
        writer.write(text);
        writer.flush();
        writer.newLine();
        writer.close();
    }
}

