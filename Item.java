import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Item {
    private String name;
    private double length;
    private static final String EXPORT_FILE = "data/toUserReport.txt";


    public Item(String name, double length) {
        this.name = name;
        this.length = length;
    }

    public Item(String pathMovementsCsv) throws IOException {

        ArrayList<Item> itemsList = new ArrayList<>();
        Map<String, String> specification = new HashMap<>();

        Calculate calculate = new Calculate();
        try {
            List<String> lines = Files.readAllLines(Paths.get(pathMovementsCsv.substring(1)));
            for (String line : lines) {
                line = line.replace(",", ".");
                String[] fragments = line.split(";");
                String[] tempFragments = new String[1];

                try {
                    if (fragments[3].length() > 0) {
                        tempFragments = fragments[3].split("\\s");
                    }

                    if (check(tempFragments[0].substring(0, 1))) {

                        itemsList.add(new Item(
                                fragments[4],
                                Double.parseDouble(tempFragments[0])
                        ));
                        specification.put(
                                fragments[4],
                                tempFragments[0]);
                    }

                } catch (Exception e) {
                }

            }


        } catch (IllegalArgumentException ex) {
            System.out.println(ex.getMessage());
        }

        for (Item i : itemsList) {
            String name = i.getName();
            String price = specification.getOrDefault(name, "");
            price += "," + i.getLength();
            specification.put(name, price);
        }

        try {
            Files.deleteIfExists(Paths.get(EXPORT_FILE.substring(1)));
        } catch (IOException e) {
            System.err.println(e);
        }

        for (Map.Entry<String, String> entry : specification.entrySet()) {
            String answer = "   " + entry.getKey() + "  " + calculate.result(entry.getValue());
            addRecord(answer);
            System.out.println(answer);
        }

    }

    public String getName() {
        return name;
    }

    public Double getLength() {
        return length;
    }


    public static boolean check(String a) {
        Pattern p = Pattern.compile("\\d+");
        Matcher m = p.matcher(a);
        return m.matches();
    }

    public static void addRecord(String text) throws IOException {

        File file = new File(EXPORT_FILE);
        BufferedWriter writer = new BufferedWriter(new FileWriter(file, true));
        writer.write(text);
        writer.flush();
        writer.newLine();
        writer.close();
    }

}
